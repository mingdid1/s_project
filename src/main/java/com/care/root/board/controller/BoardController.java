package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService bs;
	
	@GetMapping("boardAllList")
	public String boardList(Model model) {
		List<BoardDTO> list = bs.getList();
		model.addAttribute("list", list);
		return "board/boardAllList";
	}
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	
	@PostMapping("writeSave")
	public String writeSave(@RequestParam String id,
						@RequestParam String title,
						@RequestParam String content,
						@RequestParam MultipartFile file) {
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		System.out.println(file.getOriginalFilename());
		
		bs.writeSave(id, title, content, file);
		
		return "redirect:boardAllList";
	}
	
	@GetMapping("contentView")
	public String contentView(@RequestParam int writeNo, Model model) {
		BoardDTO dto = bs.getContent(writeNo);
		model.addAttribute("dto", dto);
		return "board/contentView";
	}
	
	@GetMapping("download")
	public void download(@RequestParam String file, HttpServletResponse res)
					throws Exception {
		
		res.addHeader("Content-disposition",
						"attachment; fileName="+ URLEncoder.encode(file, "utf-8"));
		
		File f = new File(BoardService.IMAGE_REPO + "/" + file);
		
		FileInputStream in = new FileInputStream(f);
		
		FileCopyUtils.copy(in, res.getOutputStream());
		in.close();
	}
	
	@GetMapping("modify_form")
	public String modify_form(@RequestParam int writeNo, Model model) {
		BoardDTO dto = bs.getContent(writeNo);
		model.addAttribute("dto", dto);
		return "board/modifyForm";
	}
	
	@PostMapping("mod")
	public String mod(@RequestParam int writeNo,
					@RequestParam String id,
					@RequestParam String title,
					@RequestParam String content,
					@RequestParam MultipartFile file) {
		
		bs.mod(writeNo, id, title, content, file);
		
		return "redirect:boardAllList";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam int writeNo,
						@RequestParam String file) {
		bs.del(writeNo, file);
		return "redirect:boardAllList";
	}
}
