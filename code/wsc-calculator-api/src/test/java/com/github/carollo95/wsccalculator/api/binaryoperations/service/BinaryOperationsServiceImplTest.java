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
import com.github.carollo95.wsccalculator.api.binaryoperations.mapper.OperateParametersMapper;
import com.github.carollo95.wsccalculator.business.binaryoperations.BinaryOperationBusiness;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BinaryOperationsServiceImplTest {

    @InjectMocks
    private BinaryOperationsServiceImpl target;

    @Mock
    private OperateParametersMapper operateParametersMapper;

    @Mock
    private BinaryOperationBusiness binaryOperationBusiness;

    @Nested
    class OperateBinary {

        @Test
        void when_Called_then_DelegatesOnTheBusiness() {
            final OperateParametersDTO params = new OperateParametersDTO();

            final OperateParametersBean businessParams = new OperateParametersBean();
            when(operateParametersMapper.dtoToBean(params)).thenReturn(businessParams);
            when(binaryOperationBusiness.operateBinary(businessParams)).thenReturn(BigDecimal.ONE);

            final BigDecimal actual = target.operateBinary(params);
            assertEquals(BigDecimal.ONE, actual);
        }
    }

}