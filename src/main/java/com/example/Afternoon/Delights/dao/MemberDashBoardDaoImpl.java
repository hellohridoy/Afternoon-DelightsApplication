package com.example.Afternoon.Delights.dao;

import com.example.Afternoon.Delights.dto.MemberBalanceDto;
import com.example.Afternoon.Delights.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDashBoardDaoImpl implements MemberDashBoardDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long getTotalMembers() {
        String sql = "SELECT COUNT(*) AS total_members FROM members";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long getActiveMembers() {
        String sql = "SELECT COUNT(*) AS active_members FROM members WHERE active_status = 1";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long getInactiveMembers() {
        String sql = "SELECT COUNT(*) AS inactive_members FROM members WHERE active_status = 0";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public int getCountOfNegativeBalanceMembers() {
        String sql = "SELECT COUNT(*) FROM members WHERE add_initial_balance < 0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<MemberDto> getMembersWithNegativeBalance() {
        String sql = "SELECT id, name, add_initial_balance FROM members WHERE add_initial_balance < 0";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapToMemberDto(rs));
    }

    private MemberDto mapToMemberDto(ResultSet rs) throws SQLException {
        return new MemberDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("add_initial_balance")
        );
    }
}
