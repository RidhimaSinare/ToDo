package com.javaeeeee.dwstart.health;

import com.codahale.metrics.health.HealthCheck;
import org.jdbi.v3.core.Jdbi;

public class TaskHealthCheck extends HealthCheck {

    private final Jdbi jdbi;

    public TaskHealthCheck(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    protected Result check() throws Exception {
        try {
            // Run a simple query to verify database connection
            jdbi.withHandle(handle -> handle.execute("SELECT 1"));
            return Result.healthy("Database connection is healthy!");
        } catch (Exception e) {
            return Result.unhealthy("Cannot connect to the database: " + e.getMessage());
        }
    }
}
