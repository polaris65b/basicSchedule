package com.example.basicschedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String date;

    public Schedule(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public void update(String content, String date) {
        this.content = content;
        this.date = date;
    }
}
