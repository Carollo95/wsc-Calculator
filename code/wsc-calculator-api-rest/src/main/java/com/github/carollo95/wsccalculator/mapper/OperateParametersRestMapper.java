/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.mapper;

import com.github.carollo95.wsccalculator.binaryoperations.dto.OperateParametersDTO;
import com.github.carollo95.wsccalculator.enums.OPERATOR;
import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the rest interface of the OperateParameter entity
 */
@Mapper(componentModel = "spring")
public interface OperateParametersRestMapper {

    OperateParametersDTO restDtoToDTO(OperateParametersRestDTO restDTO);

    default OPERATOR toBean(OperateParametersRestDTO.OperatorEnum restEnum) {
        return OPERATOR.fromValue(restEnum.getValue());
    }
}
