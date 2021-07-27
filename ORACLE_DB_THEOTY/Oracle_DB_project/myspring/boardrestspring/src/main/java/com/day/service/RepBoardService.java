package com.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day.dao.RepBoardDAO;
import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.exception.RemoveException;

@Service
public class RepBoardService {
	@Autowired
	private RepBoardDAO dao;
	/**
	 * 글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void write(RepBoard repBoard) throws AddException {
		repBoard.setParentNo(0);
		dao.insert(repBoard);
	}
	/**
	 * 답글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void reply(RepBoard repBoard) throws AddException {
		if(repBoard.getParentNo() == 0) {
			throw new AddException("부모글 번호가 필요합니다.");
		}
		dao.insert(repBoard);
	}
	public List<RepBoard> list(String word) throws FindException{
		return dao.selectByWord(word);
	}
	public List<RepBoard> list() throws FindException{
		return dao.selectAll();
	}
	/**
	 * 글 상세 보기
	 * @param boardNo
	 * @return
	 * @throws FindException
	 */
	public RepBoard info(int boardNo) throws FindException{
		try {
			dao.plusViewCount(boardNo);
		} catch (ModifyException e) {
			throw new FindException("조회수 증가 실패 : "+e.getMessage());
		}
		return dao.selectByNo(boardNo);
	}
	public void modify(RepBoard repBoard) throws AddException {
		try {
			dao.update(repBoard);
		} catch (ModifyException e) {
			throw new AddException(e.getMessage());
		}
	}
	
	public void remove(RepBoard repBoard) throws RemoveException {
		try {
			dao.delete(repBoard);
			
		} catch (Exception e) {
			throw new RemoveException("삭제할 게시물이 없습니다."+e.getMessage());
		}
	}
}
