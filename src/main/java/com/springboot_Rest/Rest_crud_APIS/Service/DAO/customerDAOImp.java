package com.springboot_Rest.Rest_crud_APIS.Service.DAO;

import com.springboot_Rest.Rest_crud_APIS.Service.Entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class customerDAOImp implements CustomerDAO {

   private EntityManager em;

   @Autowired
   public customerDAOImp(EntityManager Cem) {
       this.em = Cem;
   }

    @Override
    public List<Customer> findAll() {
       TypedQuery<Customer> query = em.createQuery("FROM Customer ", Customer.class);
       List<Customer> customer = query.getResultList();
        return customer;
    }

    @Override
    public Customer findById(int id) {
       Customer customer = em.find(Customer.class, id);
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
       Customer dbCutomer = em.merge(customer);
        return dbCutomer;
    }

    @Override
    public void deleteById(int id) {
       Customer customer = em.find(Customer.class, id);
       em.remove(customer);

    }
}
