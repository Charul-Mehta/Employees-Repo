package com.zemoso.service;

import com.zemoso.dao.DepartmentsDAO;
import com.zemoso.entities.Department;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class DepartmentsService implements DepartmentsInterface{

    @Autowired
    DepartmentsDAO departmentsDAO;

    public DepartmentsService(DepartmentsDAO departmentsDAO){
        this.departmentsDAO=departmentsDAO;
    }

    @Override
    public List<Department> getDepts() {
        return departmentsDAO.findAll();
    }

    @Override
    public Department getDeptsById(UUID id) throws NotFoundException {
        return departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
    }

    @Override
    public Department saveDept(String name){
        try{
            return departmentsDAO.save(new Department(name));
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Department updateDept(UUID id, Department dept) throws NotFoundException {
        Department deptartment= departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));

        deptartment.setName(dept.getName());
        departmentsDAO.save(deptartment);

        return deptartment;
    }

    @Override
    public Boolean deleteDept(UUID id) throws NotFoundException {
        boolean flag=false;
        Department deptartment= departmentsDAO.findById(id).orElseThrow(()->new NotFoundException("No dept by id :" + id));
        departmentsDAO.delete(deptartment);
        flag=true;
        return flag;
    }


}
