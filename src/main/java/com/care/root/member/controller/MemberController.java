package com.care.root.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired MemberService ms;
	
	
	public MemberController() {
		System.out.println("crtl ¿¬°á");
	}
	
	@GetMapping("index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login_chk")
	public String loginChk(MemberDTO dto) {
		int result = ms.loginChk(dto);
		if (result == 1) {
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@GetMapping("successLogin")
	public String success() {
		return "member/successLogin";
	}
}
