/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.business.binaryoperations;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Implementation of {@link BinaryOperationBusiness}
 */
@Component
public class BinaryOperationBusinessImpl implements BinaryOperationBusiness {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operateBinary(OperateParametersBean operateParameters) {
        return null;
    }

}
