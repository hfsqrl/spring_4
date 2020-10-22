package com.kdy.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeUpdate")
	private ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = noticeService.getOne(boardDTO);
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = noticeService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "notice");
		} else {
			mv.setViewName("common/result");
			mv.addObject("msg", "no data");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO);
		
		String message = "write fail";
		
		if(result>0) {
			message = "Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice");
		
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("notice list");
		mv.setViewName("board/boardList");
		
		return mv;
		
	}

}
