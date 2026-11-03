package com.MangemenSystem.SchoolSystem.controller;

import com.MangemenSystem.SchoolSystem.dto.EmployeeDto;
import com.MangemenSystem.SchoolSystem.entities.Employee;
import com.MangemenSystem.SchoolSystem.payload.ApiResponse;
import com.MangemenSystem.SchoolSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeMainController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Employee>> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        ApiResponse<Employee> savedEmployeeResponse = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeResponse);

    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        ApiResponse<List<Employee>> allEmployees = employeeService.getAllEmployees();

        return ResponseEntity.ok(allEmployees);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        ApiResponse<Employee> response = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<ApiResponse<List<Employee>>> deleteAllEmployees() {
        ApiResponse<List<Employee>> deleteAllEmployees = employeeService.deleteAllEmployees();
        return ResponseEntity.ok(deleteAllEmployees);


    }
}
