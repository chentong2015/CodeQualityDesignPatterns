package refactoring.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

public class RestClient {

    private Logger LOGGER;
    private final String serviceName;
    private final String serviceBasePath;
    private final RestTemplate restTemplate;
    private final boolean sslEnabled;
    private Logger logger;
    private boolean throwWhenUnavailable;
    private boolean throwOnError;

    public RestClient(String serviceName, RestTemplate restTemplate) {
        this(serviceName, restTemplate, serviceName, true);
    }

    public RestClient(String serviceName, RestTemplate restTemplate, boolean sslEnabled) {
        this(serviceName, restTemplate, serviceName, sslEnabled);
    }

    public RestClient(String serviceName, RestTemplate restTemplate, String serviceBasePath) {
        this(serviceName, restTemplate, serviceName, true);
    }

    public RestClient(String serviceName, RestTemplate restTemplate, String serviceBasePath, boolean sslEnabled) {
        this.LOGGER = LoggerFactory.getLogger(RestClient.class);
        this.logger = LoggerFactory.getLogger(RestClient.class);
        this.throwWhenUnavailable = true;
        this.throwOnError = false;
        this.serviceName = serviceName;
        this.restTemplate = restTemplate;
        this.serviceBasePath = serviceBasePath;
        this.sslEnabled = sslEnabled;
    }

    public <T> RestResponse<T> query(RestRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return this.query(request, request.getRetryCount(), headers, (httpHeaders) -> request.getRequestBody() != null ? new HttpEntity(request.getRequestBody(), headers) : new HttpEntity(headers));
    }

    public <T> ResponseEntity<T> query(RestRequest request, Class<T> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return this.queryInternal(request, new ParameterizedTypeReference<T>() {
        }, request.getRetryCount(), headers, (httpHeaders) -> request.getRequestBody() != null ? new HttpEntity(request.getRequestBody(), headers) : new HttpEntity(headers));
    }

    public <T> ResponseEntity<T> query(RestRequest request, ParameterizedTypeReference<T> parameterizedTypeReference) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return this.queryInternal(request, parameterizedTypeReference, request.getRetryCount(), headers, (httpHeaders) -> request.getRequestBody() != null ? new HttpEntity(request.getRequestBody(), headers) : new HttpEntity(headers));
    }

    public RestResponse<Object> query(RestRequest request, HttpHeaders headers) {
        return this.query(request, request.getRetryCount(), headers, (httpHeaders) -> request.getRequestBody() != null ? new HttpEntity(request.getRequestBody(), headers) : new HttpEntity(headers));
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public RestClient setThrowWhenUnavailable(boolean throwWhenUnavailable) {
        this.throwWhenUnavailable = throwWhenUnavailable;
        return this;
    }

    public boolean isThrowWhenUnavailable() {
        return this.throwWhenUnavailable;
    }

    public void setThrowOnError(boolean throwOnError) {
        this.throwOnError = throwOnError;
    }

    public boolean isThrowOnError() {
        return this.throwOnError;
    }

    private <T, B> RestResponse<T> query(RestRequest request, int remainingAttempts, HttpHeaders headers, Function<HttpHeaders, HttpEntity<B>> function) {
        ResponseEntity<RestResponse<T>> responseEntity = this.queryInternal(request, new ParameterizedTypeReference<RestResponse<T>>() {
        }, remainingAttempts, headers, function);
        if (null != responseEntity) {
            RestResponse<T> body = (RestResponse)responseEntity.getBody();
            if (body == null) {
                return new RestResponse(responseEntity.getStatusCode().value());
            } else {
                body.setHttpStatus(HttpStatus.valueOf(responseEntity.getStatusCode().value()));
                return body;
            }
        } else {
            return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private <T, B> ResponseEntity<T> queryInternal(RestRequest request, ParameterizedTypeReference<T> parameterizedTypeReference, int remainingAttempts, HttpHeaders headers, Function<HttpHeaders, HttpEntity<B>> function) {
        String url = null;

        try {
            String requestUrl = request.getRequestUrl();
            requestUrl = requestUrl.startsWith("/") ? requestUrl : "/" + requestUrl;
            String protocol = this.sslEnabled ? "https://" : "http://";
            if (StringUtils.isEmpty(this.serviceBasePath)) {
                url = protocol + this.serviceName + requestUrl;
            } else {
                url = protocol + this.serviceName + "/" + this.serviceBasePath + requestUrl;
            }

            HttpEntity<B> httpEntity = (HttpEntity)function.apply(headers);
            ResponseEntity<T> responseEntity = this.restTemplate.exchange(url, request.getRequestMethod(), httpEntity, parameterizedTypeReference, new Object[0]);
            return responseEntity;
        } catch (Exception e) {
            if (this.isThrowOnError()) {
                throw e;
            } else {
                this.LOGGER.error("Exception calling url '" + url + "': " + e.getMessage());
                this.LOGGER.debug("", e);
                if (e instanceof HttpStatusCodeException) {
                    HttpStatusCodeException exception = (HttpStatusCodeException)e;
                    this.LOGGER.error("'" + url + "' return error code " + exception.getStatusCode());
                    return new ResponseEntity(exception.getStatusCode());
                } else {
                    return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
                }
            }
        }
    }
}
