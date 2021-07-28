package com.zemoso.service;

import com.zemoso.dao.DesignationsDAO;
import com.zemoso.entities.Departments;
import com.zemoso.entities.Designations;
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
    public List<Designations> getDesignation() {
        return designationsDAO.findAll();
    }

    @Override
    public Designations getDesignationById(UUID id) throws NotFoundException {
        return designationsDAO.findById(id).orElseThrow(() -> new NotFoundException("No dept by id :" + id));
    }

    @Override
    public Designations saveDesignation(String name) {
        return designationsDAO.save(new Designations(name));
    }

    @Override
    public Designations updateDesignation(UUID id, Designations des) throws NotFoundException {
        Designations designations = designationsDAO.findById(id).orElseThrow(() -> new NotFoundException("No dept by id :" + id));

        designations.setName(des.getName());
        designationsDAO.save(designations);

        return designations;
    }

    @Override
    public Boolean deleteDesignation(UUID id) throws NotFoundException {
        boolean flag=false;
        Designations designations= designationsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
        designationsDAO.delete(designations);
        flag=true;
        return flag;
    }
}
