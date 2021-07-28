package com.zemoso.service;

import com.zemoso.dao.DepartmentsDAO;
import com.zemoso.entities.Departments;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class DepartmentsService implements DepartmentsInterface{

    @Autowired
    DepartmentsDAO departmentsDAO;

    @Override
    public List<Departments> getDepts() {
        return departmentsDAO.findAll();
    }

    @Override
    public Departments getDeptsById(UUID id) throws NotFoundException {
        return departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
    }

    @Override
    public Departments saveDept(String name){
        return departmentsDAO.save(new Departments(name));
    }

    @Override
    public Departments updateDept(UUID id, Departments dept) throws NotFoundException {
        Departments deptartment= departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));

        deptartment.setName(dept.getName());
        departmentsDAO.save(deptartment);

        return deptartment;
    }

    @Override
    public Boolean deleteDept(UUID id) throws NotFoundException {
        boolean flag=false;
        Departments deptartment= departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
        departmentsDAO.delete(deptartment);
        flag=true;
        return flag;
    }


}
