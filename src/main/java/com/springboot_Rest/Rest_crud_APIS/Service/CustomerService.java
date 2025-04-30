package com.springboot_Rest.Rest_crud_APIS.Service;

import com.springboot_Rest.Rest_crud_APIS.Service.Entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer findById(int id);
    Customer save(Customer customer);
    void deleteById(int id);
}
