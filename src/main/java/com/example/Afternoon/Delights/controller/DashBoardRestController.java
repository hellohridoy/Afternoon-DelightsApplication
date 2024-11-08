package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.dto.MemberDashBoardStatusDto;
import com.example.Afternoon.Delights.dto.MemberBalanceDto;
import com.example.Afternoon.Delights.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequiredArgsConstructor
public class DashBoardRestController {
    private final MemberService memberService;

    // Mapping for getting member dashboard details
    @GetMapping("/afternoon-delights/dashboard/members-infos")
    public ResponseEntity<MemberDashBoardStatusDto> getMemberDashboardDetails() {
        MemberDashBoardStatusDto dashboardDetails = memberService.getMemberDashboardDetails();
        return ResponseEntity.ok(dashboardDetails);
    }

    // New unique mapping for members with negative balance
    @GetMapping("/afternoon-delights/dashboard/members-infos/negative-balance")
    public ResponseEntity<MemberBalanceDto> getNegativeBalanceMembers() {
        MemberBalanceDto negativeBalanceMembers = memberService.getMembersWithNegativeBalance();
        return ResponseEntity.ok(negativeBalanceMembers);
    }
}
