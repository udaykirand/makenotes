package org.makenotes.appl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTES")
public class NotesEntity implements Serializable {

	private static final long serialVersionUID = 2743755650599257440L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	@Column(name = "header")
	private String header;

	@Column(name = "NOTES")
	private String notesBody;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param notesBody
	 *            the notesBody to set
	 */
	public void setNotesBody(String notesBody) {
		this.notesBody = notesBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NotesEntity [id=" + id + ", username=" + header + ", notesBody=" + notesBody + "]";
	}

}
