/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
     * Generic exception handler.
     *
     * @param e the exception
     * @return an error response entity
     */
    @ExceptionHandler
    private static ResponseEntity<String> genericExceptionHandler(final Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity<>("An internal error occurred. Please contact the administrator",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
