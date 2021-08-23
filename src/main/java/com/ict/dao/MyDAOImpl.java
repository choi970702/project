package com.ict.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.vo.BVO;
import com.ict.vo.MVO;

@Repository
public class MyDAOImpl implements MyDAO
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public int InsertVO(MVO vo) throws Exception {
		return sqlSessionTemplate.insert("board.insert", vo);
	}

	@Override
	public int updateHit(String idx) throws Exception {
		return sqlSessionTemplate.update("board.updateHit", idx);
	}

	

	@Override
	public int updateLevUp(Map<String, Integer> map) throws Exception {
		return sqlSessionTemplate.update("board.lev_up", map);
	}
	
	@Override
	public int InsertAns(MVO vo) throws Exception {
		return sqlSessionTemplate.insert("board.ans_insert", vo);
	}
	@Override
	public int selectPwdChk(MVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("board.pwd_chk", vo);
	}
	


	@Override
	public int deleteAns(String idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	// ================================================================
	
	@Override
	public int selectIdChk(String id) throws Exception 
	{
		return sqlSessionTemplate.selectOne("myproject.id_chk", id);
	}

	@Override
	public int insertJoin(MVO mvo) throws Exception {
		return sqlSessionTemplate.insert("myproject.join_ok", mvo);
	}

	@Override
	public int selectId(String id) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.id", id);
	}

	@Override
	public int InsertBVO(BVO bvo) throws Exception {
		return sqlSessionTemplate.insert("myproject.board", bvo);
	}
	
	@Override
	public int InsertBVO2(BVO bvo) throws Exception {
		return sqlSessionTemplate.insert("myproject.board2", bvo);
	}
	
	@Override
	public int selectCount() throws Exception {
		return sqlSessionTemplate.selectOne("myproject.count");
	}
	
	@Override
	public int selectCount2() throws Exception {
		return sqlSessionTemplate.selectOne("myproject.count2");
	}
	
	@Override
	public List<BVO> selectList(int begin, int end) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("myproject.list", map);
	}
	
	@Override
	public List<BVO> selectList2(int begin, int end) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("myproject.list2", map);
	}
	
	@Override
	public List<BVO> selectmyList(int begin, int end) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		return sqlSessionTemplate.selectList("myproject.mylist", map);
	}
	
	@Override
	public List<BVO> selectmyList2(String id) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.mylist2", id);
	}

	@Override
	public int selectMaster(MVO mvo) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.master", mvo);
	}

	@Override
	public int selectId_PwChk(MVO mvo) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.id_pwchk", mvo);
	}

	@Override
	public String selectIdFind(MVO mvo) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.idfind", mvo);
	}

	@Override
	public String selectPwFind(MVO mvo) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.pwfind", mvo);
	}
	
	@Override
	public BVO selectOneList(String idx) throws Exception {
		return sqlSessionTemplate.selectOne("myproject.oneList", idx);
	}
	
	@Override
	public int updateList(BVO bvo) throws Exception {
		return sqlSessionTemplate.update("myproject.up_list", bvo);
	}
	
	@Override
	public int delete(String idx) throws Exception {
		return sqlSessionTemplate.delete("myproject.del", idx);
	}

	@Override
	public int updatePw(MVO mvo) throws Exception {
		return sqlSessionTemplate.update("myproject.pw_up", mvo);
	}

	@Override
	public int updatePhone(MVO mvo) throws Exception {
		return sqlSessionTemplate.update("myproject.phone_up", mvo);
	}
	
}
