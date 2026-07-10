package org.example.emailscheduler.dto;

import org.example.emailscheduler.entity.ScheduleType;

import java.time.LocalDateTime;

public class EmailRequest {

    private String recipient;
    private String subject;
    private String content;
    private ScheduleType scheduleType;
    private LocalDateTime firstSendTime;

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
}