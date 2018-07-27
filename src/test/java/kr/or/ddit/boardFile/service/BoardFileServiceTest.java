package kr.or.ddit.boardFile.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.boardFile.model.BoardFileVo;
import board.boardFile.service.BoardFileService;
import board.boardFile.service.BoardFileServiceInf;


public class BoardFileServiceTest {

	private BoardFileServiceInf boardFileService;
	
	//@before - test - after
	@Before
	public void setup(){
		boardFileService = new BoardFileService();
		
	}
	
	

	@Test
	public void getAllFiles() {

		/***Given***/
		int w_id = 1;
		/***When***/
		List<BoardFileVo> boardFileList = boardFileService.getAllFiles(w_id);
		/***Then***/
		assertEquals(1, boardFileList.size());
	}

	@Test
	public void getFileById() {
		/***Given***/
		int f_id=1;

		/***When***/
		BoardFileVo boardFileVo = boardFileService.getFileById(f_id);
		
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
		int insert = boardFileService.insertFile(boardFileVo);
		
		/***Then***/
		assertEquals(1, insert);
	}


}
