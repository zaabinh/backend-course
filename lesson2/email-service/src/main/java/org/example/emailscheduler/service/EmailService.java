package org.example.emailscheduler.service;

import org.apache.coyote.Request;
import org.example.emailscheduler.dto.EmailRequest;
import org.example.emailscheduler.entity.ScheduleType;
import org.example.emailscheduler.repository.EmailRepository;
import org.springframework.stereotype.Service;
import org.example.emailscheduler.entity.Email;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {
    private final EmailRepository repository;
    private final EmailSenderService emailSenderService;

    public EmailService(EmailRepository repository, EmailSenderService emailSenderService) {
        this.repository = repository;
        this.emailSenderService = emailSenderService;
    }

    public Email sendNow(Long id) {
        Email email = repository.findById(id).orElseThrow(() -> new RuntimeException("Email not found"));
        emailSenderService.sendHtmlEmail(email.getRecipient(), email.getSubject(), email.getContent());
        email.setUpdatedAt(LocalDateTime.now());
        return repository.save(email);
    }

    public Email create(EmailRequest request) {
        Email email = new Email();
        copyRequest(request, email);
        email.setCreatedAt(LocalDateTime.now());
        email.setUpdatedAt(LocalDateTime.now());
        email.setActive(true);
        email.setNextSendTime(request.getFirstSendTime());

        return repository.save(email);
    }

    public List<Email> findAll() {
        return  repository.findAll();
    }

    public Email update(Long id, EmailRequest request) {
        Email email = repository.findById(id).orElseThrow(() -> new RuntimeException("Email job not found"));
        copyRequest(request, email);
        email.setNextSendTime(request.getFirstSendTime());
        email.setUpdatedAt(LocalDateTime.now());

        return repository.save(email);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Email toggleActive(Long id) {
        Email email = repository.findById(id).orElseThrow(() -> new RuntimeException("Email job not found"));
        email.setActive((!email.isActive()));

        return repository.save(email);
    }

    private void copyRequest(EmailRequest request, Email email) {
        email.setRecipient(request.getRecipient());
        email.setSubject(request.getSubject());
        email.setContent(request.getContent());
        email.setScheduleType(request.getScheduleType());
        email.setFirstSendTime(request.getFirstSendTime());
    }

    public LocalDateTime calculateNextSendAt(Email email) {
        ScheduleType type = email.getScheduleType();
        LocalDateTime current = email.getNextSendTime();

        return switch (type) {
            case ONCE -> null;
            case HOURLY -> current.plusHours(1);
            case DAILY -> current.plusDays(1);
            case WEEKLY -> current.plusWeeks(1);
        };
    }
}
