package com.dycaly.TLMSever.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dycaly.TLMSever.Manage.UserDitalsManage;
import com.dycaly.TLMSever.Manage.UserManage;

/**
 * Servlet implementation class SetUserDitals
 */
@WebServlet("/SetUserDitals")
public class SetUserDitals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUserDitals() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String token = request.getParameter("token");
		PrintWriter pw = response.getWriter();
		UserManage um = new UserManage(token);
		if (um.isExist()) {
			int id = um.getUserId();
			UserDitalsManage udm = new UserDitalsManage(id);
			udm.updateUserDitals(request.getParameter("picurl"),
					URLDecoder.decode(request.getParameter("nickname"), "utf-8"),
					URLDecoder.decode(request.getParameter("name"), "utf-8"),
					Integer.parseInt(request.getParameter("age")),
					Integer.parseInt(request.getParameter("sex")),
					URLDecoder.decode(request.getParameter("school"), "utf-8"),
					URLDecoder.decode(request.getParameter("college"), "utf-8"),
					request.getParameter("email"),
					request.getParameter("phone"));
			String result="{\"status\":0}";
			System.out.println(result);
			pw.write(result);
		}
		else {
			String result="{\"status\":1,\"reason\":\"修改失败\"}";
			System.out.println(result);
			pw.write(result);
		}
		um.close();
	}

}
