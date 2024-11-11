package com.example.Afternoon.Delights.controller;

import com.example.Afternoon.Delights.dto.AddressBookDto;
import com.example.Afternoon.Delights.service.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressBookRestController {

    private final AddressBookService addressBookService;

    @GetMapping("/afternoon-delights/member/address-infos")
    public List<AddressBookDto> searchMembers(
           @RequestParam(required = false) String searchParams) {
        return addressBookService.findMembersBySearchParams(searchParams);
    }
}
