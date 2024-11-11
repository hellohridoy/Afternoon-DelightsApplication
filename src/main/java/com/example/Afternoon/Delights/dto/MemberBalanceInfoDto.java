package com.example.Afternoon.Delights.dto;

import com.example.Afternoon.Delights.service.AddressBookService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberBalanceInfoDto {
    private String totalMember;
    private String activeMember;
    private String deActiveMember;
    private String memberBalanceInPositive;
    private String memberBalanceInNagetive;
    private String memberBalanceInBelowFiveHundred;
    private String memberBalanceInOk;
    private List<MemberBalanceStatusDto> memberInDue;
}
