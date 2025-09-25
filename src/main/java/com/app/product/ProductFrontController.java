package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.product.controller.ProductWriteOkController;

public class ProductFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String target = req.getRequestURI().replace(req.getContextPath() + "/" , "").split("\\.")[0];
		System.out.println(target);
		
		Result result = null;
		
		if(target.equals("write")) {
		} else if(target.equals("write-ok")) {
			result = new ProductWriteOkController().execute(req, resp);
			
		} else if(target.equals("list")) {
//			목록 가져와서 뿌린다.
//			포워드,list.jsp (어디로 ,어떻게)
			
		} else if(target.equals("read")) {
			
		} else if(target.equals("update")) {
			
		} else if(target.equals("update-ok")) {
			
		} else if(target.equals("delete-ok")) {
			
		} else {
//			404 NOT FOUND
		}
	
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			} else {
				req.getRequestDispatcher(result.getPath().forword(req, resp));
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
