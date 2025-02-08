package com.example.basicschedule.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String content;
    private String date;

    public ScheduleResponseDto(Long id, String content, String date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }
}
