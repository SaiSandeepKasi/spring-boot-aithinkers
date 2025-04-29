package com.springboot_Rest.Rest_crud_APIS.Exception;

public class EmpIdNotFoundException extends RuntimeException {
    public EmpIdNotFoundException(String message) {
        super(message);
    }
}
