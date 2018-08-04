package com.chainbox.safaricom.careerstest.ResponseMessages;

public class Success {

    public int status;
    public String message;

    public Success(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
