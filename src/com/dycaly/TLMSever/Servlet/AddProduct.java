package com.dycaly.TLMSever.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dycaly.TLMSever.Manage.ClassifyManage;
import com.dycaly.TLMSever.Manage.ProductManage;
import com.dycaly.TLMSever.Manage.UserManage;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String profucturl = request.getParameter("producturl");
		String productname = request.getParameter("productname");
		String productintro = request.getParameter("productintro");
		String token = request.getParameter("token");
		String classname = request.getParameter("classname");
		int hightestprice = Integer.parseInt(request
				.getParameter("hightestprice"));
		int lowestprice = Integer.parseInt(request.getParameter("lowestprice"));
		int cuttime = Integer.parseInt(request.getParameter("cuttime"));
		int cutPrice = Integer.parseInt(request.getParameter("cutprice"));
		ProductManage pm = new ProductManage(
				new ClassifyManage(classname).getClassify(), new UserManage(
						token).getUser(), profucturl, productname,
				productintro, hightestprice, lowestprice,cutPrice, cuttime, 0,
				new Timestamp(System.currentTimeMillis()));
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String result = "{\"status\":0}";
		System.out.println(result);
		pw.write(result);
	}

}
