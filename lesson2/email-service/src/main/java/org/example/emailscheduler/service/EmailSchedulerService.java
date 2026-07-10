package org.example.emailscheduler.service;

import org.example.emailscheduler.entity.Email;
import org.example.emailscheduler.entity.ScheduleType;
import org.example.emailscheduler.repository.EmailRepository;
import org.example.emailscheduler.service.EmailSenderService;
import org.example.emailscheduler.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailSchedulerService {
    private final EmailRepository repository;
    private final EmailService emailService;
    private final EmailSenderService emailSenderService;

    public EmailSchedulerService(EmailRepository repository, EmailService emailService, EmailSenderService emailSenderService) {
        this.repository = repository;
        this.emailService = emailService;
        this.emailSenderService = emailSenderService;
    }

    @Scheduled(fixedRate = 60000)
    public void processDueEmails() {
        LocalDateTime now = LocalDateTime.now();
        List<Email> emails = repository.findByActiveTrueAndNextSendTimeLessThanEqual(now);

        for (Email email: emails) {
            emailSenderService.sendHtmlEmail(email.getRecipient(), email.getSubject(), email.getContent());
            if (email.getScheduleType() == ScheduleType.ONCE) {
                email.setActive(false);
                email.setNextSendTime(null);
            } else {
                email.setNextSendTime(emailService.calculateNextSendAt(email));
            }

            email.setUpdatedAt(LocalDateTime.now());
            repository.save(email);

        }
    }
}