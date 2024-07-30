package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.MemberSelection;
import com.example.Afternoon.Delights.repository.MemberSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<String> getSelectedPinsByDate(String date) {
        return memberSelectionRepository.findPinsByDateAndSelected(date);
    }

}