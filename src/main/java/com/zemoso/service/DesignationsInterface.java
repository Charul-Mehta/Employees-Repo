package com.zemoso.service;

import com.zemoso.entities.Designation;
import com.zemoso.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface DesignationsInterface {
    List<Designation> getDesignation();

    Designation getDesignationById(UUID id) throws NotFoundException;

    Designation saveDesignation(String name);

    Designation updateDesignation(UUID id, Designation des) throws NotFoundException;

    Boolean deleteDesignation(UUID id) throws NotFoundException;
}
