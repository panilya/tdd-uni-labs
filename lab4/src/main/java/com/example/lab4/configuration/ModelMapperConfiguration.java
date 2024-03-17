package com.example.lab4.configuration;/*
  @author   user
  @project   lab4
  @class  ModelMapperConfiguration
  @version  1.0.0
  @since 07.03.2024 - 00.17
*/

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
