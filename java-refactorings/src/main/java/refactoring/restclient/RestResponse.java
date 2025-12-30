package refactoring.restclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = -8655793489572515974L;
    HttpStatus httpStatus;
    int httpCode;
    String httpMessage;
    String message;
    Long count;
    Long totalCount;
    Long startIndex;
    Long endIndex;
    Integer errorCount;
    List<RestError> errors;
    Object data;
    URI createdUri;

    public RestResponse() {
        this.errorCount = 0;
    }

    public RestResponse(HttpStatus status) {
        this(status, (String)null);
    }

    public RestResponse(int status) {
        this(HttpStatus.valueOf(status));
    }

    public RestResponse(HttpStatus status, String message) {
        this.errorCount = 0;
        this.setHttpStatus(status);
        this.setMessage(message);
    }

    public RestResponse(HttpStatus status, RestError error) {
        this.errorCount = 0;
        this.setHttpStatus(status);
        this.addError(error);
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    @JsonIgnore
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public RestResponse<T> setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.httpCode = httpStatus.value();
        this.httpMessage = httpStatus.getReasonPhrase();
        return this;
    }

    public String getHttpMessage() {
        return this.httpMessage;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getMessage() {
        return this.message;
    }

    public RestResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long getCount() {
        return this.count != null ? this.count : 0L;
    }

    public RestResponse<T> setCreatedUri(String createdUri) {
        try {
            this.createdUri = new URI(createdUri);
        } catch (URISyntaxException var3) {
        }

        return this;
    }

    @JsonIgnore
    public URI getCreatedUri() {
        return this.createdUri;
    }

    public RestResponse<T> setCount(Long count) {
        this.count = count;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long getTotalCount() {
        return this.totalCount;
    }

    public RestResponse<T> setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long getStartIndex() {
        return this.startIndex;
    }

    public RestResponse<T> setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Long getEndIndex() {
        return this.endIndex;
    }

    public RestResponse<T> setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer getErrorCount() {
        return this.errorCount;
    }

    public RestResponse<T> setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RestError> getErrors() {
        return this.errors;
    }

    @JsonIgnore
    public boolean hasErrors() {
        return this.getHttpCode() > 400 || this.errors != null && this.errors.size() > 0;
    }

    public RestResponse<T> setErrors(List<RestError> errors) {
        this.errors = errors;
        return this;
    }

    @JsonIgnore
    public T getDataAsRecord() {
        Object o = this.data;
        if (o instanceof List<T> list) {
            return (T)(list.size() > 0 ? list.get(0) : null);
        } else {
            return (T)o;
        }
    }

    @JsonIgnore
    public List<T> getDataAsList() {
        Object o = this.data;
        if (o instanceof List) {
            return (List)o;
        } else {
            List<T> list = new ArrayList();
            if (o != null) {
                list.add(o);
            }

            return list;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object getData() {
        return this.errors != null && !this.errors.isEmpty() ? null : this.data;
    }

    public RestResponse<T> setData(T item) {
        if (item instanceof List) {
            this.setDataAsList(item);
        } else {
            this.setDataAsRecord(item);
        }

        return this;
    }

    public RestResponse<T> setDataAsRecord(T item) {
        this.data = item;
        this.setTotalCount(1L);
        this.setCount(1L);
        return this;
    }

    public RestResponse<T> setDataAsList(Object data) {
        if (data instanceof List<T> list) {
            this.setCount((long)list.size());
            if (this.getTotalCount() == null) {
                this.setTotalCount(this.getCount());
            }

            if (this.getStartIndex() == null && !list.isEmpty()) {
                this.setStartIndex(1L);
            }

            if (this.getEndIndex() == null) {
                this.setEndIndex(this.getCount());
            }

            this.setMessage(this.getCount() + " record(s) retrieved.");
            this.data = data;
        } else {
            this.setDataAsList(Arrays.asList(data));
        }

        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.getHttpCode() < 400;
    }

    public RestResponse<T> addError(int errorCode, String errorMessage, String devMessage, String moreInfo) {
        RestError err = new RestError(errorCode, errorMessage);
        err.setDeveloperMessage(devMessage);
        err.setMoreInfoURL(moreInfo);
        this.addError(err);
        return this;
    }

    public RestResponse<T> addError(int errorCode, String errorMessage) {
        this.addError(errorCode, errorMessage, (String)null, (String)null);
        return this;
    }

    public RestResponse<T> addError(int errorCode, String errorMessage, String devMessage) {
        this.addError(errorCode, errorMessage, devMessage, (String)null);
        return this;
    }

    public RestResponse<T> addError(RestError error) {
        if (this.errors == null) {
            this.errors = new ArrayList();
        }

        this.errors.add(error);
        Integer var2 = this.errorCount;
        this.errorCount = this.errorCount + 1;
        return this;
    }
}
