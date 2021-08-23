package com.ict.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.BVO;
import com.ict.vo.MVO;
import com.ict.vo.VO;

@Service
public class MyServiceImpl implements MyService
{
	@Autowired
	private MyDAO myDAO;


	@Override
	public int InsertVO(MVO vo) throws Exception {
		return myDAO.InsertVO(vo);
	}

	@Override
	public int updateHit(String idx) throws Exception {
		return myDAO.updateHit(idx);
	}

	

	@Override
	public int updateLevUp(Map<String, Integer> map) throws Exception {
		return myDAO.updateLevUp(map);
	}
	
	@Override
	public int InsertAns(MVO vo) throws Exception {
		return myDAO.InsertAns(vo);
	}
	
	@Override
	public int selectPwdChk(MVO vo) throws Exception {
		// TODO Auto-generated method stub
		return myDAO.selectPwdChk(vo);
	}



	@Override
	public int deleteAns(String idx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	// =================================================================
	
	@Override
	public int selectIdChk(String id) throws Exception {
		return myDAO.selectIdChk(id);
	}

	@Override
	public int insertJoin(MVO mvo) throws Exception {
		return myDAO.insertJoin(mvo);
	}

	@Override
	public int selectId(String id) throws Exception {
		// TODO Auto-generated method stub
		return myDAO.selectId(id);
	}

	@Override
	public int InsertBVO(BVO bvo) throws Exception {
		return myDAO.InsertBVO(bvo);
	}
	
	@Override
	public int InsertBVO2(BVO bvo) throws Exception {
		return myDAO.InsertBVO2(bvo);
	}
	
	@Override
	public int selectCount() throws Exception {
		return myDAO.selectCount();
	}
	
	@Override
	public int selectCount2() throws Exception {
		return myDAO.selectCount2();
	}
	
	@Override
	public List<BVO> selectList(int begin, int end) throws Exception {
		return myDAO.selectList(begin, end);
	}
	
	@Override
	public List<BVO> selectList2(int begin, int end) throws Exception {
		return myDAO.selectList2(begin, end);
	}
	
	@Override
	public List<BVO> selectmyList(int begin, int end) throws Exception {
		return myDAO.selectmyList(begin, end);
	}
	
	@Override
	public List<BVO> selectmyList2(String id) throws Exception {
		return myDAO.selectmyList2(id);
	}
	
	@Override
	public List<VO> selectfoodList(String id) throws Exception {
		return myDAO.selectfoodList(id);
	}
	

	@Override
	public int selectMaster(MVO mvo) throws Exception {
		return myDAO.selectMaster(mvo);
	}

	@Override
	public int selectId_PwChk(MVO mvo) throws Exception {
		return myDAO.selectId_PwChk(mvo);
	}

	@Override
	public String selectIdFind(MVO mvo) throws Exception {
		return myDAO.selectIdFind(mvo);
	}
	
	@Override
	public String selectPwFind(MVO mvo) throws Exception {
		return myDAO.selectPwFind(mvo);
	}
	
	@Override
	public BVO selectOneList(String idx) throws Exception {
		return myDAO.selectOneList(idx);
	}
	
	@Override
	public int updateList(BVO bvo) throws Exception {
		return myDAO.updateList(bvo);
	}
	
	@Override
	public int delete(String idx) throws Exception {
		return myDAO.delete(idx);
	}
	
	@Override
	public int deletefood(String id) throws Exception {
		return myDAO.deletefood(id);
	}

	@Override
	public int updatePw(MVO mvo) throws Exception {
		return myDAO.updatePw(mvo);
	}

	@Override
	public int updatePhone(MVO mvo) throws Exception {
		return myDAO.updatePhone(mvo);
	}
	
}
