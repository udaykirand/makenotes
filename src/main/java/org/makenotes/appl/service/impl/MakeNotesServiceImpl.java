package org.makenotes.appl.service.impl;

import org.makenotes.appl.dao.MakeNotesDAO;
import org.makenotes.appl.entity.NotesEntity;
import org.makenotes.appl.model.NotesModel;
import org.makenotes.appl.service.MakeNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakeNotesServiceImpl implements MakeNotesService {
	private final static Logger LOG = LoggerFactory.getLogger(MakeNotesServiceImpl.class);
	@Autowired
	private MakeNotesDAO makeNotesDAO;
	@Override
	public int createNotes(NotesModel notesModel) {
		LOG.info("in createnotes service "+notesModel.getNotesBody());
		NotesEntity notesEnt = new NotesEntity();
		notesEnt.setHeader(notesModel.getHeader());
		notesEnt.setNotesBody(notesModel.getNotesBody());
		makeNotesDAO.save(notesEnt);
		LOG.info("Created notes with id [{}]"+notesEnt.getNotesBody());
		return notesEnt.getId();
	}
	@Override
	public NotesEntity getNotes(int notesId) throws Exception {
		return makeNotesDAO.findById(notesId)
				.orElseThrow(() -> new Exception("Notes doesn't exist"));
	}
	@Override
	public Iterable<NotesEntity> getAllNotes() {
		return makeNotesDAO.findAll();
	}
	@Override
	public NotesEntity updateNotes(int notesId, NotesModel notesModel) throws Exception {
		if (notesModel == null) {
			throw new Exception("Invalid input");
		}
		NotesEntity notesEntity = makeNotesDAO.findById(notesId)
				.orElseThrow(() -> new Exception("Notes doesn't exist"));
		notesEntity.setNotesBody(notesModel.getNotesBody());
		makeNotesDAO.save(notesEntity);
		return notesEntity;
	}
	@Override
	public Iterable<NotesEntity> deleteNotes(int notesId) throws Exception {
		NotesEntity notesEntity = makeNotesDAO.findById(notesId)
				.orElseThrow(() -> new Exception("Notes doesn't exist"));
		makeNotesDAO.delete(notesId);
		return makeNotesDAO.findAll();
	}

}
