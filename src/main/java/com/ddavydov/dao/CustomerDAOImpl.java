package com.ddavydov.dao;

import com.ddavydov.entity.Customer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> customerQuery = session.createQuery("from Customer ORDER BY lastName",
                Customer.class);

        return customerQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query customerQuery = session.createQuery("delete from Customer where id=:customerId");
        customerQuery.setParameter("customerId", id);

        customerQuery.executeUpdate();
    }
}
