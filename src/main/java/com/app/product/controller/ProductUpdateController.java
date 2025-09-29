package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.exception.ProductNotFoundException;
import com.app.vo.ProductVO;

public class ProductUpdateController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Result result = new Result();
		
		ProductDAO productDAO = new ProductDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		
		// ProductNotFoundException::new : 값이 null 
		// productDAO.select(id)가 통째로 ProductVO
		try {
			ProductVO foundProduct =  productDAO.select(id).orElseThrow(ProductNotFoundException::new);
			req.setAttribute("product", foundProduct);
		} catch (ProductNotFoundException e) {
			result.setPath("/error.jsp");
			req.setAttribute("message", "상품을 찾을 수 없습니다");
			System.out.println("ProductUpdateController Product Not Found Error");
		}
		
		result.setPath("/update.jsp");
		return result;
	}
}
