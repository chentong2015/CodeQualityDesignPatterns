package refactoring.restclient;

import org.springframework.http.HttpMethod;

public class RestRequest {

    public static final int DEFAULT_RETRY_COUNT = 3;
    String requestUrl;
    Object requestBody;
    HttpMethod requestMethod;
    int retryCount;
    String requestId;

    public RestRequest() {
        this.retryCount = 3;
    }

    public RestRequest(String requestUrl) {
        this(requestUrl, (Object)null, HttpMethod.GET);
    }

    public RestRequest(String requestUrl, Object requestBody) {
        this(requestUrl, requestBody, HttpMethod.POST);
    }

    public RestRequest(String requestUrl, Object requestBody, HttpMethod method) {
        this.retryCount = 3;
        this.setRequestUrl(requestUrl);
        this.setRequestBody(requestBody);
        this.setRequestMethod(method);
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public RestRequest setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    public Object getRequestBody() {
        return this.requestBody;
    }

    public RestRequest setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public HttpMethod getRequestMethod() {
        return this.requestMethod;
    }

    public RestRequest setRequestMethod(HttpMethod requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public RestRequest setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RestRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
