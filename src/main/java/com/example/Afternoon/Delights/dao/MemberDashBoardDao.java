package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.dto.MemberBalanceDto;
import com.example.Afternoon.Delights.dto.MemberDto;

import java.util.List;


public interface MemberDashBoardDao {
    Long getTotalMembers();
    Long getActiveMembers();
    Long getInactiveMembers();
    int getCountOfNegativeBalanceMembers();
    List<MemberDto> getMembersWithNegativeBalance();
}
