package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Detail;
import com.example.Afternoon.Delights.exception.PinAlreadyExistsException;
import com.example.Afternoon.Delights.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@ControllerAdvice
public class DetailsController {

    private final DetailsService detailService;

    @PostMapping("/afternoon-delights/employee-details")
    public Detail saveDetail(@RequestBody Detail detail) throws PinAlreadyExistsException {
        return detailService.saveDetail(detail);
    }

    @GetMapping("/afternoon-delights/employee-details/employee/{pin}/pin")
    public List<Detail> getMealDetailsForEmployee(@PathVariable String pin,
                                                  @RequestParam LocalDate startDate,
                                                  @RequestParam LocalDate endDate) throws PinAlreadyExistsException {
        return detailService.getMealDetailsForEmployee(pin, startDate, endDate);
    }

    @GetMapping("/afternoon-delights/employee-details/employees")
    public List<Detail> getMealDetailsForAllEmployees(@RequestParam LocalDate startDate,
                                                      @RequestParam LocalDate endDate) {
        return detailService.getMealDetailsForAllEmployees(startDate, endDate);
    }

    @GetMapping("/afternoon-delights/employee-details/employee/{pin}/cost")
    public Double getTotalCostForEmployee(@PathVariable String pin,
                                          @RequestParam LocalDate startDate,
                                          @RequestParam LocalDate endDate) throws PinAlreadyExistsException {
        return detailService.getTotalCostForEmployee(pin, startDate, endDate);
    }

    @GetMapping("/afternoon-delights/employee-details/employee/{pin}/meal-count")
    public Long getTotalMealCountForEmployee(@PathVariable String pin,
                                             @RequestParam LocalDate startDate,
                                             @RequestParam LocalDate endDate) throws PinAlreadyExistsException {
        return detailService.getTotalMealCountForEmployee(pin, startDate, endDate);
    }
}

