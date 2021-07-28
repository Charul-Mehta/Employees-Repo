package com.zemoso.service;

import com.zemoso.entities.Departments;
import com.zemoso.entities.Designations;
import com.zemoso.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface DesignationsInterface {
    List<Designations> getDesignation();

    Designations getDesignationById(UUID id) throws NotFoundException;

    Designations saveDesignation(String name);

    Designations updateDesignation(UUID id, Designations des) throws NotFoundException;

    Boolean deleteDesignation(UUID id) throws NotFoundException;
}
