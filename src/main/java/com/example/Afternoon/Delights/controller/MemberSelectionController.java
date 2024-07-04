package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.MemberSelection;
import com.example.Afternoon.Delights.service.MemberSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-selections")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class MemberSelectionController {
    @Autowired
    private MemberSelectionService memberSelectionService;

    @GetMapping
    public List<MemberSelection> findAll() {
        return memberSelectionService.findAll();
    }

    @PostMapping
    public MemberSelection save(@RequestBody MemberSelection memberSelection) {
        return memberSelectionService.save(memberSelection);
    }
}