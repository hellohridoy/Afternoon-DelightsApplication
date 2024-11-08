package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.MemberDashBoardStatusDto;
import com.example.Afternoon.Delights.dto.MemberBalanceDto;
import com.example.Afternoon.Delights.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface MemberService {

    public List<Member>getAllMembers();

    public Member getMemberById(Long id);

    public Member addMember(Member member);

    public Member updateMember(Long id,Member member);

    public void deleteMember(Long id);

    public List<String> getAllPins() ;

    Member addMember(String pin, String name, String email, String officialPhoneNumber, String designation, String departments, String unit, Double balance, MultipartFile profileImage) throws IOException;

    public boolean isPinUnique(String pin);


    MemberDashBoardStatusDto getMemberDashboardDetails();

    MemberBalanceDto getMembersWithNegativeBalance();

}
