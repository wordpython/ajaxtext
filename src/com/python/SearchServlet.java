package com.python;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static List<String> datas=new ArrayList<String>();
	static {
		//这些是模拟数据
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("becky");
		datas.add("bill");
		datas.add("css js ajax");
		datas.add("james");
		datas.add("ierrv");
		datas.add("aqwer");
		datas.add("aword post");
		datas.add("appppp");
		datas.add("attttt");
		datas.add("aooooo ajax");
		datas.add("ajadsioi");
		datas.add("aqwertyyuiop");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先获得客户端发送来的数据keyword
		String keyword=request.getParameter("keyword");
		//获得关键字之后进行处理，得到关联数据
		List<String> listData=getData(keyword);
		//返回Json格式
//		System.out.println(JSON.toJSONString(listData));
		response.getWriter().write(JSON.toJSONString(listData).toString());
	}
	
	//获得关联数据的方法
	public List<String> getData(String keyword){
		List<String> list=new ArrayList<String>();
		//遍历数据库里的表，返回关联数据	
		for(String data:datas) {
			if(data.contains(keyword)) {
				list.add(data);
			}
		}
		return list;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
