/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Operation strategy for the SUBTRACTION
 */
public class SubtractOperatorStrategy implements OperatorStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operate(List<BigDecimal> operands) {
        validateOperands(operands);

        return operands.subList(1, operands.size())
                .stream()
                .reduce(operands.get(0), BigDecimal::subtract);
    }

    private static void validateOperands(List<BigDecimal> operands) {
        Objects.requireNonNull(operands, "The operands must not be null");
        if (operands.size() < 1) {
            throw new IllegalArgumentException("The list of operands can not be empty for subtraction");
        }
    }
}
