package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.entity.MealHistory;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.service.BalanceHistoryService;
import com.example.Afternoon.Delights.service.MealHistoryService;
import com.example.Afternoon.Delights.service.MemberService;
import com.example.Afternoon.Delights.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RequestMapping("/afternoon-delights/member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @Autowired
    private BalanceHistoryService balanceHistoryService;

    @Autowired
    private MealHistoryService mealHistoryService;

    @GetMapping("/isPinUnique/{pin}")
    public ResponseEntity<Boolean> isPinUnique(@PathVariable String pin) {
        return ResponseEntity.ok(memberService.isPinUnique(pin));
    }

    @GetMapping("/all")
    public List<Member> all() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping("/add-members")
    public ResponseEntity<Member> addMember(@RequestParam("pin") String pin,
                                            @RequestParam("name") String name,
                                            @RequestParam("email") String email,
                                            @RequestParam("officialPhoneNumber") String officialPhoneNumber,
                                            @RequestParam("designation") String designation,
                                            @RequestParam("departments") String departments,
                                            @RequestParam("unit") String unit,
                                            @RequestParam("balance") Double balance,
                                            @RequestParam("profileImage") MultipartFile profileImage) {
        try {
            Member member = memberService.addMember(pin, name, email, officialPhoneNumber, designation, departments, unit, balance, profileImage);
            return ResponseEntity.ok(member);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/delete/{id}")
    public void  deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping("/all-members-pins")
    public List<Map<String, String>> getAllPins() {
        List<String> pins = memberService.getAllPins();
        List<Map<String, String>> response = pins.stream()
                .map(pin -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("pin", pin);
                    return map;
                })
                .collect(Collectors.toList());
        return response;
    }

    @PostMapping("/{id}/uploadProfilePicture")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            String message = memberServiceImpl.uploadProfilePicture(id, file);
            if ("Member not found.".equals(message)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
            }
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile picture.");
        }
    }

    @GetMapping("/{id}/profilePicture")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long id) {
        byte[] profilePicture = memberServiceImpl.getProfilePicture(id);
        if (profilePicture != null) {
            return ResponseEntity.ok(profilePicture);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/search")
    public List<Member> searchMembers(@RequestParam String keyword) {
        return memberServiceImpl.searchMembers(keyword);
    }



    @GetMapping("/{id}/meal-history")
    public ResponseEntity<List<MealHistory>> getMealHistoryForMember(@PathVariable Long id) {
        try {
            List<MealHistory> mealHistory = mealHistoryService.getMealHistoryForMember(id);
            return ResponseEntity.ok(mealHistory);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }




}
