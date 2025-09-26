package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.product.controller.ProductDeleteOkController;
import com.app.product.controller.ProductListController;
import com.app.product.controller.ProductReadController;
import com.app.product.controller.ProductUpdateController;
import com.app.product.controller.ProductUpdateOkController;
import com.app.product.controller.ProductWriteController;
import com.app.product.controller.ProductWriteOkController;

import oracle.sql.ConcreteProxyUtil;

public class ProductFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String target = req.getRequestURI().replace(req.getContextPath() + "/" , "").split("\\.")[0];
		System.out.println(target);
		
		Result result = null;
		
		if(target.equals("write")) {
			result = new ProductWriteController().execute(req, resp);
		} else if(target.equals("write-ok")) { // 리다이렉트 
			// ProductWriteOkController를 생성하고 그 클래스의 execute메서드를 실행시킨다
			result = new ProductWriteOkController().execute(req, resp);
			
		} else if(target.equals("list")) { // 포워드 list.product
//			목록 가져와서 뿌린다.
//			포워드,list.jsp (어디로 ,어떻게)
			
			result = new ProductListController().execute(req, resp);
			
		} else if(target.equals("read")) {
			
			result = new ProductReadController().execute(req, resp);
			
		} else if(target.equals("update")) {
			
			result = new ProductUpdateController().execute(req, resp);
			
		} else if(target.equals("update-ok")) {
			
			result = new ProductUpdateOkController().execute(req, resp);
			
		} else if(target.equals("delete-ok")) {
			result = new ProductDeleteOkController().execute(req, resp);
			
		} else {
//			404 NOT FOUND
		}
		
		
		// 어디서 어떻게를 result로 한 번에
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			} else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
