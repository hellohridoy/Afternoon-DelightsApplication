package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.entity.Balance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDaoImpl implements BalanceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Balance balance) {
        entityManager.persist(balance);
    }
}
