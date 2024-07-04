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

    public List<MemberSelection> findAll() {
        return memberSelectionRepository.findAll();
    }

    public MemberSelection save(MemberSelection memberSelection) {
        return memberSelectionRepository.save(memberSelection);
    }
}