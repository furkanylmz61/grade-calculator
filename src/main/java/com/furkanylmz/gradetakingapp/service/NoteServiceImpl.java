package com.furkanylmz.gradetakingapp.service;

import com.furkanylmz.gradetakingapp.model.BranchType;
import com.furkanylmz.gradetakingapp.model.Note;
import com.furkanylmz.gradetakingapp.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Note> getNotesByUserId(int userId) {
        return noteRepository.findByUserid(userId);
    }


    @Override
    public List<Note> getNotesByBranch(BranchType branch) {
        return noteRepository.findByBranch(branch);
    }


    @Override
    public void addNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        }
    }

    @Override
    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public String calculateLetterGrade(int grade) {
        if (grade >= 90) {
            return "AA";
        } else if (grade >= 85) {
            return "BA";
        } else if (grade >= 80) {
            return "BB";
        } else if (grade >= 75) {
            return "CB";
        } else if (grade >= 70) {
            return "CC";
        } else if (grade >= 65) {
            return "DC";
        } else if (grade >= 60) {
            return "DD";
        } else if (grade >= 55) {
            return "FD";
        } else {
            return "FF";
        }
    }

    @Override
    public double calculateCourseAverage(BranchType branch) {
        List<Note> notes = noteRepository.findByBranch(branch);

        if (notes.isEmpty())
        {
            return 0.0;
        }

        int totalGrades = 0;
        for (Note note : notes)
        {
            totalGrades += note.getNote();
        }

        double average =  (double) totalGrades / notes.size();
        return average;
    }



    @Override
    public Map<String, Object> calculateCourseStatistics(BranchType branch) {
        List<Note> notes = noteRepository.findByBranch(branch);

        Map<String, Object> statistics = new HashMap<>();
        statistics.put("branch", branch.getDisplayValue());
        statistics.put("totalNotes", notes.size());

        double average = calculateCourseAverage(branch);
        statistics.put("average", average);

        Map<String, Integer> letterGradeCounts = new HashMap<>();
        for (Note note : notes) {
            String letterGrade = calculateLetterGrade(note.getNote());
            letterGradeCounts.put(letterGrade, letterGradeCounts.getOrDefault(letterGrade, 0) + 1);
        }
        statistics.put("letterGradeCounts", letterGradeCounts);

        return statistics;
    }
}








