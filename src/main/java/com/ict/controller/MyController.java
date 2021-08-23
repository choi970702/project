package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.service.Paging;
import com.ict.vo.BVO;
import com.ict.vo.FVO;
import com.ict.vo.MVO;
import com.ict.vo.VO;
import com.mysql.cj.Session;

@Controller
public class MyController 
{
	@Autowired
	private MyService myservice;
	
	@Autowired
	private Paging paging;
	
	
	@RequestMapping("main.do")
	public ModelAndView mainCommand(@RequestParam("cPage")String cPage)
	{
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("cPage", cPage);
		return mv;
	}
	
	/* @RequestMapping("search.do")
	public ModelAndView searchCommand(@RequestParam("search")String search,
			@ModelAttribute("choice")String choice)
	{
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("search", search);
		mv.addObject("choice", choice);
		return mv;
	}*/
	
	@RequestMapping("search.do")
	public ModelAndView search3Command(@RequestParam("search")String search,
			@ModelAttribute("choice")String choice)
	{
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("search", search);
		mv.addObject("choice", choice);
		return mv;
	}
	
	// search_ok.do
	@RequestMapping("search_ok.do")
	public ModelAndView search_okCommand(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("search");
		String choice = request.getParameter("choice");
		String choose = request.getParameter("choose");
		
		mv.addObject("choice", choice);
		mv.addObject("choose", choose);
		return mv;
	}
	
	/* @RequestMapping("search2.do")
	public ModelAndView search_chooseCommand(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("search2");
		String choice = request.getParameter("choice");
		String choose = request.getParameter("choose");
		
		mv.addObject("choice", choice);
		mv.addObject("choose", choose);
		return mv;
	}*/
	
	@RequestMapping("onelist.do")
	public ModelAndView onelistCommand()
	{
		return new ModelAndView("onelist");
	}
	
	@RequestMapping("addr_search.do")
	public ModelAndView addr_searchCommand(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("addr_search");
		String addr = request.getParameter("addr_search");
		mv.addObject("addr", addr);
		return mv;
	}
	
	@RequestMapping("food_restaurant.do")
	public ModelAndView food_restaurantCommand()
	{
		return new ModelAndView("food_restaurant");
	}
	
	@RequestMapping("food_restaurant2.do")
	public ModelAndView food_restaurant2Command()
	{
		return new ModelAndView("food_restaurant2");
	}
	
