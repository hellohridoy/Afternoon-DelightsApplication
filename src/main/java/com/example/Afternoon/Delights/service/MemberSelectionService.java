package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.MemberSelection;
import com.example.Afternoon.Delights.repository.MemberSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberSelectionService {
    @Autowired
    private MemberSelectionRepository memberSelectionRepository;



    public List<MemberSelection> getAllMemberSelections() {
        return memberSelectionRepository.findAll();
    }

    public MemberSelection saveMemberSelection(MemberSelection memberSelection) {
        return memberSelectionRepository.save(memberSelection);
    }

    public List<MemberSelection> saveAllMemberSelections(List<MemberSelection> memberSelections) {
        return memberSelectionRepository.saveAll(memberSelections);
    }
    public List<MemberSelection> getSelectedItemsForDate(String date) {
        return memberSelectionRepository.findByDateAndSelectedTrue(date);
    }

    public List<MemberSelection> getSelectedMembersByDate(String date) {
        return memberSelectionRepository.findByDateAndSelected(date, true);
    }
    public List<Map<String, Object>> getSelectedMemberSelectionWithAmount(String date) {
        List<Object[]> results = memberSelectionRepository.findSelectedMemberSelectionWithAmountByDate(date);
        Long activePinCount = memberSelectionRepository.countActivePinsByDate(date);

        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] result : results) {
            MemberSelection memberSelection = (MemberSelection) result[0];
            Double amount = (Double) result[1];
            Double amountPerHead = activePinCount > 0 ? amount / activePinCount : 0.0;

            Map<String, Object> selectionMap = new HashMap<>();
            selectionMap.put("id", memberSelection.getId());
            selectionMap.put("pin", memberSelection.getPin());
            selectionMap.put("date", memberSelection.getDate());
            selectionMap.put("amount", amount);
            selectionMap.put("amountPerHead", amountPerHead);
            response.add(selectionMap);
        }
        return response;
    }
}