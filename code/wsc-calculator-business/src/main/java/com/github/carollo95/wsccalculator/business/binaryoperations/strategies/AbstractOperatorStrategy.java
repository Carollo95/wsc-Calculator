/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations.strategies;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory.OperatorStrategyFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Common code for the implementations of the {@link OperatorStrategy}
 */
public abstract class AbstractOperatorStrategy implements OperatorStrategy {

    @Autowired
    private OperatorStrategyFactory factory;

    /**
     * Gets the operator associated with this strategy
     *
     * @return the operator associated with this strategy
     */
    protected abstract OPERATOR getOperator();


    @PostConstruct
    public void register() {
        this.factory.registerStrategy(getOperator(), this);
    }

}
