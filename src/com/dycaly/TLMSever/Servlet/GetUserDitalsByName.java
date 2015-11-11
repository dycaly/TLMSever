package com.dycaly.TLMSever.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dycaly.TLMSever.Manage.UserDitalsManage;
import com.dycaly.TLMSever.Manage.UserManage;

/**
 * Servlet implementation class GetUserDitalsByName
 */
@WebServlet("/GetUserDitalsByName")
public class GetUserDitalsByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDitalsByName() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		UserManage um = new UserManage(username,2015111);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		if (um.isExist()) {
			int id = um.getUserId();
			UserDitalsManage udm = new UserDitalsManage(id);
			String result = udm.getJson();
			System.out.println(result);
			pw.write(result);
			udm.close();

		}
		else {
			String result="{\"status\":1,\"reson\":\"查询失败\"}";
			System.out.println(result);
			pw.write(result);;
		}
	}

}
