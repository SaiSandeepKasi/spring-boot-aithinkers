package com.springboot.jpacrud.DAO;

import com.springboot.jpacrud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee findById(Integer id);
    void save(Employee employee);

    List<Employee> findAll();
    List<Employee> findByEmailContaining(String email);
    void update(Employee employee);

}
