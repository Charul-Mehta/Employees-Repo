package com.zemoso.service;

import com.zemoso.dao.DesignationsDAO;
import com.zemoso.entities.Designation;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DesignationsService implements DesignationsInterface {

    @Autowired
    DesignationsDAO designationsDAO;

    @Override
    public List<Designation> getDesignation() {
        return designationsDAO.findAll();
    }

    @Override
    public Designation getDesignationById(UUID id) throws NotFoundException {
        return designationsDAO.findById(id).orElseThrow(() -> new NotFoundException("No dept by id :" + id));
    }

    @Override
    public Designation saveDesignation(String name) {
        return designationsDAO.save(new Designation(name));
    }

    @Override
    public Designation updateDesignation(UUID id, Designation des) throws NotFoundException {
        Designation designations = designationsDAO.findById(id).orElseThrow(() -> new NotFoundException("No dept by id :" + id));

        designations.setName(des.getName());
        designationsDAO.save(designations);

        return designations;
    }

    @Override
    public Boolean deleteDesignation(UUID id) throws NotFoundException {
        boolean flag=false;
        Designation designations= designationsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
        designationsDAO.delete(designations);
        flag=true;
        return flag;
    }
}
