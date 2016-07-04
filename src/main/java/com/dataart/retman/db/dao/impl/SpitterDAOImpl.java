package com.dataart.retman.db.dao.impl;

import com.dataart.retman.db.dao.SpitterDAO;
import com.dataart.retman.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpitterDAOImpl implements SpitterDAO {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_SPITTER_BY_ID = "SELECT * FROM SPITTERS WHERE id=?";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID,
                new RowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Spitter spitter = new Spitter();

                        spitter.setId(rs.getLong(1));
                        spitter.setUsername(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        spitter.setFullName(rs.getString(4));
                        spitter.setEmail(rs.getString(5));
                        spitter.setUpdatedById(rs.getBoolean(6));

                        return spitter;
                    }
                }, id);
    }
}
