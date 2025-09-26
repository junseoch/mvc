package com.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { 
	// Result 타입으로 무조건 리턴
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	
}
