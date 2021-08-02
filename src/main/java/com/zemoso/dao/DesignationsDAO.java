package com.zemoso.dao;

import com.zemoso.entities.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DesignationsDAO extends JpaRepository<Designation, UUID> {
}
