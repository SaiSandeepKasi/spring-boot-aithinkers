package com.springboot_Rest.Rest_crud_APIS.Service;

import com.springboot_Rest.Rest_crud_APIS.Service.DAO.CustomerDAO;
import com.springboot_Rest.Rest_crud_APIS.Service.DAO.CustomerRepository;
import com.springboot_Rest.Rest_crud_APIS.Service.Entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerrepository) {
        customerRepository= customerrepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer customer = null;
        if(result.isPresent()) {
            customer = result.get();
        }
        else{
            throw new RuntimeException("Customer not found"+id);
        }
        return customer;
    }


    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);

    }
}
