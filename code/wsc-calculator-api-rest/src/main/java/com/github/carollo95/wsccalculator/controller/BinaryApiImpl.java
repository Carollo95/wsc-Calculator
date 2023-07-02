package com.github.carollo95.wsccalculator.controller;

import com.github.carollo95.wsccalculator.restdto.OperateParametersRestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BinaryApiImpl implements BinaryApi {
    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<BigDecimal> operateBinary(final OperateParametersRestDTO operateParametersRestDTO) {
        return BinaryApi.super.operateBinary(operateParametersRestDTO);
    }
}
