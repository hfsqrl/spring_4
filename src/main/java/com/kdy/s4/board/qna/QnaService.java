package com.kdy.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.board.BoardService;
import com.kdy.s4.board.file.BoardFileDTO;
import com.kdy.s4.util.FileSaver;
import com.kdy.s4.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	
	public String summernote(MultipartFile file, HttpSession session) throws Exception {
		// 파일을 하드 디스크에 저장하고 저장된 파일명을 리턴
		String path = session.getServletContext().getRealPath("/resources/upload/qna");
		
		File dest = new File(path);
		System.out.println(path);
		
		String fileName = fileSaver.saveCopy(dest, file);
		
		
		return fileName;
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.setReplyUpdate(boardDTO);
		result = qnaDAO.setReply(boardDTO);
		
		return result;
	}

	@Override // write
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/upload/qna");
		
		File file = new File(path);
		System.out.println(path);
		
		int result = qnaDAO.setInsert(boardDTO);
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.getSize()!=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(multipartFile.getOriginalFilename());
				boardFileDTO.setNum(boardDTO.getNum());
				qnaDAO.setInsertFile(boardFileDTO);
			}
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaDAO.getCount(pager));
		pager.makePage();
		return qnaDAO.getList(pager);
	}

	@Override // select
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getOne(boardDTO);
	}

}
