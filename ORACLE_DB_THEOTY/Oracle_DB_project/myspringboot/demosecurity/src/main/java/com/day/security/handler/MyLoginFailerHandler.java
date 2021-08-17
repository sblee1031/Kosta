package com.day.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class MyLoginFailerHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
									HttpServletResponse response,
									AuthenticationException exception) throws IOException, ServletException {
		response.sendRedirect(request.getContextPath()+"/myLogin?error="+exception.getMessage());

	}

}
