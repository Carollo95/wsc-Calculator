/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Operation strategy for the SUBTRACTION
 */
@Component
public class SubtractOperatorStrategy extends AbstractOperatorStrategy {

    /**
     * {@inheritDoc}
     */
    @Override
    protected OPERATOR getOperator() {
        return OPERATOR.SUBTRACT;
    }

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
        if (operands.isEmpty()) {
            throw new IllegalArgumentException("The list of operands can not be empty for subtraction");
        }
    }

}
