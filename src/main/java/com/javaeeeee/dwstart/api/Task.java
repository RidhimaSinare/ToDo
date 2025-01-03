package com.javaeeeee.dwstart.api;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDate startDate;
    private LocalDate targetDate;

    public Task() {
    }

    public Task(int id, String description, String status, LocalDate startDate, LocalDate targetDate) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.targetDate = targetDate;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public String getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty
    public LocalDate getStartDate() {
        return startDate;
    }

    @JsonProperty
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @JsonProperty
    public LocalDate getTargetDate() {
        return targetDate;
    }

    @JsonProperty
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}

