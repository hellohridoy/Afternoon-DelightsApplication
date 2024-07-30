package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.MemberSelection;
import com.example.Afternoon.Delights.service.FoodItemService;
import com.example.Afternoon.Delights.service.MemberSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member-selections")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class MemberSelectionController {

    @Autowired
    private MemberSelectionService memberSelectionService;

    @GetMapping
    public ResponseEntity<List<MemberSelection>> getAllMemberSelections() {
        List<MemberSelection> selections = memberSelectionService.getAllMemberSelections();
        return ResponseEntity.ok(selections);
    }

    @PostMapping
    public ResponseEntity<MemberSelection> saveMemberSelection(@RequestBody MemberSelection memberSelection) {
        MemberSelection savedSelection = memberSelectionService.saveMemberSelection(memberSelection);
        return ResponseEntity.ok(savedSelection);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<MemberSelection>> saveAllMemberSelections(@RequestBody List<MemberSelection> memberSelections) {
        List<MemberSelection> savedSelections = memberSelectionService.saveAllMemberSelections(memberSelections);
        return ResponseEntity.ok(savedSelections);
    }

    @GetMapping("/pin-are-present-by-date")
    public List<MemberSelection> getSelectedItemsForDate(@RequestParam String date) {
        return memberSelectionService.getSelectedItemsForDate(date);
    }
}