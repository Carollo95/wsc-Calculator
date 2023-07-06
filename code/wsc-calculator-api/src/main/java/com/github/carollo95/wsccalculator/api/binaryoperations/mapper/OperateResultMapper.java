/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.mapper;

import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateResultDTO;
import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateResultBean;
import org.mapstruct.Mapper;

/**
 * Service mapper for the OperateResult entity
 */
@Mapper(componentModel = "spring")
public interface OperateResultMapper {
    OperateResultDTO beanToDto(OperateResultBean bean);
}
