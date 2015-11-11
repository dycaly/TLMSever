package com.dycaly.TLMSever.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * Servlet implementation class LoadImage
 */
@WebServlet("/LoadImage")
public class LoadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		showImage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		showImage(request, response);

		
		
	}
	public void showImage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 读取方式
        // response.setContentType("application/zip");
        response.setContentType("image/jpeg");
        // 获取图片绝对路径
        String name = request.getParameter("name");
        String path = "C://Image/"+name;
        File file = new File(path);
        // 创建文件输入流
        FileInputStream is = new FileInputStream(file);
        // 响应输出流
        ServletOutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        is.close();
        out.flush();
        out.close();
 
    }
	public void downlodeImage(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // 获取图片绝对路径
        String path = this.getServletContext().getRealPath("/");
        File file = new File(path + "/images/WIN_20131027_214421.JPG");
        //设置头信息,内容处理的方式,attachment以附件的形式打开,就是进行下载,并设置下载文件的命名
        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
        // 创建文件输入流
        FileInputStream is = new FileInputStream(file);
        // 响应输出流
        ServletOutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        is.close();
        out.flush();
        out.close();
 
    }


}
