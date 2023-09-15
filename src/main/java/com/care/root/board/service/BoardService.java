package com.care.root.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;

public interface BoardService {
	
	public String IMAGE_REPO ="C:/spring\\image_repo";
	
	public List<BoardDTO> getList();
	public void writeSave(String id, String title, String content, MultipartFile file);
	public BoardDTO getContent(int writeNo);
	public void mod(int writeNo, String id, String title, String content, MultipartFile file);
	public void del(int writeNo, String file);
}
