package com.nagarnigam.repository;

import com.nagarnigam.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Find complaint by complaint number
    Complaint findByComplaintNumber(String complaintNumber);

    // Find complaints by status
    List<Complaint> findByStatus(String status);
}