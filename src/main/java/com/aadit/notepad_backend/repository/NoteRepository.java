package com.aadit.notepad_backend.repository;

import com.aadit.notepad_backend.model.Note;
import com.aadit.notepad_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
}
