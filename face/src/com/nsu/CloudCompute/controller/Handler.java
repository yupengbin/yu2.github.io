package com.nsu.CloudCompute.controller;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nsu.CloudCompute.code.RestTest;
import com.nsu.CloudCompute.exception.CustomerException;
import com.nsu.CloudCompute.pojo.Student;
import com.nsu.CloudCompute.service.CloudComputeService;
import com.nsu.CloudCompute.util.FaceUtil;


@Controller
public class Handler {
	//service
	@Resource(name="service")
	private CloudComputeService service;

	//*******登录
	@RequestMapping("/login.action")
	public @ResponseBody String login(String phoneNum, String password) {
		// 验证手机号
		if (phoneNum.equals("")) {
			return "num is null";
		}
		else if (phoneNum.contains(" ") || phoneNum.length() != 11) {
			return "num is incorrect";
		}
		
		//校验密码账号等是否正确
		try {
			service.login(phoneNum, password);
		} catch (CustomerException e) {
			String error=e.getMessage();
			if(error.equals("该账号没有被注册")){
				return "num not register";
			}
			else
				return "incorrect";
		}

		return "success";
	}
	
	
	

	//******注册
	@RequestMapping("/register.action")
	public @ResponseBody String register(Student student,String password2, HttpServletRequest request,String code) {
		System.out.println("注册开始了");
		System.out.println(student);
         
		String phoneNum = student.getPhoneNum();
		//判断手机号码是否正确
		if (phoneNum.equals("") || phoneNum.contains(" ") || phoneNum.length() != 11
				|| !phoneNum.substring(0, 1).equals("1")||!FaceUtil.isNumeric(phoneNum)) {
			return "phoneNum is incorrect";
		}
		
		//判断验证码，及判断用户输入是否正确
		String code_old=(String) request.getSession().getAttribute(student.getPhoneNum());
		if (code.length() != 4||!code.equals(code_old)) {
			return "code is incorrect";
		}
		
		//学生学号
		String studentId = student.getStudentId();
		if (studentId.length() != 11||!FaceUtil.isNumeric(studentId)) {
			return "studentId is incorrect";
		}

		//判断密码是否相等
		String password = student.getPassword();
		String passwordRepeat = password2;
		System.out.println(password+"   " +password2);
		if (!password.equals(passwordRepeat)) {
			return "two passwords input inconsistent";
		}
		
		//前面校验成功才进行注册
		try {
			service.register(student);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			return "phoneNum register";
		}
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	

	// *********手机验证码
	@RequestMapping("/code.action")
	public @ResponseBody String code(String phoneNum,HttpServletRequest request) {
	
		if (phoneNum.length() != 11 || !phoneNum.substring(0, 1).equals("1")||!FaceUtil.isNumeric(phoneNum)) {
			return "phoneNum is error";
		}
		
		//发送手机验证码
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int a = random.nextInt(10);
			stringBuffer.append("" + a);
		}
		System.out.println("验证码" + stringBuffer);
		System.out.println("手机号" + phoneNum);

		RestTest restTest = new RestTest();
		try {
			restTest.fun(stringBuffer.toString(), phoneNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute(phoneNum,stringBuffer.toString());

		return "success";

	}

}
