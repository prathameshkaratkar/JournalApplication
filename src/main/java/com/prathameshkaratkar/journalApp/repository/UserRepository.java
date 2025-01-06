package com.prathameshkaratkar.journalApp.repository;

import com.prathameshkaratkar.journalApp.entity.JournalEntry;
import com.prathameshkaratkar.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findByUserName(String username);
}
