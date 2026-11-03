package com.MangemenSystem.SchoolSystem.service;

import com.MangemenSystem.SchoolSystem.dto.EmployeeDto;
import com.MangemenSystem.SchoolSystem.entities.Employee;
import com.MangemenSystem.SchoolSystem.payload.ApiResponse;

import java.util.List;

public interface EmployeeService {
    ApiResponse<Employee> saveEmployee(EmployeeDto  employeeDto);
    ApiResponse<List<Employee>> getAllEmployees();
    ApiResponse<Employee> getSingleEmployee(String id);
    ApiResponse<Employee> updateEmployee(String id,EmployeeDto employeeDto);
    ApiResponse<Employee> deleteSingleEmployee(String id);
    ApiResponse<List<Employee>> deleteAllEmployees();
}
