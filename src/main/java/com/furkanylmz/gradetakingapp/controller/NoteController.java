package com.furkanylmz.gradetakingapp.controller;

import com.furkanylmz.gradetakingapp.model.BranchType;
import com.furkanylmz.gradetakingapp.model.Note;
import com.furkanylmz.gradetakingapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Void> addNote(@RequestBody Note note) {
        noteService.addNote(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable int id, @RequestBody Note note) {
        note.setId(id);
        noteService.updateNote(note);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/average/{branch}")
    public ResponseEntity<Double> calculateCourseAverage(@PathVariable BranchType branch) {
        double average = noteService.calculateCourseAverage(branch);
        return new ResponseEntity<>(average, HttpStatus.OK);
    }
    @GetMapping("/statistics/{branch}")
    public ResponseEntity<Map<String, Object>> calculateCourseStatistics(@PathVariable BranchType branch) {
        Map<String, Object> statistics = noteService.calculateCourseStatistics(branch);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}


