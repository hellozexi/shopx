package com.mikey.shopx.exception;

import java.util.Objects;

public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Objects fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Objects fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Objects getFieldValue() {
        return fieldValue;
    }
}
