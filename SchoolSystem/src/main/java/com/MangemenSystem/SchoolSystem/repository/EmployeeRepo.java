package com.MangemenSystem.SchoolSystem.repository;

import com.MangemenSystem.SchoolSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {
}
