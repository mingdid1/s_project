package com.care.root.mybatis.board;

import java.util.List;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> getList();
	public int writeSave(BoardDTO dto);
	public BoardDTO getContent(int writeNo);
	public int mod(BoardDTO dto);
	public int del(int writeNo);
}
