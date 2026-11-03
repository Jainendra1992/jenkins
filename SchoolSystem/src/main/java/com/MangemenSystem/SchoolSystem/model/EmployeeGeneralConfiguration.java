package com.MangemenSystem.SchoolSystem.model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeGeneralConfiguration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
