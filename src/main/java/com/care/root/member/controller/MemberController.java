package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired MemberService ms;
	
	
	public MemberController() {
		System.out.println("crtl 연결");
	}
	
	public String header(HttpSession session) {
		session.getAttribute("id");
		return "header";
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
	public String loginChk(MemberDTO dto, HttpSession session) {
		int result = ms.loginChk(dto);
		if (result == 1) {
			session.setAttribute("id", dto.getId());
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@GetMapping("successLogin")
	public String success() {
		return "member/successLogin";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:index";
	}
	
	@GetMapping("memberInfo")
	public String list(Model model) {
		ArrayList<MemberDTO> list = ms.list();
		model.addAttribute("list", list);
		return "member/memberInfo";
	}
	
	@GetMapping("info")
	public String info(Model model,
					@RequestParam String id) {
		MemberDTO dto = ms.info(id);
		model.addAttribute("dto", dto);
		return "member/info";
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("reg")
	public String reg(MemberDTO dto) {
		int result = ms.reg(dto);
		if (result == 1) {
			System.out.println("가입성공");
			return "member/login";
		}
		return "member/register";
	}
}
