package org.example.emailscheduler.controller;

import org.example.emailscheduler.dto.EmailRequest;
import org.example.emailscheduler.entity.Email;
import org.example.emailscheduler.repository.EmailRepository;
import org.example.emailscheduler.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {
    private final EmailService service;
    private final EmailRepository emailRepository;

    public  EmailController(EmailService service, EmailRepository emailRepository) {
        this.service = service;
        this.emailRepository = emailRepository;
    }
    @PostMapping
    public ResponseEntity<Email> create(@RequestBody EmailRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PostMapping("/{id}/send-now")
    public ResponseEntity<Email> sendNow(@PathVariable Long id) {
        return ResponseEntity.ok(service.sendNow(id));
    }

    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Email> update(
            @PathVariable Long id,
            @RequestBody EmailRequest request
    ) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PatchMapping("/{id}/toogle-active")
    public ResponseEntity<Email> toggleActive(@PathVariable Long id) {
        return ResponseEntity.ok(service.toggleActive(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();    }
}