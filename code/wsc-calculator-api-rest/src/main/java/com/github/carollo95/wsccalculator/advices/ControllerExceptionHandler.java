/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.advices;

import com.github.carollo95.wsccalculator.api.binaryoperations.service.ServiceInputValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.carollo95.wsccalculator.restdto.ErrorInformationRestDTO;

/**
 * Advice that captures all the exceptions thrown from the Controller layer and properly returns the appropriate response.
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private ControllerExceptionHandler() {
        //Not instantiable
    }

    /**
     * Handler for the bad requests
     *
     * @param e the exception
     * @return the response with the exception message
     */
    @ExceptionHandler({
            ServiceInputValidationException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class
    })
    private ResponseEntity<ErrorInformationRestDTO> badParametersHandler(final Exception e) {
        final ErrorInformationRestDTO errorInfo = new ErrorInformationRestDTO("The parameters are not valid");
        return ResponseEntity.badRequest().body(errorInfo);
    }

    /**
     * Handler for invalid operation
     * @param e the exception
     * @return the response with the exception message
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<ErrorInformationRestDTO> operationNotValidHandler(final Exception e) {
        final ErrorInformationRestDTO errorInfo = new ErrorInformationRestDTO("The operation is not valid");
        return ResponseEntity.status(HttpStatusCode.valueOf(405)).body(errorInfo);
    }

    /**
     * Generic exception handler.
     *
     * @param e the exception
     * @return an error response entity
     */
    @ExceptionHandler
    private ResponseEntity<ErrorInformationRestDTO> genericExceptionHandler(final Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        final ErrorInformationRestDTO errorInfo = new ErrorInformationRestDTO("An internal error occurred. Please contact the administrator");
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
