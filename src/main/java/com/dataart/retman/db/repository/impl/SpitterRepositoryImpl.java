package com.dataart.retman.db.repository.impl;

import com.dataart.retman.db.repository.SpitterRepository;
import com.dataart.retman.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    private static final String SQL_INSERT_SPITTER = "INSERT INTO SPITTERS (ID, USERNAME, PASSWORD, FULLNAME, EMAIL, ISUPDATEDBYEMAIL) VALUES (?,?,?,?,?,?)";
    private static final String SQL_GET_SPITTER_BY_ID = "SELECT * FROM SPITTERS where id=?";
    private JdbcOperations jdbcOperations;

    @Autowired
    public SpitterRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void addSpitter(Spitter spitter) {
        jdbcOperations.update(SQL_INSERT_SPITTER,
                spitter.getId(),
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdatedById());
    }

    public Spitter retrieveSpitterById(long id) {
        return jdbcOperations.queryForObject(SQL_GET_SPITTER_BY_ID,

                (rs, rowNum) -> {
                    return new Spitter(
                            rs.getLong("ID"),
                            rs.getString("USERNAME"),
                            rs.getString("PASSWORD"),
                            rs.getString("FULLNAME"),
                            rs.getString("EMAIL"),
                            rs.getBoolean("ISUPDATEDBYEMAIL"));
                }
                , id);

    }
}
