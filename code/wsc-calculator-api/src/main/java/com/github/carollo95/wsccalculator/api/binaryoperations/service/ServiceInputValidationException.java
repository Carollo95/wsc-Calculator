/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.service;

/**
 * Unchecked exception for validations on the service layer
 */
public class ServiceInputValidationException extends RuntimeException {

    /**
     * Creates a new exception
     *
     * @param message the message for the cause
     */
    public ServiceInputValidationException(String message) {
        super(message);
    }

}
