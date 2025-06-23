package com.nagarnigam.controller;

import com.nagarnigam.model.Complaint;
import com.nagarnigam.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*") // This allows requests from your frontend
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Create new complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        return ResponseEntity.ok(complaintService.createComplaint(complaint));
    }

    // Get all complaints
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    // Get complaint by ID
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        return ResponseEntity.ok(complaintService.getComplaintById(id));
    }

    // Get complaint by complaint number
    @GetMapping("/track/{complaintNumber}")
    public ResponseEntity<Complaint> getComplaintByNumber(@PathVariable String complaintNumber) {
        return ResponseEntity.ok(complaintService.getComplaintByNumber(complaintNumber));
    }

    // Get complaints by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Complaint>> getComplaintsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(complaintService.getComplaintsByStatus(status));
    }

    // Update complaint status
    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(complaintService.updateComplaintStatus(id, status));
    }

    // Update complaint (including status)
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(
            @PathVariable Long id,
            @RequestBody Complaint updatedComplaint) {
        Complaint complaint = complaintService.getComplaintById(id);
        complaint.setFullName(updatedComplaint.getFullName());
        complaint.setMobileNumber(updatedComplaint.getMobileNumber());
        complaint.setAddress(updatedComplaint.getAddress());
        complaint.setIssueType(updatedComplaint.getIssueType());
        complaint.setDescription(updatedComplaint.getDescription());
        complaint.setLocation(updatedComplaint.getLocation());
        complaint.setStatus(updatedComplaint.getStatus());
        return ResponseEntity.ok(complaintService.createComplaint(complaint));
    }

    // Delete complaint
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }
}