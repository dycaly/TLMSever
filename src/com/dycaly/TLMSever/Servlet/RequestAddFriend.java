package com.dycaly.TLMSever.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dycaly.TLMSever.Manage.UserManage;

/**
 * Servlet implementation class RequestAddFriend
 */
@WebServlet("/RequestAddFriend")
public class RequestAddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAddFriend() {
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
		String username = request.getParameter("username");
		
		UserManage um = new UserManage(token);
		int rlt = um.reqAddFriend(username);
		
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if (rlt == 0) {
			String result="{\"status\":0}";
			System.out.println(result);
			pw.write(result);
		}
		else if (rlt==1) {
			String result="{\"status\":1,\"reason\":\"请求已存在\"}";
			System.out.println(result);
			pw.write(result);
		}
		else if (rlt==2) {
			String result="{\"status\":2,\"reason\":\"好友已存在\"}";
			System.out.println(result);
			pw.write(result);
		}
		else if (rlt==3) {
			String result="{\"status\":3,\"reason\":\"不能添加自己为好友\"}";
			System.out.println(result);
			pw.write(result);
		}
		else {
			String result="{\"status\":2,\"reason\":\"请求失败\"}";
			System.out.println(result);
			pw.write(result);
		}
		um.close();
	}

}
