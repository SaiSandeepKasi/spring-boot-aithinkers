package com.springboot_Rest.Rest_crud_APIS.Exception;

public class EmployeeErrorResponse {

    private int status;
    private String message;
    private int Timestamp;

    public EmployeeErrorResponse(int status, String message, int Timestamp) {
        this.status = status;
        this.message = message;
        this.Timestamp = Timestamp;
    }

    public EmployeeErrorResponse() {

    }

    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public int getTimestamp() {
        return Timestamp;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setTimestamp(int Timestamp) {
        this.Timestamp = Timestamp;
    }

}
