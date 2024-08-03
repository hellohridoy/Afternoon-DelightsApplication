package com.example.Afternoon.Delights.repository;

import com.example.Afternoon.Delights.entity.MemberSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberSelectionRepository extends JpaRepository<MemberSelection,Long> {

    List<MemberSelection> findByDateAndSelectedTrue(String date);
    List<MemberSelection> findByDateAndSelected(String date, Boolean selected);
//    @Query("SELECT ms.pin FROM MemberSelection ms WHERE ms.date = :date AND ms.selected = true")
//    List<String> findPinsByDateAndSelected(@Param("date") String date);
//    @Query("SELECT ms, fi.amount FROM MemberSelection ms JOIN ms.foodItem fi")
//    List<Object[]> findMemberSelectionWithAmount();


    @Query("SELECT ms, fi.amount FROM MemberSelection ms JOIN ms.foodItem fi WHERE ms.date = :date AND ms.selected = true")
    List<Object[]> findSelectedMemberSelectionWithAmountByDate(@Param("date") String date);

    @Query("SELECT COUNT(ms) FROM MemberSelection ms WHERE ms.date = :date AND ms.selected = true")
    Long countActivePinsByDate(@Param("date") String date);
}


