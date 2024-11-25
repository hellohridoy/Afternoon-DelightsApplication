package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dao.MemberDashBoardDao;
import com.example.Afternoon.Delights.dto.*;
import com.example.Afternoon.Delights.entity.Balance;
import com.example.Afternoon.Delights.entity.DailyMeal;
import com.example.Afternoon.Delights.entity.Member;
import com.example.Afternoon.Delights.repository.BalanceRepository;
import com.example.Afternoon.Delights.repository.DailyMealRepository;
import com.example.Afternoon.Delights.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDashBoardDao memberDashBoardDao;
    private final MemberRepository memberRepository;
    private final BalanceRepository balanceRepository;
    private final DailyMealRepository dailyMealRepository;
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

    public MemberHistoryDto getMemberContributionsByPin(String pin) {
        // Fetch member details
        Member member = memberRepository.findByPin(pin)
                .orElseThrow(() -> new ResourceAccessException("Member not found with PIN: " + pin));

        // Fetch balances
        List<Balance> balances = balanceRepository.findByPin(pin);

        // Fetch daily meals
        List<DailyMeal> dailyMeals = dailyMealRepository.findByPin(pin);

        // Assemble response
        return new MemberHistoryDto(
                member.getId(),
                member.getPin(),
                member.getName(),
                member.getEmail(),
                member.getOfficialPhoneNumber(),
                member.getDepartments(),
                member.getProfilePicture(),
                balances,
                dailyMeals
        );
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
        dto.setMemberInPlus(memberRepository.findPositiveBalanceMembers());
        return dto;



    }

    // Method to add a new member
    @Transactional
    public Member saveMember(Member member) {
        // Optionally, you can add any validation logic here before saving
        // For example, check if the PIN already exists
        if (memberRepository.findByPin(member.getPin()).isPresent()) {
            throw new RuntimeException("Member with this PIN already exists");
        }

        // Set the current timestamps (createdAt, updatedAt)
        member.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        member.setUpdatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        // Save the member to the database
        return memberRepository.save(member);
    }

    public Map<String, Object> getMemberHistory(String pin) {
        // Fetch member details using JPA query
        Member member = memberRepository.findByPin(pin)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // Fetch balance history using JPA query
        List<Balance> balances = balanceRepository.findByPin(pin);

        // Fetch meal history using JPA query
        List<DailyMeal> meals = dailyMealRepository.findByPin(pin);

        // Construct the response map
        Map<String, Object> response = new HashMap<>();
        response.put("member", member);

        // Construct history section
        Map<String, Object> history = new HashMap<>();
        history.put("totalMeals", meals.size());
        history.put("mealHistory", meals);
        history.put("balanceHistory", balances);

        response.put("history", history);

        return response;
    }

}
