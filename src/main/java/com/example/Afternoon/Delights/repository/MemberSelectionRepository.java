package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.MemberSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberSelectionRepository extends JpaRepository<MemberSelection,Long> {
    List<MemberSelection> findByDateAndSelectedTrue(String date);
}
