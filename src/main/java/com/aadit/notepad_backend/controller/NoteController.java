package com.aadit.notepad_backend.controller;

import com.aadit.notepad_backend.model.Note;
import com.aadit.notepad_backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // create a note
    @PostMapping("/create")
    public Note createNote(
            @RequestParam String username,
            @RequestParam String title,
            @RequestParam String content) {
        return noteService.createNote(username, title, content);
    }

    // get all notes
    @GetMapping("/{username}")
    public List<Note> getNotes(@PathVariable String username) {
        return noteService.getNotesForUser(username);
    }

    // update note
    @PutMapping("/update/{id}")
    public Note updateNote(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String content) {
        return noteService.updateNote(id, title, content);
    }

    // delete note
    @DeleteMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "Note deleted successfully";
    }
}
