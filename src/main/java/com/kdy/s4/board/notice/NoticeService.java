package com.kdy.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kdy.s4.board.BoardDTO;
import com.kdy.s4.board.BoardService;
import com.kdy.s4.board.file.BoardFileDTO;
import com.kdy.s4.util.FileSaver;
import com.kdy.s4.util.Pager;

@Service
@Transactional
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Value("#{fileSave['notice']}")
	private String filePath;
	
	
	
	public int setInsertFile(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.setInsertFile(boardFileDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		// 파일을 hdd에 저장
		String path = session.getServletContext().getRealPath(filePath);
		
		File file = new File(path);
		System.out.println(path);
		// sequence 번호 받아와야
		//boardDTO.setNum(noticeDAO.getNum());
		
		// notice insert
		int result = noticeDAO.setInsert(boardDTO);
		System.out.println("num : "+boardDTO.getNum());
		
		// noticeFile insert
		
		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize()!=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(multipartFile.getOriginalFilename());
				boardFileDTO.setNum(boardDTO.getNum());
				
				noticeDAO.setInsertFile(boardFileDTO);
			}
		}
		
		
		return result;//return이 0이면 writeFail / noticeDAO.setInsert(boardDTO);
	}
		
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getOne(boardDTO);
	}

}
