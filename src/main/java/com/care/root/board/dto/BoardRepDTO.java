package com.care.root.board.dto;

import java.security.Timestamp;

public class BoardRepDTO {
	private String id;
	private String title;
	private String content;
	private int writeGroup;
	private Timestamp writeDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWriteGroup() {
		return writeGroup;
	}
	public void setWriteGroup(int writeGroup) {
		this.writeGroup = writeGroup;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
}
