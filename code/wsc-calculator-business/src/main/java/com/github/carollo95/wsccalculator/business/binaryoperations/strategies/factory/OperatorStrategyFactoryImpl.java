/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Factory for retrieving the correct strategy for an operation.
 */
@Component
public class OperatorStrategyFactoryImpl implements OperatorStrategyFactory {

    private final Map<OPERATOR, OperatorStrategy> strategyByOperator = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    public void registerStrategy(final OPERATOR operatorTarget, final OperatorStrategy strategy) {
        validateStrategyIsValidForOperator(operatorTarget, strategy);
        this.strategyByOperator.put(operatorTarget, strategy);
    }

    private void validateStrategyIsValidForOperator(final OPERATOR operatorTarget, final OperatorStrategy strategy) {
        Objects.requireNonNull(operatorTarget, "The operator can not be null");
        Objects.requireNonNull(strategy, "The strategy can not be null");
        if (strategyByOperator.containsKey(operatorTarget)) {
            throw new IllegalArgumentException("The operation has already a defined strategy");
        }
    }

    /**
     * {@inheritDoc}
     */
    public OperatorStrategy getStrategy(OPERATOR operator) {
        Objects.requireNonNull(operator, "The operator can not be null");

        final OperatorStrategy result = this.strategyByOperator.get(operator);

        if (result == null) {
            throw new IllegalArgumentException("The operation %s is not implemented".formatted(operator));
        }

        return result;
    }
}
