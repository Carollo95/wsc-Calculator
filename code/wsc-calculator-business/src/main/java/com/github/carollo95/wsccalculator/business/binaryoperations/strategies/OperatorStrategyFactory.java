/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;

import static com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR.SUM;

/**
 * Factory for retrieving the correct strategy for an operation.
 */
public class OperatorStrategyFactory {

    private OperatorStrategyFactory() {
        //Not implemented
    }

    /**
     * Returns the correct strategy for the operation
     *
     * @param operator the operator
     * @return the strategy to operate
     */
    public static OperatorStrategy getStrategy(OPERATOR operator) {
        OperatorStrategy result;
        switch (operator) {
            case SUM -> result = new SumOperatorStrategy();
            default -> throw new IllegalArgumentException("The operation {} is not implemented".formatted(operator));
        }
        return result;
    }
}