	@RequestMapping("board.do")
	public ModelAndView boardCommand(@ModelAttribute("cPage")String cPage)
	{
		try {
			ModelAndView mv = new ModelAndView("board");
			
			// 전체 게시물의 수
			int count = myservice.selectCount();
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				// 전체 페이지의 수 계산하기
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				// 주의 사항 : 나머지가 존재하면 전체 페이지 수에 +1를 한다.
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}
			// 현재 페이지 구하기
			paging.setNowPage(Integer.parseInt(cPage));
			
			// 시작번호, 끝번호
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작블록, 끝블록
			paging.setBeginBlock((int)((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의사항 : endBlock 이 totalPage 보다 큰 경우 발생 할 수 있다.
			// 이 경우 endBlock를 totalPage에 맞춰야 한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			List<BVO> list = myservice.selectList(paging.getBegin(), paging.getEnd());
			if (list != null) {
				mv.addObject("list",list);
				
			}
			
			
			List<BVO> list2 = myservice.selectList2(paging.getBegin(), paging.getEnd());
			if (list2 != null) {
				mv.addObject("list2",list2);
				
			}
			mv.addObject("pvo", paging);
			
			return mv;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("write1.do")
	public ModelAndView write1Command(@ModelAttribute("cPage")String cPage)
	{
		ModelAndView mv = new ModelAndView("write1");
		mv.addObject("cPage", cPage);
		return mv;
	}
	
	@RequestMapping("write2.do")
	public ModelAndView write2Command(@ModelAttribute("cPage")String cPage)
	{
		ModelAndView mv = new ModelAndView("write2");
		mv.addObject("cPage", cPage);
		return mv;
	}
	
	@RequestMapping("write3.do")
	public ModelAndView write3Command(@ModelAttribute("cPage")String cPage, @RequestParam("idx")String idx)
	{
		ModelAndView mv = new ModelAndView("write3");
		try {
			BVO bvo = myservice.selectOneList(idx);
			mv.addObject("idx", idx);
			mv.addObject("cPage", cPage);
			mv.addObject("title", bvo.getTitle());
			mv.addObject("content", bvo.getContent());
			mv.addObject("content2", bvo.getContent());
			return mv;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("write4.do")
	public ModelAndView write4Command(@ModelAttribute("cPage")String cPage)
	{
		ModelAndView mv = new ModelAndView("write4");
		mv.addObject("cPage", cPage);
		return mv;
	}
	
	@RequestMapping("del.do")
	public ModelAndView delCommand(@ModelAttribute("cPage")String cPage, @ModelAttribute("idx")String idx)
	{
		try {
			int result = myservice.delete(idx);
			if (result == 1) {
				return new ModelAndView("redirect:mypage.do?");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("food_del.do")
	public ModelAndView food_delCommand(@ModelAttribute("cPage")String cPage, @ModelAttribute("id")String id)
	{
		try {
			int result = myservice.deletefood(id);
			if (result == 1) {
				return new ModelAndView("redirect:mypage.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("mypage.do")
	public ModelAndView mypageCommand(@ModelAttribute("cPage")String cPage, HttpSession session)
	{
		try {
			
			ModelAndView mv = new ModelAndView("mypage");

			// 전체 게시물의 수
			int count = myservice.selectCount();
			paging.setTotalRecord(count);

			// 전체 페이지의 수
			if (paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			} else {
				// 전체 페이지의 수 계산하기
				paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
				// 주의 사항 : 나머지가 존재하면 전체 페이지 수에 +1를 한다.
				if (paging.getTotalRecord() % paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage() + 1);
				}
			}
			// 현재 페이지 구하기
			paging.setNowPage(Integer.parseInt(cPage));

			// 시작번호, 끝번호
			paging.setBegin((paging.getNowPage() - 1) * paging.getNumPerPage() + 1);
			paging.setEnd((paging.getBegin() - 1) + paging.getNumPerPage());

			// 시작블록, 끝블록
			paging.setBeginBlock(
					(int) ((paging.getNowPage() - 1) / paging.getPagePerBlock()) * paging.getPagePerBlock() + 1);
			paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock() - 1);

			// 주의사항 : endBlock 이 totalPage 보다 큰 경우 발생 할 수 있다.
			// 이 경우 endBlock를 totalPage에 맞춰야 한다.
			if (paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			String id = (String)session.getAttribute("id");
			List<BVO> mylist = myservice.selectmyList(paging.getBegin(), paging.getEnd());
			
			List<BVO> mylist2 = myservice.selectmyList2(id);
			List<VO> foodlist = myservice.selectfoodList(id);
			mv.addObject("mylist2", mylist2);
			mv.addObject("foodlist", foodlist);
			mv.addObject("pvo", paging);

			return mv;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("loadfind.do")
	public ModelAndView loadfindCommand()
	{
		return new ModelAndView("loadfind");
	}
	
	@RequestMapping("login.do")
	public ModelAndView loginCommand()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping("join.do")
	public ModelAndView joinCommand()
	{
		return new ModelAndView("join");
	}
	
	// id 중복 확인
	@RequestMapping(value = "id_chk.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String id_chkCommand(@ModelAttribute("id")String id)
	{
		try 
		{
			int result = myservice.selectIdChk(id);
			
			if (result == 1) 
			{
				return "1";
			}else
			{
				return "0";
			}
		} catch (Exception e) 
		{
			// TODO: handle exception
		}

		return null;
	}
	
	// id, pw 확인
	@RequestMapping(value = "id_pw_chk.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String id_pw_chkCommand(HttpServletRequest request, HttpSession session)
	{
		try 
		{
			
			MVO mvo = new MVO();
			mvo.setId(request.getParameter("id"));
			mvo.setPw(request.getParameter("pw"));
			mvo.setU_id(request.getParameter("login"));
			int result = myservice.selectId_PwChk(mvo);
			if (result == 1) 
			{
				session.setAttribute("id", mvo.getId());
				session.setAttribute("idx", mvo.getIdx());
				session.setAttribute("u_id", mvo.getU_id());
				session.setAttribute("login_ok", "1");
				return "1";
				
			}else
			{
				session.setAttribute("login_ok", "0");
				return null;
			}
		} catch (Exception e) 
		{
			System.out.println(e);
		}

		return null;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logoutCommand(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("main");
		session.removeAttribute("id");
		session.removeAttribute("login_ok");
		return mv;
	}
	
	@RequestMapping("pw_change.do")
	public ModelAndView pw_changeCommand(HttpServletRequest request, @ModelAttribute("cPage")String cPage)
	{
		MVO mvo = new MVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPw(request.getParameter("pw"));
		try {
			int result = myservice.updatePw(mvo);
			if (result == 1) {
				return new ModelAndView("redirect:mypage.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@RequestMapping("tel_change.do")
	public ModelAndView tel_changeCommand(HttpServletRequest request, @ModelAttribute("cPage")String cPage)
	{
		MVO mvo = new MVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPhone(request.getParameter("phone"));
		try {
			int result = myservice.updatePhone(mvo);
			if (result == 1) {
				return new ModelAndView("redirect:mypage.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("join_ok.do")
	public ModelAndView join_okCommand(HttpServletRequest request)
	{
		try 
		{
			MVO mvo = new MVO();
			mvo.setId(request.getParameter("id"));
			mvo.setPw(request.getParameter("pw"));
			mvo.setPhone(request.getParameter("tel_num"));
			mvo.setGender(request.getParameter("gender"));
			mvo.setMail(request.getParameter("email"));
			mvo.setU_id(request.getParameter("user"));
			int result = myservice.insertJoin(mvo);
			if (result == 1) 
			{
				return new ModelAndView("redirect:login.do");
			}
		} catch (Exception e) 
		{
			System.out.println(e);
		}

		return new ModelAndView("redirect:join.do");
	}
	
	
	
	@RequestMapping("idfind.do")
	public ModelAndView idfindCommand()
	{
		return new ModelAndView("idfind");
	}
	
	@RequestMapping("pwfind.do")
	public ModelAndView pwfindCommand()
	{
		return new ModelAndView("pwfind");
	}
	
	@RequestMapping("master.do")
	public ModelAndView masterCommand()
	{
		return new ModelAndView("master");
	}
	
	@RequestMapping("download.do")
	public void downCommand(@RequestParam("file_name")String file_name,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition","attachment; filename="+URLEncoder.encode(file_name,"utf-8"));
			File file = new File(new String(path.getBytes("utf-8")));
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			FileCopyUtils.copy(bis, bos);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
			}
		}
	}
	
	@RequestMapping("main_msg.do")
	public ModelAndView main_msgCommand(@RequestParam("msg")String msg, HttpSession session)
	{
		ModelAndView mv = new ModelAndView("main");
		session.setAttribute("msg", msg);
		return mv;
	}
	
	@RequestMapping("board_onelist.do")
	public ModelAndView board_onelistCommand(@ModelAttribute("idx")String idx, @ModelAttribute("cPage")String cPage)
	{
		ModelAndView mv = new ModelAndView("board_onelist");
		try {
			BVO bvo = myservice.selectOneList(idx);
			if (bvo != null) {
				mv.addObject("bvo", bvo);
				mv.addObject("cPage",cPage);
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping(value = "board_ok.do")
	public ModelAndView board_okCommand(HttpServletRequest request, @ModelAttribute("cPage")String cPage)
	{
		BVO bvo = new BVO();
		try 
		{
			bvo.setWriter(request.getParameter("id"));
			bvo.setTitle(request.getParameter("title"));
			bvo.setContent(request.getParameter("content"));
			int result = myservice.InsertBVO(bvo);
			if (result == 1) 
			{
				
				return new ModelAndView("redirect:board.do");
				
			}else
			{
				return new ModelAndView("redirect:write1.do");
			}
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = "board_ok2.do", method = RequestMethod.POST)
	public ModelAndView board_ok2Command(BVO bvo, HttpServletRequest request, @ModelAttribute("cPage")String cPage)
	{
		try 
		{
			// BVO bvo = new BVO();
			
			String path = request.getSession().getServletContext().getRealPath("/resources/image");
			
			MultipartFile file = bvo.getF_name();
			if(file.isEmpty()) {
				bvo.setFile_name("");
			}else {
				bvo.setFile_name(file.getOriginalFilename());
			}
			bvo.setWriter(request.getParameter("id"));
			bvo.setContent(request.getParameter("content"));
			
			int result = myservice.InsertBVO2(bvo);
			if (result > 0) 
			{
				if(! bvo.getFile_name().isEmpty()) {
					byte[] in = file.getBytes();
					File out = new File(path, bvo.getFile_name());
					FileCopyUtils.copy(in, out);
				}
				return new ModelAndView("redirect:board.do?cPage="+cPage);
				
			}else
			{
				return new ModelAndView("redirect:write2.do?cPage="+cPage);
			}
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping("image_board.do")
	public ModelAndView image_boardCommand(@ModelAttribute("cPage")String cPage, @ModelAttribute("idx")String idx)
	{
		try {
			ModelAndView mv = new ModelAndView("image_board");
			BVO bvo = myservice.selectOneList(idx);
			if (bvo != null) {
				mv.addObject("bvo", bvo);
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("mypage_ok.do")
	public ModelAndView mypage_okCommand(HttpServletRequest request, @ModelAttribute("cPage")String cPage)
	{
		BVO bvo = new BVO();
		bvo.setIdx(request.getParameter("idx"));
		System.out.println(bvo.getIdx());
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		try {
			int result = myservice.updateList(bvo);
			if (result == 1) {
				return new ModelAndView("redirect:mypage.do");
			}else
			{
				return new ModelAndView("redirect:write3.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping("master_ok.do")
	public ModelAndView master_okCommand(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("master");
		MVO mvo = new MVO();
		try {
			mvo.setId(request.getParameter("id"));
			mvo.setPw(request.getParameter("pw"));
			int result = myservice.selectMaster(mvo);
			if (result == 1) 
			{
				return mv;
				
			}else
			{
				return new ModelAndView("redirect:login.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 아이디 비밀번호 찾기는 나중에 메일로 발송하는걸로 바꿔보자
	@RequestMapping(value ="idfind_ok.do", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String idfind_okCommand(@ModelAttribute("email")String email,@ModelAttribute("tel_num")String tel_num,
									@ModelAttribute("pw")String pw)
	{
		try {
			MVO mvo = new MVO();
			/*
			 * mvo.setMail(request.getParameter("email"));
			 * mvo.setPhone(request.getParameter("tel_num"));
			 * mvo.setPw(request.getParameter("pw"));
			 */
			mvo.setMail(email);
			mvo.setPhone(tel_num);
			mvo.setPw(pw);
			String result = myservice.selectIdFind(mvo);
			System.out.println(result);
			if (result != null) {
				return result;
			}else if(result == null)
			{
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@RequestMapping(value = "pwfind_ok.do", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String pwfind_okCommand(@ModelAttribute("email")String email,@ModelAttribute("tel_num")String tel_num,
			@ModelAttribute("id")String id)
	{
		try {
			MVO mvo = new MVO();
			mvo.setMail(email);
			mvo.setPhone(tel_num);
			mvo.setId(id);
			String result = myservice.selectPwFind(mvo);
			System.out.println(result);
			if (result != null) {
				return result;
			}else if(result == null)
			{
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
}
