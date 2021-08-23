package com.ict.service;

import java.util.List;
import java.util.Map;

import com.ict.vo.BVO;
import com.ict.vo.MVO;

public interface MyService 
{

	// 원글 삽입
	int InsertVO(MVO vo) throws Exception;

	// 원글 히트 업데이트
	int updateHit(String idx) throws Exception;

	

	// 레벨업
	int updateLevUp(Map<String, Integer> map) throws Exception;


	// 댓글 삽입
	int InsertAns(MVO vo) throws Exception;


	// 댓글 삭제
	int deleteAns(String idx) throws Exception;

	// 수정, 삭제, 비번 체크
	int selectPwdChk(MVO vo) throws Exception;
	
	// =========================================================================

	// id 중복 체크 
	int selectIdChk(String id) throws Exception;
	
	// join
	int insertJoin(MVO mvo) throws Exception;
	
	// id 확인
	int selectId(String id) throws Exception;
	
	// 원글 삽입
	int InsertBVO(BVO bvo) throws Exception;
	
	// 원글 삽입
	int InsertBVO2(BVO bvo) throws Exception;
	
	// 게시물의 수
	int selectCount() throws Exception;
		
	// 원글 리스트
	List<BVO> selectList(int begin, int end) throws Exception;
	
	// 원글 리스트
	List<BVO> selectList2(int begin, int end) throws Exception;
	
	// 관리자 확인
	int selectMaster(MVO mvo) throws Exception;
	
	// id, pw 확인
	int selectId_PwChk(MVO mvo) throws Exception;
	
	// id 찾기
	String selectIdFind(MVO mvo) throws Exception;
	
	// pw 찾기
	String selectPwFind(MVO mvo) throws Exception;
	
	// 리스트 하나 받기
	BVO selectOneList(String idx) throws Exception;
	
	// 원글 업데이트
	int updateList(BVO bvo) throws Exception;
	
	// 원글 삭제
	int delete(String idx) throws Exception;
	
	// 비번 바꾸기
	int updatePw(MVO mvo) throws Exception;
		
	// 번호 바꾸기
	int updatePhone(MVO mvo) throws Exception;
	
	
}
