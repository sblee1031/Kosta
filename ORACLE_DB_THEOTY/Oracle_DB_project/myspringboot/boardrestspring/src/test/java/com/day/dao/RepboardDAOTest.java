package com.day.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.day.dto.RepBoard;
import com.day.exception.FindException;
@SpringBootTest
class RepboardDAOTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RepBoardDAO dao;
	@Test
	void selectByNoTest() throws FindException {
		RepBoard board = dao.selectByNo(100);
		log.error(board.toString());
		assertNotNull(board.getBoardContent());
	}
	
	@Test
	void selectAllTest() throws FindException {
		List<RepBoard> list = dao.selectAll();
		//log.error(list.toString());
		assertNotNull(list.toString());
	}
	@Test
	void selectByWordTest() throws FindException {
		List<RepBoard> list = dao.selectByWord("글");
		//log.error(list.toString());
		assertNotNull(list.toString());
	}

}
