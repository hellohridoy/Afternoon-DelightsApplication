package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.BalanceHistory;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.BalanceHistoryRepository;
import com.example.Afternoon.Delights.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private BalanceHistoryRepository balanceHistoryRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    public Member updateMember(Long id,Member member){
        if (memberRepository.existsById(id)){
            member.setId(id);
            return memberRepository.save(member);
        }
        return null;
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public List<String> getAllPins() {
        return memberRepository.findAll().stream()
                .map(Member::getPin)
                .collect(Collectors.toList());
    }
    public String uploadProfilePicture(Long id, MultipartFile file) throws IOException {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setProfilePicture(file.getBytes());
            memberRepository.save(member);
            return "Profile picture uploaded successfully.";
        } else {
            return "Member not found.";
        }
    }

    public byte[] getProfilePicture(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.map(Member::getProfilePicture).orElse(null);
    }
    public List<Member> searchMembers(String keyword) {
        return memberRepository.searchMembers(keyword);
    }

    public Member addMember(String pin, String name, String email, String officialPhoneNumber, String designation, String departments, String unit, Double balance, MultipartFile profileImage) throws IOException {
        Member member = new Member();
        member.setPin(pin);
        member.setName(name);
        member.setEmail(email);
        member.setOfficialPhoneNumber(officialPhoneNumber);
        member.setDesignation(designation);
        member.setDepartments(departments);
        member.setUnit(unit);
        member.setAddInitialValance(balance);
        member.setProfilePicture(profileImage.getBytes());
        member.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        member.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return memberRepository.save(member);
    }



    public Optional<Member> getMemberByPin(String pin) {
        return memberRepository.findByPin(pin);
    }

}
