package com.prathameshkaratkar.journalApp.service;

import com.prathameshkaratkar.journalApp.entity.JournalEntry;
import com.prathameshkaratkar.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId ObjectId myId) {
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }

}





// controller --> service --> repository
