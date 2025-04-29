package com.springboot_Rest.Rest_crud_APIS.Rest;

import com.springboot_Rest.Rest_crud_APIS.Exception.EmpIdNotFoundException;
import com.springboot_Rest.Rest_crud_APIS.Exception.EmployeeErrorResponse;
import com.springboot_Rest.Rest_crud_APIS.POJO.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private List<Employee> employees;
    @PostConstruct
    public void loaddata(){
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("sandeep","kasi"));
        employees.add(new Employee("jeevan","vinjam"));

    }


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employees;

    }
    @GetMapping("/employees/{EmpId}")
    public Employee getEmployee(@PathVariable int EmpId){
        if((EmpId>=employees.size())||(EmpId<0)){
            throw new EmpIdNotFoundException("Emp Id not found"+EmpId);
        }
        return employees.get(EmpId);
    }

}
