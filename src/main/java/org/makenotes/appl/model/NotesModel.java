package org.makenotes.appl.model;

public class NotesModel {
	
	private int id;
	
	private String header;
	
	private String notesBody;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the notesBody
	 */
	public String getNotesBody() {
		return notesBody;
	}

	/**
	 * @param notesBody the notesBody to set
	 */
	public void setNotesBody(String notesBody) {
		this.notesBody = notesBody;
	}
	
	
}
