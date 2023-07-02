/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Implementation of {@link BinaryOperationBusiness}
 */
@Component
public class BinaryOperationBusinessImpl implements BinaryOperationBusiness {

    @Autowired
    private OperatorStrategyFactory operatorStrategyFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operateBinary(final OperateParametersBean operateParameters) {
        validateInputParams(operateParameters);
        final OperatorStrategy operatorStrategy = this.operatorStrategyFactory.getStrategy(operateParameters.getOperator());
        return operatorStrategy.operate(operateParameters.getOperands());
    }

    private static void validateInputParams(final OperateParametersBean operateParameters) {
        Objects.requireNonNull(operateParameters, "The parameters can not be null");
        Objects.requireNonNull(operateParameters, "The operator can not be null");
    }

}
