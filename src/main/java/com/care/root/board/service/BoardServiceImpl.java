package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper bm;
	
	@Override
	public List<BoardDTO> getList() {
		List<BoardDTO> list = bm.getList();
		return list;
	}

	@Override
	public void writeSave(String id, String title, String content, MultipartFile file) {
		BoardDTO dto = new BoardDTO();

		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);

		if( !file.isEmpty()) {
			
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileName: "+ sysFileName);
			
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgFileName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgFileName("nan");
		}
		
		try {
			bm.writeSave( dto );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardDTO getContent(int writeNo) {
		BoardDTO dto = bm.getContent(writeNo);
		return dto;
	}

	@Override
	public void mod(int writeNo, String id, String title, String content, MultipartFile file) {
		BoardDTO dto = new BoardDTO();

		dto.setWriteNo(writeNo);
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);

		if( !file.isEmpty()) {
			
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileName: "+ sysFileName);
			
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgFileName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgFileName("nan");
		}
		
		try {
			bm.mod( dto );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void del(int writeNo, String file) {
		try {
			int result = bm.del(writeNo);
			
			if (result == 1) {
				File d = new File(IMAGE_REPO+ "/"+ file);
				System.out.println("d.exists(): "+ d.exists());
				if(d.exists()) {
					d.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

}
