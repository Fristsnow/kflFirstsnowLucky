package com.blog.service;

public interface OperationService {

    void insertOperationLog(String httpMethod, String requestUrl, long executionTime);
}
