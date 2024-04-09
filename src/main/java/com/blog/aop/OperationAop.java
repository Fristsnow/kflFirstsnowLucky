package com.blog.aop;

import com.blog.service.OperationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class OperationAop {

    @Autowired
    private OperationService operationService;

    @Autowired
    private HttpServletRequest request;

    // 定义切点
    @Around("execution(* com.blog.controller.*.*(..))") //切入点表达式
    public Object logRequest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String httpMethod = request.getMethod();
        String requestUrl = request.getRequestURI();
//        // 1, 开始时间
        long begin = System.currentTimeMillis();
//        // 2, 调用原始方法执行
        Object proceed = proceedingJoinPoint.proceed();
//        // 3， 结束时间
        long end = System.currentTimeMillis();
        // 4， 计算执行时间
        long executionTime = end - begin;

        log.info(proceedingJoinPoint.getSignature() + "方法耗时: {}ms", executionTime);
        // 将请求方式和 URL 写入到指定的 SQL 表中
        operationService.insertOperationLog(httpMethod, requestUrl, executionTime);

        return proceed;
    }
}
// Aspect

// controller 层

// service 层
// mapper 层
