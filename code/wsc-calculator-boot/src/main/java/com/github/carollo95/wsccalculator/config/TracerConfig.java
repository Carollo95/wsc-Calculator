/*
 *  This file is part of wsc-Calculator.
 *  See file LICENSE file for full license details.
 */

package com.github.carollo95.wsccalculator.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Beans for the tracing component
 */
@Configuration
public class TracerConfig {

    @Bean
    public TracerImpl tracer(){
        return new TracerImpl();
    }
}
