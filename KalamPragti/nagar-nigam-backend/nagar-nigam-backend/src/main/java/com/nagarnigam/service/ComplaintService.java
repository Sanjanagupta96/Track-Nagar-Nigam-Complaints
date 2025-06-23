package com.nagarnigam.service;

import com.nagarnigam.model.Complaint;
import java.util.List;

public interface ComplaintService {
    // Create new complaint
    Complaint createComplaint(Complaint complaint);

    // Get complaint by ID
    Complaint getComplaintById(Long id);

    // Get complaint by complaint number
    Complaint getComplaintByNumber(String complaintNumber);

    // Get all complaints
    List<Complaint> getAllComplaints();

    // Get complaints by status
    List<Complaint> getComplaintsByStatus(String status);

    // Update complaint status
    Complaint updateComplaintStatus(Long id, String status);

    void deleteComplaint(Long id);
}