package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;

public class ProductListController implements Action{
	
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		JSONArray productsJSON = new JSONArray();
		ProductDAO productDAO = new ProductDAO();
		
		
		// key, value
		req.setAttribute("products", productDAO.selectAll());
		
		// 처음에는 productVO타입
		// 최종적으로는 JSONObject 타입
		// JSONArray타입의 productsJSON에 JSONObject를 put하겠다
		productDAO.selectAll().stream().map(JSONObject::new).forEach(productsJSON::put);
		
		// JSONArray가 Object
		// HttpServletRequest안에 있는 Attribute에  JSONArray타입의 productsJSON를 set해주겠다
		req.setAttribute("productsJSON", productsJSON);
		// 담을 수 있는 매개변수의 타입(Object)과 담을려고 하는 매개변수의 타입(JSONArray)

		result.setPath("/list.jsp");
		return result;
	}
}
