package com.dycaly.TLMSever.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dycaly.TLMSever.Manage.ProductManage;

/**
 * Servlet implementation class BuyProduct
 */
@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProduct() {
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
		String token = request.getParameter("token");
		int id = Integer.parseInt(request.getParameter("productid"));
		ProductManage pm = new ProductManage(id);
		int rlt = pm.buyProduct(token);
		
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if (rlt==0) {
			String result="{\"status\":0}";
			System.out.println(result);
			pw.write(result);
		}
		else if (rlt==1) {
			String result="{\"status\":1,\"reason\":\"用户不存在\"}";
			System.out.println(result);
			pw.write(result);
		}
		else if(rlt ==2){
			String result="{\"status\":2,\"reason\":\"该商品已被购买\"}";
			System.out.println(result);
			pw.write(result);
		}
	}

}
