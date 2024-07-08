package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.BalanceDTO;
import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.repository.BalanceRepository;
import com.example.Afternoon.Delights.repository.DailyMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private DailyMealRepository dailyMealRepository;

    public List<Balance> getAllBalance(){
        return balanceRepository.findAll();
    }


    public Balance getBalanceById(Long id){
        return balanceRepository.findById(id).orElse(null);
    }

    public Balance addBalance(Balance balance){

        return balanceRepository.save(balance);
    }

    public Balance updateBalance(Long id,Balance balance){
        if (balanceRepository.existsById(id)){
            balance.setId(id);
            return balanceRepository.save(balance);
        }
        return null;
    }

    public void deleteBalance(Long id){
        balanceRepository.deleteById(id);
    }

    public Double getTotalBalance() {
        return balanceRepository.findAll().stream()
                .mapToDouble(Balance::getBalance)  // Assuming `price` is a field in the `Balance` entity
                .sum();
    }
    public List<BalanceDTO> getBalanceHistory(String pin) {
        List<Balance> balances = balanceRepository.findByPinOrderByCreatedAtDesc(pin);
        return balances.stream().map(this::convertToDTO).collect(Collectors.toList()).reversed();
    }

    public List<BalanceDTO> getAllMemberBalanceHistory() {
        List<Balance> balances = balanceRepository.findAllByOrderByCreatedAtDesc();
        return balances.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BalanceDTO convertToDTO(Balance balance) {
        BalanceDTO dto = new BalanceDTO();
        dto.setId(balance.getId());
        dto.setPin(balance.getPin());
        dto.setBalance(balance.getBalance());
        dto.setBalanceType(balance.getBalanceType());
        dto.setCreatedAt(balance.getCreatedAt());
        dto.setUpdatedAt(balance.getUpdatedAt());
        return dto;
    }

    public List<Balance> getMembersWithNegativeBalance() {
        return balanceRepository.findMembersWithNegativeBalance();
    }

    public int getParticipantsCount(Long id) {
        // Implementation to get the number of participants for a specific id
        return dailyMealRepository.countParticipantsByIdNative(id);
    }

    public Double getAmountPerHead(Long id) {
        Double totalBalance = getTotalBalance();
        int participantCount = getParticipantsCount(id);
        if (participantCount == 0) {
            return 0.0; // Avoid division by zero
        }
        return totalBalance / participantCount;
    }
}
