package com.prathameshkaratkar.journalApp.service;

import com.prathameshkaratkar.journalApp.entity.JournalEntry;
import com.prathameshkaratkar.journalApp.entity.User;
import com.prathameshkaratkar.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.ErrorManager;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;



    public void saveEntry(JournalEntry journalEntry, String userName) {
      User user = userService.findByUserName(userName);
      journalEntry.setDate(LocalDateTime.now());
      JournalEntry saved = journalEntryRepository.save(journalEntry);
      user.getJournalEntries().add(saved);
      userService.saveEntry(user);

    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {

        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId myId) {

        return journalEntryRepository.findById(myId);
    }

    public void deleteById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }

}





// controller --> service --> repository
