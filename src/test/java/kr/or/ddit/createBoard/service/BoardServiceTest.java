package kr.or.ddit.createBoard.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.createBoard.model.BoardVo;
import board.createBoard.service.BoardService;
import board.createBoard.service.BoardServiceInf;

public class BoardServiceTest {

	private BoardServiceInf boardService;
	
	//@before - test - after
	@Before
	public void setup(){
		boardService = new BoardService();
		
	}
	
	@Test
	public void getAllBoards(){
		/***Given***/
		/***When***/
		List<BoardVo> boardList = boardService.getAllBoards();
		
		for (BoardVo vo : boardList) {
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(4, boardList.size());
		

	}
		
	@Test
	public void getBoardById(){
		/***Given***/
		int b_id = 1;
		
		/***When***/
		BoardVo boardVo = boardService.getBoardById(b_id);
		System.out.println("selectStudentsById : "+ b_id);
		
		/***Then***/
		assertEquals("자유게시판", boardVo.getB_name());
	}
		
	@Test
	public void updateBoard (){
		
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setB_id(4);
		boardVo.setB_useny("Y");
		boardVo.setB_name("test");
		/***When***/
		int update = boardService.updateBoard(boardVo);
		
		/***Then***/
		assertEquals(1, update);
	}
		
	@Test
	public void insertBoard(){
		/***Given***/
	  	BoardVo boardVo = new BoardVo();
		boardVo.setB_id(4);
		boardVo.setStd_id("std_2");
		boardVo.setB_regdt(new Date());
		boardVo.setB_name("test");
	  	
		/***When***/
		int insert = boardService.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, insert);

	}
		
}
