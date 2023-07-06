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
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateParametersMapper;
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateResultMapper;
import com.github.carollo95.wsccalculator.business.binaryoperations.BinaryOperationBusiness;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateResultBean;
import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BinaryOperationsServiceImplTest {

    @InjectMocks
    private BinaryOperationsServiceImpl target;

    @Mock
    private OperateParametersMapper operateParametersMapper;
    @Mock
    private OperateResultMapper operateResultMapper;

    @Mock
    private BinaryOperationBusiness binaryOperationBusiness;

    @Nested
    class OperateBinary {

        @Test
        void when_Called_then_DelegatesOnTheBusiness() {
            final OperateParametersDTO params = OperateParametersDTO.builder()
                    .operator(OPERATOR.SUM)
                    .build();

            final OperateParametersBean businessParams = new OperateParametersBean();
            when(operateParametersMapper.dtoToBean(params)).thenReturn(businessParams);
            final OperateResultBean businessResult = new OperateResultBean();
            when(binaryOperationBusiness.operateBinary(businessParams)).thenReturn(businessResult);
            final OperateResultDTO result = new OperateResultDTO();
            when(operateResultMapper.beanToDto(businessResult)).thenReturn(result);

            final OperateResultDTO actual = target.operateBinary(params);
            assertEquals(result, actual);
        }

        @Test
        void when_null_then_ServiceInputValidationException() {
            assertThrows(ServiceInputValidationException.class, () -> target.operateBinary(null));
        }
        @Test
        void when_operatorIsUNDEFINED_then_ServiceInputValidationException() {
            final OperateParametersDTO params = OperateParametersDTO.builder()
                    .operator(OPERATOR.UNDEFINED)
                    .build();

            assertThrows(ServiceInputValidationException.class, () -> target.operateBinary(params));
        }
    }

}