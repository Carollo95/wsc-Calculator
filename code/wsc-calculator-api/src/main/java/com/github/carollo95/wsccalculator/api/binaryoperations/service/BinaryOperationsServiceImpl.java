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

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperatorDTO;
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateParametersMapper;
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateResultMapper;
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperatorMapper;
import com.github.carollo95.wsccalculator.business.binaryoperations.BinaryOperationBusiness;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateResultBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Implementation for the {@link BinaryOperationsService}
 */
@Service
public class BinaryOperationsServiceImpl implements BinaryOperationsService {

    @Autowired
    private BinaryOperationBusiness binaryOperationBusiness;

    @Autowired
    private OperateParametersMapper operateParametersMapper;
    @Autowired
    private OperateResultMapper operateResultMapper;
    @Autowired
    private OperatorMapper operatorMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OperatorDTO> getBinaryOperators() {
        final List<OPERATOR> validOperators = OPERATOR.getValidOperators();
        return this.operatorMapper.enumListToDto(validOperators);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperateResultDTO operateBinary(OperateParametersDTO operateParameters) {
        validateOperator(operateParameters);
        final OperateParametersBean businessParams = this.operateParametersMapper.dtoToBean(operateParameters);
        OperateResultBean businessResponse = this.binaryOperationBusiness.operateBinary(businessParams);
        return this.operateResultMapper.beanToDto(businessResponse);
    }

    private void validateOperator(OperateParametersDTO operateParameters) {
        if(operateParameters == null || OPERATOR.UNDEFINED.equals(operateParameters.getOperator())){
            throw new ServiceInputValidationException("The operator is not valid");
        }
    }

}
