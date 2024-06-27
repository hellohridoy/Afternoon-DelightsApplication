package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    public List<Member>getAllMembers();

    public Member getMemberById(Long id);

    public Member addMember(Member member);

    public Member updateMember(Long id,Member member);

    public void deleteMember(Long id);

    public List<String> getAllPins() ;
}
