package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	public MemberDTO loginChk(String id);
	public ArrayList<MemberDTO> list();
	public MemberDTO info(String id);
	public int reg(MemberDTO dto);

}
