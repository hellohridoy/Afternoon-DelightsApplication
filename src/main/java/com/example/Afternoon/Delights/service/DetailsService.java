package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.entity.Pin;
import com.example.Afternoon.Delights.exception.PinAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;

public interface DetailsService {

    Detail saveDetail(Detail detail) throws PinAlreadyExistsException;

    List<Detail> getMealDetailsForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException;

    List<Detail> getMealDetailsForAllEmployees(LocalDate startDate, LocalDate endDate);

    Double getTotalCostForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException;

    Long getTotalMealCountForEmployee(String pin, LocalDate startDate, LocalDate endDate) throws PinAlreadyExistsException;
}
