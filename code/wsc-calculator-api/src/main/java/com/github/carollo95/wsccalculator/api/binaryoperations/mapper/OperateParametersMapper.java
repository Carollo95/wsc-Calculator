/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.api.binaryoperations.mapper;

import com.github.carollo95.wsccalculator.business.binaryoperations.beans.OperateParametersBean;
import com.github.carollo95.wsccalculator.api.binaryoperations.dto.OperateParametersDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperateParametersMapper {

    OperateParametersBean dtoToBean(OperateParametersDTO dto);

}
