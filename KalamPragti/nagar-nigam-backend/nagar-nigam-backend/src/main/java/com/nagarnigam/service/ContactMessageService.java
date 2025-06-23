package com.nagarnigam.service;

import com.nagarnigam.model.ContactMessage;
import java.util.List;

public interface ContactMessageService {
    ContactMessage saveMessage(ContactMessage message);
    List<ContactMessage> getAllMessages();
    void deleteMessage(Long id);
}
