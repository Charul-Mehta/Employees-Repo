package com.zemoso.dao;

import com.zemoso.entities.Departments;
import com.zemoso.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentsDAO extends JpaRepository<Departments, UUID> {
}
