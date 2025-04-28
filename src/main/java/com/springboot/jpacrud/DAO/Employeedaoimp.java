package com.springboot.jpacrud.DAO;

import com.springboot.jpacrud.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Employeedaoimp implements EmployeeDAO {


    //define Entity manager
    private EntityManager em;

    //injecting entity manager
    public Employeedaoimp(EntityManager entityManager) {
        this.em = entityManager;

    }

    @Override
    public Employee findById(Integer id) {
        return em.find(Employee.class,id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("FROM Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByEmailContaining(String email) {
        //create query
        TypedQuery<Employee> thequery=em.createQuery("FROM Employee WHERE email = :email",Employee.class);
        //set query parameters
        thequery.setParameter("email", email);
        //return
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        em.merge(employee);
    }

    @Override
    @Transactional
    public void delete(Integer Id) {
      Employee emp = em.find(Employee.class,Id);
      em.remove(emp);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedrows=em.createQuery("Delete from Employee").executeUpdate();
        return deletedrows;
    }
}
