package com.reminder.personal_reminder.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Data
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime remindAt;
    private boolean reminded;
    private Integer intervalMinutes;

    // set createdAt before persisting
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
