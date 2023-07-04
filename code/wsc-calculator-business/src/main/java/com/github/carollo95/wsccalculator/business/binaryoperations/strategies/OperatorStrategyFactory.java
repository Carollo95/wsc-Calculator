/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Factory for retrieving the correct strategy for an operation.
 */
@Component
public class OperatorStrategyFactory {

    /**
     * Returns the correct strategy for the operation
     *
     * @param operator the operator
     * @return the strategy to operate
     */
    public OperatorStrategy getStrategy(OPERATOR operator) {
        Objects.requireNonNull(operator, "The operator can not be null");

        OperatorStrategy result;
        switch (operator) {
            case SUM -> result = new SumOperatorStrategy();
            case SUBTRACT -> result = new SubtractOperatorStrategy();
            default -> throw new IllegalArgumentException("The operation %s is not implemented".formatted(operator));
        }
        return result;
    }
}
