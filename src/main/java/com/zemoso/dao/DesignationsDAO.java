package com.zemoso.dao;

import com.zemoso.entities.Designations;
import com.zemoso.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DesignationsDAO extends JpaRepository<Designations, UUID> {
}
