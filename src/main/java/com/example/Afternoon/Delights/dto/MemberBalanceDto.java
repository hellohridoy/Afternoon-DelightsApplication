package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberBalanceDto {
    private int totalMembers;
    private List<MemberDto> members;

    public MemberBalanceDto(int totalMembers, List<MemberDto> members) {
        this.totalMembers = totalMembers;
        this.members = members;
    }
}
