package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.entity.Pin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class PinDaoImpl implements PinDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pin savePin(Pin pin) {
        entityManager.persist(pin);
        return pin;
    }

    @Override
    public List<Pin> getAllPins() {
        return entityManager.createQuery("SELECT p FROM Pin p", Pin.class).getResultList();
    }

    @Override
    public Pin findByPin(String pin) {
        return entityManager.createQuery("SELECT p FROM Pin p WHERE p.pin = :pin", Pin.class)
                .setParameter("pin", pin)
                .getSingleResult();
    }
}
