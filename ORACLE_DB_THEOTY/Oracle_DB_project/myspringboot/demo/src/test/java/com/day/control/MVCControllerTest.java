package com.day.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(MVCController.class)
class MVCControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void test() throws Exception {
		MockHttpServletRequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.get("/a");
		requestBuilder.param("id", "id1");
		ResultActions resultActions = mockMvc.perform(requestBuilder);//요청테스트
		
		ResultMatcher matcher = MockMvcResultMatchers.status().isOk();
		resultActions.andExpect(matcher);
		
//		String expectedURL = "/WEB-INF/jsp/a.jsp";
//		ResultMatcher matcher1 = MockMvcResultMatchers.forwardedUrl(expectedURL);
//		resultActions.andExpect(matcher1);//테스트
		String expectedViewName = "a";
		ResultMatcher matcher1 = MockMvcResultMatchers.forwardedUrl(expectedViewName);
		resultActions.andExpect(matcher1);//테스트
	}

}
