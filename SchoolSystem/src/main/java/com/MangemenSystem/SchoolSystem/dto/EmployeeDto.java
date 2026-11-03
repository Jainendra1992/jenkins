package com.MangemenSystem.SchoolSystem.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @NotBlank(message="Name cannot be empty or blank")
    @Size(min=2, max=50,message ="Name must be 2 to 30 chars")
    private String name;
    @NotBlank(message="Department cannot be empty or blank")
    @Size(min=2, max=50,message ="Department must be 2 to 30 chars")
    private String department;
    @NotBlank(message="Position cannot be empty or blank")
    @Size(min=2, max=50,message ="Position must be 2 to 30 chars")
    private String position;
    @DecimalMin(value="1000.0", message = "salary must be at least 1000.0")
    @DecimalMax(value="100000.0", message = "salary must at the  100000.0")
    private double salary;
}
