package kr.or.ddit.comment.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.comment.model.CommentVo;
import board.comment.service.CommentService;
import board.comment.service.CommentServiceInf;

public class CommentServiceTest {

	private CommentServiceInf commentService;
	//@before - test - after
	@Before
	public void setup(){
		commentService = new CommentService();

	}

	@Test
	public void getAllComments(){
		int w_id = 1;

		List<CommentVo> commentList = commentService.getAllComments(w_id);

		for (CommentVo vo : commentList) {
			System.out.println(vo);
		}

		/***Then***/
		assertEquals(4, commentList.size());
	}


	@Test
	public void getCountComments(){
		/***Given***/
		int w_id=1;

		/***When***/
		int count = commentService.getCountComments(w_id);

		/***Then***/
		assertEquals(4, count);
	}
	
	@Test
	public void getCommentById(){
		/***Given***/
		int c_id=1;

		/***When***/
		CommentVo commentVo =commentService.getCommentById(c_id);

		/***Then***/
		assertEquals(4, commentVo.getW_id());
	}
	
	@Test
	public void updateComment (){
		/***Given***/
		CommentVo commentVo = new CommentVo();
		commentVo.setC_delny("N");
		commentVo.setC_id(1);
		commentVo.setC_cmt("수정된 댓글");
		/***When***/
		int update = commentService.updateComment(commentVo);

		/***Then***/
		assertEquals(1, update);

	}
	
	@Test
	public void insertComment (){

		/***Given***/
		CommentVo commentVo = new CommentVo();
		commentVo.setW_id(1);
		commentVo.setStd_id("std_25");
		commentVo.setC_cmt("수정된 댓글");
		commentVo.setC_delny("N");
		commentVo.setC_regdt(new Date());
		/***When***/
		int create = commentService.updateComment(commentVo);

		/***Then***/
		assertEquals(1, create);

	}
}
