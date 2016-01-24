/**
 * 
 */
package org.makenotes.appl.controller;

import javax.validation.Valid;

import org.makenotes.appl.entity.NotesEntity;
import org.makenotes.appl.model.NotesModel;
import org.makenotes.appl.model.Result;
import org.makenotes.appl.service.MakeNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author udayd
 *
 */
@RestController
@RequestMapping("/makenotes/api/v1")
public class MakeNotesController {

	private final static Logger LOG = LoggerFactory.getLogger(MakeNotesController.class);

	@Autowired
	private MakeNotesService makeNotesService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result create(@RequestBody NotesModel notesModel) {
		LOG.info("In create service " + notesModel.getNotesBody());
		return new Result("success", null, makeNotesService.createNotes(notesModel));
	}

	@RequestMapping(value = "/{notesId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result getNotes(@PathVariable final int notesId) throws Exception {
		LOG.info("In get service");
		return new Result("success", null, makeNotesService.getNotes(notesId));
	}

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<NotesEntity> getAllNotes() {
		LOG.info("In get service");
		return makeNotesService.getAllNotes();
	}

	@RequestMapping(value = "/{notesId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result updateNotes(@PathVariable final int notesId, @Valid @RequestBody NotesModel notesModel)
			throws Exception {
		LOG.info("In update service");
		return new Result("success", null, makeNotesService.updateNotes(notesId, notesModel));
	}

	@RequestMapping(value = "/{notesId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Result updateNotes(@PathVariable final int notesId) throws Exception {
		LOG.info("In delete service");
		return new Result("success", null, makeNotesService.deleteNotes(notesId));
	}

}
