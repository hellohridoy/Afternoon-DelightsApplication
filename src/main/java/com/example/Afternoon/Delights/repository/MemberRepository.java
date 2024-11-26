package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.dto.MemberBalanceStatusDto;
import com.example.Afternoon.Delights.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByPin(String pin);
    Optional<Member> findByPin(String pin);


    @Query("SELECT m FROM Member m WHERE " +
            "(LOWER(m.pin) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.officialPhoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))")

    List<Member> searchMembers(@Param("keyword") String keyword);

    @Query("SELECT COUNT(m) FROM Member m")
    Long findTotalMemberCount();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.activeStatus = 1")
    Long findActiveMemberCount();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.activeStatus !=1")
    Long findDeActiveMemberCount();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.addInitialBalance > 0")
    Long findMemberBalanceInPositive();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.addInitialBalance < 0")
    Long findMemberBalanceInNegative();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.addInitialBalance < 500")
    Long findMemberBalanceBelowFiveHundred();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.addInitialBalance BETWEEN 500 AND 1000")
    Long findMemberBalanceInOk();

    @Query("SELECT new com.example.Afternoon.Delights.dto.MemberBalanceStatusDto(" +
            "m.id, " +
            "m.pin, " +
            "m.name, " +
            "m.officialPhoneNumber, " +
            "m.designation, " +
            "m.email, " +
            "m.addInitialBalance) " +
            "FROM Member m WHERE m.addInitialBalance < 0")
    List<MemberBalanceStatusDto> findNegativeBalanceMembers();

    @Query("SELECT new com.example.Afternoon.Delights.dto.MemberBalanceStatusDto(" +
            "m.id, " +
            "m.pin, " +
            "m.name, " +
            "m.officialPhoneNumber, " +
            "m.designation, " +
            "m.email, " +
            "m.addInitialBalance) " +
            "FROM Member m WHERE m.addInitialBalance > 0")
    List<MemberBalanceStatusDto> findPositiveBalanceMembers();


    @Query("SELECT m FROM Member m WHERE m.pin = :pin")
    Optional<Member> findByEmployeePin(@Param("pin") String pin);

}
