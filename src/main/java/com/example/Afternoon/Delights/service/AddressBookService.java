package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dto.AddressBookDto;

import java.util.List;

public interface AddressBookService {
    List<AddressBookDto> findMembersBySearchParams(String searchParams);
}
