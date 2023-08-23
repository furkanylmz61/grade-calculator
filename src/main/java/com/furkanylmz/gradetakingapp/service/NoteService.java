package com.furkanylmz.gradetakingapp.service;

import com.furkanylmz.gradetakingapp.model.BranchType;
import com.furkanylmz.gradetakingapp.model.Note;

import java.util.List;
import java.util.Map;


public interface NoteService {
    List<Note> getAllNotes();

    Note getNoteById(int id);

    List<Note> getNotesByUserId(int userId);


    List<Note> getNotesByBranch(BranchType branch);

    void addNote(Note note);

    void updateNote(Note note);

    void deleteNoteById(int id);

    String calculateLetterGrade(int grade);

    double calculateCourseAverage(BranchType branch);


    Map<String, Object> calculateCourseStatistics(BranchType branch);
}
