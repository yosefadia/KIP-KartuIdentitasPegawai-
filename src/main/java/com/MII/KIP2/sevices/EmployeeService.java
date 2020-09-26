/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.sevices;

import com.MII.KIP2.entities.Employee;
import com.MII.KIP2.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository emp;
    
    public List<Employee> getAll(){
        return emp.findAll();
    }
    public String checkname(int id){
        return emp.findById(id).get().getFirstName();
    }
    
    public Employee getById(int id){
        return emp.findById(id).get();
    }
    
    
}
