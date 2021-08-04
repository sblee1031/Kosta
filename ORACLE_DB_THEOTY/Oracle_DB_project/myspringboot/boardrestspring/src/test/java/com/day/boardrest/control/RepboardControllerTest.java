package com.day.boardrest.control;

import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(RepBoardController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)//모의객체에 컨트롤러에 주입해서 테스트
@AutoConfigureMockMvc
class RepboardControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@DisplayName("상세게시물 검색성공 테스트")//주피터 버전부터는 DisplayName으로 단위테스트가할 기능을 간단히 적을 수 있음 
	void test() {
		MockHttpServletRequestBuilder requestBuilder;//빌더를 이용하면, get/post메소드 같은것을 사용할 수 있다. 

		String uri = "/board/100";
		requestBuilder = MockMvcRequestBuilders.get(uri); //요청에 관련된 메서드 
	     requestBuilder.accept(MediaType.APPLICATION_JSON);
		try {
			  //1. 응답 테스트
			ResultActions resultActions = mockMvc.perform(requestBuilder);
			ResultMatcher ok = MockMvcResultMatchers.status().isOk();
			resultActions.andExpect(ok);
			ResultHandler resultHandler = MockMvcResultHandlers.print();
			
			resultActions.andDo(resultHandler);
			
		} catch (Exception e) {			
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
