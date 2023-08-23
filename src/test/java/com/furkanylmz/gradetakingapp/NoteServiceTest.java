package com.furkanylmz.gradetakingapp;

import com.furkanylmz.gradetakingapp.model.Note;
import com.furkanylmz.gradetakingapp.repositories.NoteRepository;
import com.furkanylmz.gradetakingapp.service.NoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NoteServiceTest {

    @InjectMocks
    private NoteServiceImpl noteService;
    @Mock
    private NoteRepository noteRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateLetterGrade() {
        NoteServiceImpl noteService = new NoteServiceImpl(null);
        assertEquals("AA", noteService.calculateLetterGrade(95));
        assertEquals("BA", noteService.calculateLetterGrade(87));
        assertEquals("BB", noteService.calculateLetterGrade(82));
        assertEquals("CB", noteService.calculateLetterGrade(77));
        assertEquals("CC", noteService.calculateLetterGrade(72));
        assertEquals("DC", noteService.calculateLetterGrade(67));
        assertEquals("DD", noteService.calculateLetterGrade(62));
        assertEquals("FD", noteService.calculateLetterGrade(57));
        assertEquals("FF", noteService.calculateLetterGrade(45));
    }

    @Test
    public void testGetNoteById() {
        Note note = new Note();
        note.setId(1);
        note.setNote(85);

        when(noteRepository.findById(1)).thenReturn(Optional.of(note));

        Note result = noteService.getNoteById(1);

        assertEquals(1, result.getId());
        assertEquals(85, result.getNote());
    }
}


