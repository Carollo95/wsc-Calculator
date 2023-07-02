/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.mapper;

import com.github.carollo95.wsccalculator.business.binaryoperations.enums.OPERATOR;
import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OperateParametersRestMapperTest {

    @Spy
    private OperateParametersRestMapper target;

    @Nested
    class toBean{
        @Test
        void when_null_then_UNDEFINED(){
            OPERATOR actual = target.toBean(null);
            assertEquals(OPERATOR.UNDEFINED, actual);
        }

        @Test
        void when_SUM_then_SUM(){
            OPERATOR actual = target.toBean(OperateParametersRestDTO.OperatorEnum.SUM);
            assertEquals(OPERATOR.SUM, actual);
        }
    }

}