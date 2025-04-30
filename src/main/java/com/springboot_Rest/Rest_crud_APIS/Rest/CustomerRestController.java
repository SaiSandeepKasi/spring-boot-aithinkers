package com.springboot_Rest.Rest_crud_APIS.Rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.springboot_Rest.Rest_crud_APIS.Service.Entity.Customer;
import com.springboot_Rest.Rest_crud_APIS.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private ObjectMapper objectMapper;
    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService,  ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    @GetMapping("/customers")
    public Customer getcustomer(@PathVariable int CustId) {
        Customer customer = customerService.findById(CustId);
        if (customer == null) {
            throw new RuntimeException("Customer not found"+CustId);
        }
        return customer;
    }
    @PostMapping("/customers/{custId}")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        Customer dbCustomer = customerService.save(customer);
        return dbCustomer;
    }
    @GetMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        Customer dbCustomer = customerService.save(customer);
        return dbCustomer;
    }
    //add Mapping for delete/employee/{empId}
    @DeleteMapping("/customer/{custId}")
    public String deleteCustomer(@PathVariable int CustId) {
        Customer customer = customerService.findById(CustId);{

            //throw Exception
            if (customer == null) {
                throw new RuntimeException("Customer not found"+CustId);
            }
            customerService.deleteById(CustId);

            return "Customer deleted" + CustId;
        }
    }
    //add mapping for patch /customer/{custId}
    @PatchMapping("/customer/{custId}")
    public Customer patchCustomer(@PathVariable int custId, @RequestBody Map<String, Object>  patchPayload) {
        Customer Customer1 = customerService.findById(custId);
        if (Customer1 == null) {
            throw new RuntimeException("Customer not found"+custId);
        }
        if(patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Customer id not allowed in Request Body" + custId);
        }
        Customer patchedCustomer = apply(patchPayload,Customer1);

        Customer dbCustomer = customerService.save(patchedCustomer);
        return dbCustomer;
  
    }
    private Customer apply(Map<String,Object>patchPayload, Customer customer1) {

        ObjectNode customerNode = objectMapper.convertValue(customer1,ObjectNode.class);

        ObjectNode patchNode =objectMapper.convertValue(patchPayload,ObjectNode.class);

        customerNode.setAll(patchNode);

        return objectMapper.convertValue(customerNode, Customer.class);
    }
}
