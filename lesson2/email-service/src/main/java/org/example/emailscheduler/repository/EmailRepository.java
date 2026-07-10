package  org.example.emailscheduler.repository;

import org.example.emailscheduler.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EmailRepository
    extends JpaRepository<Email, Long> {
        List<Email> findByActiveTrueAndNextSendTimeLessThanEqual(LocalDateTime time);
    }