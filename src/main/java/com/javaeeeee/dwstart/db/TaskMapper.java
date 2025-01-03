package com.javaeeeee.dwstart.db;

import com.javaeeeee.dwstart.api.Task;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {

    @Override
    public Task map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Task(
                rs.getInt("id"),
                rs.getString("description"),
                rs.getString("status"),
                rs.getDate("start_date").toLocalDate(),
                rs.getDate("target_date").toLocalDate()
        );
    }
}
