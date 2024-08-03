package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.MemberSelection;
import com.example.Afternoon.Delights.service.FoodItemService;
import com.example.Afternoon.Delights.service.MemberSelectionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member-selections")
@CrossOrigin(origins = "http://localhost:4200") // Adjust the origin as needed
public class MemberSelectionController {

    int length;
    Double totalCost;
    double result ;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PinResponse{
        private int count;
        private List<Map<String, String>> pins;
    }

    @Autowired
    private MemberSelectionService memberSelectionService;

    @Autowired
    private FoodItemService foodItemService;


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

//
//    @GetMapping("/by-date")
//    public List<MemberSelection> getSelectedMembersByDate(@RequestParam String date) {
//        return memberSelectionService.getSelectedMembersByDate(date);
//    }

//    @GetMapping("/pins-by-date")
//    public PinResponse getSelectedPinsByDate(@RequestParam String date) {
//        List<String> pins = memberSelectionService.getSelectedPinsByDate(date);
//
//        // Find the length of the list
//        length = pins.size();
//
//        // Convert the list of pins to a list of maps with each pin
//        List<Map<String, String>> pinObjects = pins.stream()
//                .map(pin -> {
//                    Map<String, String> map = new HashMap<>();
//                    map.put("pin", pin);
//                    return map;
//                })
//                .collect(Collectors.toList());
//
//        // Create and return the custom response
//        return new PinResponse(length, pinObjects);
//    }


    @GetMapping("/food-item-cost-by-date-per-head")

    public Map<String,Double> getSelectedCostByDate(@RequestParam String date) {
         totalCost = foodItemService.getTotalCostByDate(date);
        Map<String,Double> response = new HashMap<>();
        double result = totalCost/length;
        response.put("perHeadAmount", result);
        return response;

    }
    @GetMapping("/selectedMemberSelectionsWithAmount")
    public List<Map<String, Object>> getSelectedMemberSelectionWithAmount(@RequestParam String date) {
        return memberSelectionService.getSelectedMemberSelectionWithAmount(date);
    }

}