package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired MemberMapper mm;
	
	@Override
	public int loginChk(MemberDTO dto) {
		int result = 0;
		System.out.println(dto.getId());
		
		String id = dto.getId();
		MemberDTO d = mm.loginChk(id);
		
		if (d != null) {
			if(dto.getId().equals(d.getId()) && dto.getPw().equals(d.getPw())) {
				result =1;
			}
		}
		return result;
	}

}
