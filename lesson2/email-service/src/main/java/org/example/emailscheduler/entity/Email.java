package org.example.emailscheduler.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private ScheduleType scheduleType;
    private LocalDateTime firstSendTime;
    private LocalDateTime nextSendTime;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public LocalDateTime getFirstSendTime() {
        return firstSendTime;
    }

    public void setFirstSendTime(LocalDateTime firstSendTime) {
        this.firstSendTime = firstSendTime;
    }

    public LocalDateTime getNextSendTime() {
        return nextSendTime;
    }

    public void setNextSendTime(LocalDateTime nextSendTime) {
        this.nextSendTime = nextSendTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}