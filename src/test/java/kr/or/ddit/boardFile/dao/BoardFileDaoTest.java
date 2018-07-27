package kr.or.ddit.boardFile.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.boardFile.dao.BoardFileDao;
import board.boardFile.dao.BoardFileDaoInf;
import board.boardFile.model.BoardFileVo;

public class BoardFileDaoTest {

	private BoardFileDaoInf boardFileDao;
	//@before - test - after
	
	@Before
	public void setup(){
		boardFileDao = new BoardFileDao();

	}


	@Test
	public void getAllFiles() {

		/***Given***/
		int w_id = 1;
		/***When***/
		List<BoardFileVo> boardFileList = boardFileDao.getAllFiles(w_id);
		/***Then***/
		assertEquals(1, boardFileList.size());
	}

	@Test
	public void getFileById() {
		/***Given***/
		int f_id=1;

		/***When***/
		BoardFileVo boardFileVo = boardFileDao.getFileById(f_id);
		
		/***Then***/
		assertEquals(2, boardFileVo.getW_id());
	}

	@Test
	public void insertFile() {
		/***Given***/
		BoardFileVo boardFileVo = new BoardFileVo();
		boardFileVo.setW_id(1);
		boardFileVo.setStd_id("std_25");
		boardFileVo.setF_path("junit test");
		boardFileVo.setF_name("junit test");
		boardFileVo.setF_file("junit test");
	
		/***When***/
		int insert = boardFileDao.insertFile(boardFileVo);
		
		/***Then***/
		assertEquals(1, insert);
	}


}
