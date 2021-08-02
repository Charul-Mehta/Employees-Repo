package com.zemoso.dao;

import com.zemoso.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentsDAO extends JpaRepository<Department, UUID> {
}
