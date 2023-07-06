/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory.OperatorStrategyFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Operation strategy for the SUM
 */
@Component
public class SumOperatorStrategy implements OperatorStrategy {

    @Autowired
    private OperatorStrategyFactory factory;

    @PostConstruct
    public void register(){
        this.factory.registerStrategy(OPERATOR.SUM, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operate(List<BigDecimal> operands) {
        Objects.requireNonNull(operands, "The operands must not be null");

        return operands
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
