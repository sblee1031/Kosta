package com.day.boardrest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.day.boardrest.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.exception.RemoveException;
@Repository
public class RepBoardDAOOracle implements RepBoardDAO {
	@Autowired	
	@Qualifier("UnderscoreToCamelCase")
	private SqlSessionFactory sessionFactory;
	@Override
	public void insert(RepBoard repBoard) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.dto.RepBoardMapper.insert", repBoard);
//			//session.commit();
		}catch(Exception e) {
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) session.close();
		}
	}

	
	@Override
	public RepBoard selectByNo(int boardNo) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			RepBoard repBoard = session.selectOne(
					"com.day.dto.RepBoardMapper.selectByNo", 
					boardNo);
			if(repBoard == null) {
				throw new FindException("게시글이 없습니다");
			}
			return repBoard;
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			session.close();
		}
	}

	@Override
	public List<RepBoard> selectAll() throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectList("com.day.dto.RepBoardMapper.selectAll");
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			session.close();
		}
	}

	@Override
	public List<RepBoard> selectByWord(String word) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectList(
					"com.day.dto.RepBoardMapper.selectByWord", word);
		}catch(Exception e) {
			throw new FindException(e.getMessage());
		}finally {
			session.close();
		}
	}
	
	@Override
	public void plusViewCount(int boardNo) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int rowCnt = session.update("com.day.dto.RepBoardMapper.plusViewCount", boardNo);
			if(rowCnt == 0) {
				throw new ModifyException("글번호가 없습니다");
			}
		}catch(Exception e) {
			throw new ModifyException(e.getMessage());
		}finally {
			session.close();
		}
	}

	@Override
	public void update(RepBoard repBoard) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int rowcnt = session.update("com.day.dto.RepBoardMapper.update", repBoard);
			if(rowcnt == 0) {
				throw new ModifyException("수정실패: 작성자아이디가 다르거나 글번호가 없습니다");
			}
		}catch(Exception e) {
			throw new ModifyException(e.getMessage());
		}finally {
			session.close();
		}
	}	
	@Override
	@Transactional(rollbackFor = RemoveException.class)
	public void delete(RepBoard repBoard) throws RemoveException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			deleteReply(session, repBoard.getBoardNo());
			deleteWrite(session, repBoard);
		}finally {
			session.close();
		}
	}
	
	/**
	 * 답글 모두 삭제
	 * @param boardNo 글번호
	 * @throws RemoveException
	 */
	private void deleteReply(SqlSession session, int boardNo) throws RemoveException {
		try {
			session.update("com.day.dto.RepBoardMapper.deleteReply", boardNo);
		}catch(Exception e) {
			throw new RemoveException(e.getMessage());
		
		}
	}
	/**
	 * 글 삭제
	 * @param 게시글객체, 게시글번호와 게시글 작성자를 포함한다
	 * @throws RemoveException
	 */
	private void deleteWrite(SqlSession session, RepBoard repBoard) throws RemoveException {
		try {

			int rowcnt = session.update("com.day.dto.RepBoardMapper.deleteWrite", repBoard);
			if(rowcnt == 0) {
				throw new RemoveException("삭제실패: 작성자아이디가 다르거나 글번호가 없습니다");
			}
		}catch(Exception e) {
			throw new RemoveException(e.getMessage());
		}
	}
	

}
