package com.nagarnigam.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String complaintNumber;

    private String fullName;
    private String mobileNumber;
    private String address;
    private String issueType;
    private String description;
    private String photoPath;
    private String location;
    private String status;
    private LocalDateTime submissionDate;

    @PrePersist
    protected void onCreate() {
        submissionDate = LocalDateTime.now();
        status = "PENDING";
    }
}