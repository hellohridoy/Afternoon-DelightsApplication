package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE " +
            "(LOWER(m.pin) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.officialPhoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<Member> searchMembers(@Param("keyword") String keyword);
}
