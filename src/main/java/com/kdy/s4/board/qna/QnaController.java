package com.kdy.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.board.file.BoardFileDTO;
import com.kdy.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("summernoteDelete")
	public ModelAndView summernoteDelete(String file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boolean result = qnaService.summernoteDelete(file, session);
		
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("summernote")
	public ModelAndView summernote(MultipartFile file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String fileName = qnaService.summernote(file, session);
		
		System.out.println("fileName : "+fileName);
		
		String name = session.getServletContext().getContextPath()+File.separator;
		// File.separator = \
		System.out.println("1. "+name);		// 1. /s4\
		name = name+"resources"+File.separator+"upload"+File.separator;
		System.out.println("2. "+name);		// 2. /s4\resources\ upload\
		name = name+"qna"+File.separator+fileName;
		System.out.println("3. "+name);		// 3. /s4\resources\ upload\ qna \005a8241-aa7e-4f5d-a3a9-0842b5936798_iphone12.png
		
		mv.addObject("msg", name);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "qna");
		mv.addObject("fileDTO", boardFileDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReply(boardDTO);
		
		String message = "Reply write Fail";
		
		if(result>0) {
			message = "Reply write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		
		return mv;
	}

	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "qna");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./qnaList");
		}
		
		return mv;
				
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = qnaService.getOne(boardDTO);
		
		mv.addObject("board", "qna");
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		System.out.println("qna write");
		
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO, files, session);
		
		String message = "write fail";
		
		if(result>0) {
			message = "Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("qna write");
		
		mv.addObject("board", "qna");
		
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		ar = null;
		BoardDTO boardDTO = ar.get(0);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("qna list");
		mv.setViewName("board/boardList");
		
		return mv;		
	}
	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView ex1() {
//		ModelAndView mv = new ModelAndView();
//		System.out.println("null pointer exception");
//		mv.setViewName("error/error_back");
//		return mv;
//	}
//	

}
