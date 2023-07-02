/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.enums;


import lombok.Getter;

/**
 * Collection of the operations that can be performed by the calculator
 */
@Getter
public enum OPERATOR {
    UNDEFINED("undefined"),
    SUM("sum");

    private final String value;

    OPERATOR(final String value) {
        this.value = value;
    }


    /**
     * Gets the operator from the value.
     * @param value the value
     * @return the operator or the UNDEFINED operator if it doesn't match with any
     */
    public static OPERATOR fromValue(String value){
        OPERATOR restul = UNDEFINED;
        for (OPERATOR operator : values()) {
            if(operator.value.equals(value)){
                restul = operator;
                break;
            }
        }

        return restul;
    }
}