package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dao.MemberDashBoardDao;
import com.example.Afternoon.Delights.dto.*;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDashBoardDao memberDashBoardDao;
    private final MemberRepository memberRepository;
    private final AddressBookService addressBookService;

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
        Member member = new Member();  // No need to pass memberId
        member.setPin(pin);
        member.setName(name);
        member.setEmail(email);
        member.setOfficialPhoneNumber(officialPhoneNumber);
        member.setDesignation(designation);
        member.setDepartments(departments);
        member.setUnit(unit);
        member.setAddInitialBalance(balance);
        member.setProfilePicture(profileImage.getBytes());
        member.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        member.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return memberRepository.save(member);
    }

    @Override
    public boolean isPinUnique(String pin) {
        return memberRepository.existsByPin(pin);
    }

    @Override
    public MemberDashBoardStatusDto getMemberDashboardDetails() {
        MemberDashBoardStatusDto dashboardDetails = new MemberDashBoardStatusDto();
        dashboardDetails.setTotalMember(memberDashBoardDao.getTotalMembers());
        dashboardDetails.setActiveMember(memberDashBoardDao.getActiveMembers());
        dashboardDetails.setInactiveMember(memberDashBoardDao.getInactiveMembers());
        return dashboardDetails;
    }

    @Override
    public MemberBalanceDto getMembersWithNegativeBalance() {
        int totalMembers = memberDashBoardDao.getCountOfNegativeBalanceMembers();
        List<MemberDto> members = memberDashBoardDao.getMembersWithNegativeBalance();
        // Return a MemberBalanceDto with both totalMembers and the members list
        return new MemberBalanceDto(totalMembers, members);
    }

    @Override
    public List<MemberBalanceStatusDto> getNegativeBalanceMembers() {
        return memberRepository.findNegativeBalanceMembers();
    }


    public MemberBalanceInfoDto getMemberBalanceInfoDto(String searchParams) {
        MemberBalanceInfoDto dto = new MemberBalanceInfoDto();
        dto.setTotalMember(memberRepository.findTotalMemberCount().toString());
        dto.setActiveMember(memberRepository.findActiveMemberCount().toString());
        dto.setDeActiveMember(memberRepository.findDeActiveMemberCount().toString());
        dto.setMemberBalanceInPlus(memberRepository.findMemberBalanceInPositive().toString());
        dto.setMemberBalanceInMinus(memberRepository.findMemberBalanceInNegative().toString());
        dto.setMemberBalanceInBelowFiveHundred(memberRepository.findMemberBalanceBelowFiveHundred().toString());
        dto.setMemberBalanceInOk(memberRepository.findMemberBalanceInOk().toString());
        // Fetch AddressBookDto based on searchParams (optional)
//        if (searchParams != null && !searchParams.isEmpty()) {
//            List<AddressBookDto> addressBookList = addressBookService.findMembersBySearchParams(searchParams);
//            if (!addressBookList.isEmpty()) {
//                dto.setAddressBook(new AddressBookDto[]{addressBookList.get(0)}); // Assuming you want to set the first result
//            }
//        }
        dto.setMemberInDue(memberRepository.findNegativeBalanceMembers());
        return dto;
    }
}
