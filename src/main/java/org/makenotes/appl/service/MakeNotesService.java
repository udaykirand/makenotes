package org.makenotes.appl.service;

import org.makenotes.appl.entity.NotesEntity;
import org.makenotes.appl.model.NotesModel;

public interface MakeNotesService {
	
	public int createNotes(NotesModel notesModel);

	public NotesEntity getNotes(int notesId) throws Exception;

	public Iterable<NotesEntity> getAllNotes();

	public NotesEntity updateNotes(int notesId, NotesModel notesModel) throws Exception;

	public Iterable<NotesEntity> deleteNotes(int notesId) throws Exception;
}
