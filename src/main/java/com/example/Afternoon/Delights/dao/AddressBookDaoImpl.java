package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.dto.AddressBookDto;
import com.example.Afternoon.Delights.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressBookDaoImpl implements AddressBookDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<AddressBookDto> findMembersBySearchParams(String searchParams) {
        String searchQuery = "SELECT id, pin, name, designation, unit, email, official_phone_number " +
                "FROM members " +
                "WHERE active_status = 1 AND ( " +
                "pin ILIKE '%' || ? || '%' OR " +
                "name ILIKE '%' || ? || '%' OR " +
                "designation ILIKE '%' || ? || '%' OR " +
                "unit ILIKE '%' || ? || '%' OR " +
                "email ILIKE '%' || ? || '%' OR " +
                "official_phone_number ILIKE '%' || ? || '%' " +
                ")";

        // Replace undefined searchTerm with searchParams
        List<Member> members = jdbcTemplate.query(searchQuery,
                new Object[]{searchParams, searchParams, searchParams, searchParams, searchParams, searchParams},
                new BeanPropertyRowMapper<>(Member.class));

        // You can map the result into AddressBookDto if needed, or return as Member objects directly
        return mapMembersToDto(members);
    }

    private AddressBookDto AddressBookMapper(ResultSet resultSet, int i) throws SQLException {
        AddressBookDto dto = new AddressBookDto();
        dto.setId(resultSet.getLong("id"));
        dto.setPin(resultSet.getString("pin"));
        dto.setName(resultSet.getString("name"));
        dto.setDesignation(resultSet.getString("designation"));
        dto.setUnit(resultSet.getString("unit"));
        dto.setEmail(resultSet.getString("email"));
        dto.setOfficialPhoneNumber(resultSet.getString("official_phone_number"));
        return dto;
    }

    private List<AddressBookDto> mapMembersToDto(List<Member> members) {
        // Assuming you want to map the Member entities to AddressBookDto
        List<AddressBookDto> dtoList = new ArrayList<>();
        for (Member member : members) {
            AddressBookDto dto = new AddressBookDto();
            dto.setId(member.getId());
            dto.setPin(member.getPin());
            dto.setName(member.getName());
            dto.setDesignation(member.getDesignation());
            dto.setUnit(member.getUnit());
            dto.setEmail(member.getEmail());
            dto.setOfficialPhoneNumber(member.getOfficialPhoneNumber());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
