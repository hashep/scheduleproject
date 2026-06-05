package com.example.scheduleproject.dto;

public class ScheduleUpdateForm {

    private Long id;
    private String title;
    private String content;
    private String date;
    private String location;

    public ScheduleUpdateForm() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}