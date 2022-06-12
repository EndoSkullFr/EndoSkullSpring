package fr.endoskull.EndoSkullSpring.utils;

public class Error {

    private String errorType;
    private String errorMessage;
    private int errorCode;

    public Error(String errorType, String errorMessage, int errorCode) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
