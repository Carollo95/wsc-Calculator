/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.advices;

import io.corp.calculator.TracerImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Advices the log any call to a method on the controller layer
 */
@Aspect
@Component
public class LoggingAdvices {

    @Autowired
    private TracerImpl tracer;

    @Pointcut("execution(public * com.github.carollo95.wsccalculator.controller.*.*(..))")
    private void forControllerPackage() {
        //
    }

    /**
     * Controller logging advice.
     *
     * @param joinPoint the join point
     */
    @Around("forControllerPackage()")
    public Object controllerLoggingAdvice(final ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start("Service call");

        try {
            Object result = joinPoint.proceed();
            stopWatch.stop();
            this.tracer.trace(createMethodCallSuccessfulAsString(joinPoint, stopWatch.getTotalTimeMillis(), result));
            return result;
        } catch (final Throwable t) {
            stopWatch.stop();
            this.tracer.trace(createMethodCallExceptionAsString(joinPoint, stopWatch.getTotalTimeMillis(), t));
            throw t;
        }
    }


    private String createMethodCallSuccessfulAsString(final JoinPoint joinPoint, long totalTimeMillis, Object result) {
        return createMethodCallAsString(joinPoint, totalTimeMillis) + System.lineSeparator() + "Returned: " + result + ")";
    }

    private String createMethodCallAsString(final JoinPoint joinPoint, long totalTimeMills){
        final String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        final String methodName = joinPoint.getSignature().getName();
        final Object[] args = joinPoint.getArgs();

        final List<String> argsStr = new ArrayList<>();
        for (final Object object : args) {
            final String arg = object != null ? object.toString() : "null";
            argsStr.add(arg);
        }

        return "%s::%s(%s) finished in %d ms".formatted(className, methodName, StringUtils.join(argsStr, ", "), totalTimeMills);
    }

    private String createMethodCallExceptionAsString(final JoinPoint joinPoint, long totalTimeMillis, Throwable throwable) {
        return createMethodCallAsString(joinPoint, totalTimeMillis) + System.lineSeparator() + "Threw: " + ExceptionUtils.getStackTrace(throwable) + ")";
    }


}
