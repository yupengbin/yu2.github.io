package com.nsu.CloudCompute.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class FileUpServlet
 */
public class FileUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*以上两行不能颠倒*/
		try {
			SmartUpload su = new SmartUpload();
			su.setAllowedFilesList("txt,jpg,JPG,docx,doc");
			// 上传初始化
			su.initialize(config, request, response);
			// 上传文件
			su.upload();
			// 读取当前网站实际物理路径
			String filePath = config.getServletContext().getRealPath("/WEB-INF/images");
			System.out.println(filePath);
			/* 根据用户名创建一个目录专门保存用户的图片 */
			File f = new File(filePath);
			if (!f.exists())
				f.mkdir();
			// 将上传文件全部保存到指定目录
			su.save(filePath);
			//su.save(destPathName, option)
			response.sendRedirect("./index.html");
		} catch (Exception ex) {
			out.println("未保存成功!");
		}
	}
		

}
