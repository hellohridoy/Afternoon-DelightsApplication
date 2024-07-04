package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

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
}
