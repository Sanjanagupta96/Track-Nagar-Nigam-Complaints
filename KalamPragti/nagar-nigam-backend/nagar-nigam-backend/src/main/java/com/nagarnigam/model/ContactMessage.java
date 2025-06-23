package com.nagarnigam.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contact_messages")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDateTime submissionDate;

    @PrePersist
    protected void onCreate() {
        submissionDate = LocalDateTime.now();
    }
}