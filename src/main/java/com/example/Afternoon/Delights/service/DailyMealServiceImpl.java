package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.DailyMealDetailsDTO;
import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.repository.DailyMealRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DailyMealServiceImpl implements DailyMealService {

    @Autowired
    private DailyMealRepository dailyMealRepository;

    public List<DailyMeal> getAllDailyMeals(){
        return dailyMealRepository.findAll();
    }

    public Optional<DailyMeal> getDailyMealById(Long id){
        return dailyMealRepository.findById(id);
    }

    @Override
    public DailyMeal addMeal(DailyMeal dailyMeal) {
        return dailyMealRepository.save(dailyMeal);
    }

    @Override
    public DailyMeal addMeal(DailyMealDetailsDTO dailyMealDetailsDTO) {
        DailyMeal dailyMeal =new DailyMeal();
        dailyMeal.setItem(dailyMealDetailsDTO.getItem());
        dailyMeal.setPrice(dailyMealDetailsDTO.getPrice());
        dailyMeal.setPerHeadAmount(dailyMealDetailsDTO.getPerHeadAmount());
        dailyMeal.setParticipants(dailyMealDetailsDTO.getParticipants().stream()
                .map(DailyMealDetailsDTO.ParticipantDTO::getPin)
                .collect(Collectors.toList()));
        dailyMeal.setBalanceType(dailyMealDetailsDTO.getBalanceType());
        dailyMeal.setCreatedAt(LocalDate.now());
        dailyMeal.setUpdatedAt(LocalDate.now());
        return dailyMealRepository.save(dailyMeal);
    }

    @Override
    public DailyMeal updateMeal(Long id, DailyMeal dailyMeal) {
        if (dailyMealRepository.existsById(id)){
            dailyMeal.setId(id);
            return dailyMealRepository.save(dailyMeal);
        }
        return null;
    }

    @Override
    public void deleteMeal(Long id) {
        dailyMealRepository.deleteById(id);
    }

    public int getParticipantsCount(Long id) {
        DailyMeal entity = dailyMealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));

        return entity.getParticipants().size();
    }
}





