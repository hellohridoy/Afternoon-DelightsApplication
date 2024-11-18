package com.example.Afternoon.Delights.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberBalanceInfoDto {
    private String totalMember;
    private String activeMember;
    private String deActiveMember;
    private String memberBalanceInPlus;
    private String memberBalanceInMinus;
    private String memberBalanceInBelowFiveHundred;
    private String memberBalanceInOk;
    private List<MemberBalanceStatusDto> memberInDue;
    private List<MemberBalanceStatusDto> memberInPlus;
}
