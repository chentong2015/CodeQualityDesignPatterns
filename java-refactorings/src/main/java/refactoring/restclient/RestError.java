package refactoring.restclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.HashMap;

public class RestError {

    int errorCode;
    String errorMessage;
    String developerMessage;
    String moreInfoUrl;
    HashMap<String, Object> info = new HashMap();

    public RestError() {
    }

    public RestError(int errorCode, String errorMessage) {
        this.setErrorCode(errorCode);
        this.setErrorMessage(errorMessage);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public RestError setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getMoreInfoURL() {
        return this.moreInfoUrl;
    }

    public RestError setMoreInfoURL(String moreInfo) {
        this.moreInfoUrl = moreInfo;
        if (moreInfo == null && this.errorCode > 0) {
            this.moreInfoUrl = "http://www.accuity.com/wiki/errorcodes/" + this.errorCode;
        }

        return this;
    }

    public RestError addInfo(String key, String value) {
        this.info.put(key, value);
        return this;
    }

    @JsonUnwrapped
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public HashMap<String, Object> getInfo() {
        return this.info;
    }

    public RestError setInfo(HashMap<String, Object> info) {
        this.info = info;
        return this;
    }
}
