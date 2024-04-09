package com.blog.service.impl;

import com.blog.domain.Operations;
import com.blog.mapper.OperationsMapper;
import com.blog.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationsMapper operationsMapper;

    @Override
    public void insertOperationLog(String httpMethod, String requestUrl, long executionTime) {
        Operations operations = new Operations();
        operations.setUsername(1);
        operations.setRecord(requestUrl);
        operations.setRecordMethod(httpMethod);
        operations.setTimeConsuming(String.valueOf(executionTime));
        operations.setUpdatedAt(LocalDateTime.now());
        operations.setCreatedAt(LocalDateTime.now());
        operationsMapper.insert(operations);
    }
}
