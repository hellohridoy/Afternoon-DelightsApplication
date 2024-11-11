package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.entity.Detail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DetailDaoImpl implements DetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Detail saveDetail(Detail detail) {
        entityManager.persist(detail);
        return detail;
    }

    @Override
    public List<Detail> findByPinAndDateRange(String pin, LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT d FROM Detail d WHERE d.pin.pin = :pin AND d.date BETWEEN :startDate AND :endDate", Detail.class)
                .setParameter("pin", pin)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Detail> findAllByDateRange(LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT d FROM Detail d WHERE d.date BETWEEN :startDate AND :endDate", Detail.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public Double getTotalCostForEmployeeInMonth(String pin, LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT SUM(d.totalCost) FROM Detail d WHERE d.pin.pin = :pin AND d.date BETWEEN :startDate AND :endDate", Double.class)
                .setParameter("pin", pin)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
    }

    @Override
    public Long getTotalMealCountForEmployeeInMonth(String pin, LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT COUNT(d) FROM Detail d WHERE d.pin.pin = :pin AND d.date BETWEEN :startDate AND :endDate AND d.isEat = true", Long.class)
                .setParameter("pin", pin)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
    }
}
