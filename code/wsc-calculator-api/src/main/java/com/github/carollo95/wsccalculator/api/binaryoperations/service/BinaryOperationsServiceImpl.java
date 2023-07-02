/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.service;

import com.github.carollo95.wsccalculator.business.binaryoperations.BinaryOperationBusiness;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateParametersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * Implementation for the {@link BinaryOperationsService}
 */
@Service
public class BinaryOperationsServiceImpl implements BinaryOperationsService {

    @Autowired
    private OperateParametersMapper operateParametersMapper;

    @Autowired
    private BinaryOperationBusiness binaryOperationBusiness;

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal operateBinary(OperateParametersDTO operateParameters) {
        final OperateParametersBean businessParams = this.operateParametersMapper.dtoToBean(operateParameters);
        return this.binaryOperationBusiness.operateBinary(businessParams);
    }

}
