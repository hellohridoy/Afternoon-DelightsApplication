package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dao.DetailsDao;
import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.exception.PinAlreadyExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DetailsServiceImpl implements DetailsService {

    private final DetailsDao detailDao;
    @PersistenceContext
    private EntityManager entityManager;

    // Save Detail with Pin existence check
    @Override
    @Transactional
    public Detail saveDetail(Detail detail) throws PinAlreadyExistsException {
        Pin pin = detail.getPin();

        // Check if Pin already exists before persisting
        if (pin != null && pin.getId() == null) {
            if (pinExists(pin.getPin())) {
                throw new PinAlreadyExistsException("Pin " + pin.getPin() + " already exists.");
            }
            entityManager.persist(pin); // Persist Pin if it doesn't exist
        }

        entityManager.persist(detail); // Persist the Detail entity
        return detail;
    }

    // Method to check if Pin exists
    private boolean pinExists(String pin) {
        return entityManager.createQuery("SELECT COUNT(p) FROM Pin p WHERE p.pin = :pin", Long.class)
                .setParameter("pin", pin)
                .getSingleResult() > 0;
    }

    @Override
    public List<Detail> getMealDetailsForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException {
        // Check if Pin exists before returning details
        if (!pinExists(pin)) {
            throw new PinAlreadyExistsException("Pin " + pin + " does not exist.");
        }
        return detailDao.findByPinAndDateRange(pin, startDate, endDate);
    }

    @Override
    public List<Detail> getMealDetailsForAllEmployees(LocalDate startDate, LocalDate endDate) {
        return detailDao.findAllByDateRange(startDate, endDate);
    }

    @Override
    public Double getTotalCostForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException {
        // Check if Pin exists before calculating total cost
        if (!pinExists(pin)) {
            throw new PinAlreadyExistsException("Pin " + pin + " does not exist.");
        }
        return detailDao.getTotalCostForEmployeeInMonth(pin, startDate, endDate);
    }

    @Override
    public Long getTotalMealCountForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException {
        // Check if Pin exists before calculating meal count
        if (!pinExists(pin)) {
            throw new PinAlreadyExistsException("Pin " + pin + " does not exist.");
        }
        return detailDao.getTotalMealCountForEmployeeInMonth(pin, startDate, endDate);
    }
}
