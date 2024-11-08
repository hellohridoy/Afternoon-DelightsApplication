package com.example.Afternoon.Delights.service;

import com.example.Afternoon.Delights.dao.AddressBookDao;
import com.example.Afternoon.Delights.dto.AddressBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressBookServiceImpl implements AddressBookService {
    private final AddressBookDao addressBookDao;
    @Override
    public List<AddressBookDto> findMembersBySearchParams(String searchParams) {
        if (searchParams != null && !searchParams.isEmpty()) {
            return addressBookDao.findMembersBySearchParams(searchParams);
        }
        return addressBookDao.findMembersBySearchParams(null);
    }
}
