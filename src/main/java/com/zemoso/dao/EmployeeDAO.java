package com.zemoso.dao;

import com.zemoso.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDAO extends JpaRepository<Employee, UUID> {
}
