/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.enums;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Collection of the operations that can be performed by the calculator
 */
@Getter
public enum OPERATOR {
    UNDEFINED("undefined"),
    SUM("sum"),
    SUBTRACT("subtract");

    private final String name;

    OPERATOR(final String name) {
        this.name = name;
    }


    /**
     * Gets the operator from the name.
     *
     * @param name the name
     * @return the operator or the UNDEFINED operator if it doesn't match with any
     */
    public static OPERATOR fromName(String name) {
        OPERATOR result = UNDEFINED;
        for (OPERATOR operator : values()) {
            if (operator.name.equals(name)) {
                result = operator;
                break;
            }
        }

        return result;
    }

    /**
     * Returns the list of valid operators
     * @return the list of valid operators
     */
    public static List<OPERATOR> getValidOperators() {
        return Arrays.stream(OPERATOR.values())
                .filter(o -> !UNDEFINED.equals(o))
                .collect(Collectors.toList());
    }
}