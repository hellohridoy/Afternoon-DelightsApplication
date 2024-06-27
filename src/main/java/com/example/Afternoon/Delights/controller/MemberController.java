package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
@RequestMapping("/afternoon-delights/member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/all")
    public List<Member> all() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping("/add-members")
    public Member addMembers(@RequestBody Member member) {
        return memberService.addMember(member);
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
    public List<String> getAllPins() {
        return memberService.getAllPins();
    }
}
