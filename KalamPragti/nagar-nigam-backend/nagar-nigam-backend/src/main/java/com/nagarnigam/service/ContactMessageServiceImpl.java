package com.nagarnigam.service;

import com.nagarnigam.model.ContactMessage;
import com.nagarnigam.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    @Override
    public ContactMessage saveMessage(ContactMessage message) {
        return repository.save(message);
    }

    @Override
    public List<ContactMessage> getAllMessages() {
        return repository.findAll();
    }

    @Override
    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }
}