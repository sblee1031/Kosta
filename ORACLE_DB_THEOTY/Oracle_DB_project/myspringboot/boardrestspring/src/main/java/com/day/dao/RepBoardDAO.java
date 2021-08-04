package com.day.dao;

import java.util.List;

import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.exception.RemoveException;

public interface RepBoardDAO {
	/**
	 * 게시글 추가
	 * @param repBoard
	 * @throws AddException
	 */
	void insert(RepBoard repBoard) throws AddException;
	/**
	 * 글번호로 게시글 검색
	 * @param boardNo
	 * @return
	 * @throws FindException
	 */
	RepBoard selectByNo(int boardNo) throws FindException;
	/**
	 * 게시글 전체 검색
	 * @return
	 * @throws FindException
	 */
	List<RepBoard> selectAll() throws FindException;
	/**
	 * 제목이나 글내용에 단어로 포함한 게시글 검색
	 * @param word
	 * @return
	 * @throws FindException
	 */
	List<RepBoard> selectByWord(String word) throws FindException;
	/**
	 * 게시글 조회수 1증가
	 * @param boardNo
	 * @throws ModifyException
	 */
	void plusViewCount(int boardNo) throws ModifyException;
	/**
	 * 글내용 수정, 글번호는 수정안됨
	 * @param repBoard
	 * @throws ModifyException
	 */
	void update(RepBoard repBoard) throws ModifyException;
	/**
	 * 글 삭제, 답글이 있는 경우 답글도 모두 삭제 
	 * @param boardNo
	 * @throws RemoveException
	 */
	void delete(RepBoard repBoard) throws RemoveException; 
	/**
	 * 답글 삭제
	 * @param boardNo
	 * @throws RemoveException
	 */
}
