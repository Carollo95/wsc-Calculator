/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateResultBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.OperatorStrategy;
import com.github.carollo95.wsccalculator.business.binaryoperations.strategies.factory.OperatorStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

import static com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR.UNDEFINED;

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
    public OperateResultBean operateBinary(final OperateParametersBean operateParameters) {
        validateInputParams(operateParameters);

        final OperatorStrategy operatorStrategy = this.operatorStrategyFactory.getStrategy(operateParameters.getOperator());
        BigDecimal resultValue = operatorStrategy.operate(operateParameters.getOperands());

        return OperateResultBean.builder()
                .result(resultValue)
                .build();
    }

    private static void validateInputParams(final OperateParametersBean operateParameters) {
        Objects.requireNonNull(operateParameters, "The parameters can not be null");
        Objects.requireNonNull(operateParameters.getOperator(), "The operator can not be null");
        if (UNDEFINED.equals(operateParameters.getOperator())) {
            throw new IllegalArgumentException("The operator is not defined");
        }
    }

}
