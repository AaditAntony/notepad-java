package com.aadit.notepad_backend.service;

import com.aadit.notepad_backend.model.Note;
import com.aadit.notepad_backend.model.User;
import com.aadit.notepad_backend.repository.NoteRepository;
import com.aadit.notepad_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    @Autowired
 private NoteRepository noteRepository;
@Autowired
 private UserRepository userRepository;

public Note createNote(String title,String content,String username) {
    User user = userRepository.findByUsername(username).orElse(null);
    if (user == null) {
        throw new RuntimeException("user not found");
    }
Note note =  Note.builder()
             .title(title)
        .content(content)
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .user(user)
        .build();

    return noteRepository.save(note);
}

// Get all the notes of a user
    public List<Note> getNotesByUsername(String username){
    User user =userRepository.findByUsername(username).orElse(null);
    if(user == null){
        throw new RuntimeException("User not found");
    }
    return noteRepository.findByUser(user);
    }


}
