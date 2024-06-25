package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByPin(Integer pin);
}
