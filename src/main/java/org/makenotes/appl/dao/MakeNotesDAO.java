package org.makenotes.appl.dao;

import java.util.Optional;

import org.makenotes.appl.entity.NotesEntity;
import org.springframework.data.repository.CrudRepository;

public interface MakeNotesDAO extends CrudRepository<NotesEntity, Integer> {

	Optional<NotesEntity> findById(int notesId);
}
