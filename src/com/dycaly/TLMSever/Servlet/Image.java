package com.dycaly.TLMSever.Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class Image
 */
@WebServlet("/Image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
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
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		
		string2Image(image, name);
		
		
		
	}
	
	public boolean string2Image(String imgStr, String imgFilePath) {  
	    // 对字节数组字符串进行Base64解码并生成图片  
	    if (imgStr == null)  
	        return false;  
	    try {  
	        // Base64解码  
	        byte[] b = new BASE64Decoder().decodeBuffer(imgStr);  
	        for (int i = 0; i < b.length; ++i) {  
	            if (b[i] < 0) {  
	                // 调整异常数据  
	                b[i] += 256;  
	            }  
	        }  
	        // 生成Jpeg图片  
	        OutputStream out = new FileOutputStream("C://Image/"+imgFilePath);  
	        out.write(b);  
	        out.flush();  
	        out.close();  
	        return true;  
	    } catch (Exception e) {  
	        return false;  
	    }  
	}     

}
