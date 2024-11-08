package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.dto.AddressBookDto;

import java.util.List;

public interface AddressBookDao {
    List<AddressBookDto> findMembersBySearchParams(String searchParams);
}
