package com.furkanylmz.gradetakingapp.repositories;

import com.furkanylmz.gradetakingapp.model.BranchType;
import com.furkanylmz.gradetakingapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Integer> {

    List<Note> findByBranch(BranchType branch);

    List<Note> findByUserid(int userId);
}
