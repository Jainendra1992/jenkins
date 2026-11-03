package com.MangemenSystem.SchoolSystem.service;

import com.MangemenSystem.SchoolSystem.dto.EmployeeDto;
import com.MangemenSystem.SchoolSystem.entities.Employee;
import com.MangemenSystem.SchoolSystem.exceptions.ResourceNotFoundException;
import com.MangemenSystem.SchoolSystem.payload.ApiResponse;
import com.MangemenSystem.SchoolSystem.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApiResponse<Employee> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setId(UUID.randomUUID().toString());
        employee.setDatetime(LocalDateTime.now().toString());
        Employee savedEmployee = employeeRepo.save(employee);
        return new ApiResponse<>("Success","Employee Data Created",savedEmployee);
    }

    @Override
    public ApiResponse<List<Employee>> getAllEmployees() {
        List<Employee> AllEmployees = employeeRepo.findAll();
        if(AllEmployees.isEmpty()){
            return new ApiResponse<>("Error","All Employee Data Not Found",AllEmployees);
        }
        return new ApiResponse<>("Success","All Employee Data Found",AllEmployees);
    }

    @Override
    public ApiResponse<Employee> getSingleEmployee(String id) {
        return null;
    }

    @Override
    public ApiResponse<Employee> updateEmployee(String id, EmployeeDto employeeDto) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found With Id " + id));
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        employee.setPosition(employeeDto.getPosition());
        Employee updateEmployee = employeeRepo.save(employee);
        return new ApiResponse<>("Success","Employee data updated success ",updateEmployee);
    }

    @Override
    public ApiResponse<Employee> deleteSingleEmployee(String id) {

        return null;
    }

    @Override
    public ApiResponse<List<Employee>> deleteAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if(employees.isEmpty()){
            return new ApiResponse<>("Success","All Employee Data Not Found",employees);
        }
         employeeRepo.deleteAll();
        return new ApiResponse<>("Success","All Employee Data Deleted",employees);
    }
}
