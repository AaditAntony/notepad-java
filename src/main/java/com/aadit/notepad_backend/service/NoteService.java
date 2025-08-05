package com.aadit.notepad_backend.service;

import com.aadit.notepad_backend.model.Note;
import com.aadit.notepad_backend.model.User;
import com.aadit.notepad_backend.repository.NoteRepository;
import com.aadit.notepad_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public Note createNote(String username, String title, String content) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setCreatedAt(LocalDateTime.now());
            note.setUpdatedAt(LocalDateTime.now());
            note.setUser(optionalUser.get());
            return noteRepository.save(note);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<Note> getNotesForUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return noteRepository.findByUser(optionalUser.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Note updateNote(Long noteId, String title, String content) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(title);
            note.setContent(content);
            note.setUpdatedAt(LocalDateTime.now());
            return noteRepository.save(note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
