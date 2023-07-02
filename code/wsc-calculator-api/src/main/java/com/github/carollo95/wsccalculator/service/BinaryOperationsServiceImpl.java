/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.service;

import com.github.carollo95.wsccalculator.dto.OperateParametersDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * Implementation for the {@link BinaryOperationsService}
 */
@Service
public class BinaryOperationsServiceImpl implements BinaryOperationsService {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operateBinary(OperateParametersDTO operateParameters) {
        return null;
    }

}
