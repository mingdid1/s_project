package com.care.root.member.service;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	
	public int loginChk(MemberDTO dto);
	public ArrayList<MemberDTO> list();
	public MemberDTO info(String id);
	public int reg(MemberDTO dto);
}
