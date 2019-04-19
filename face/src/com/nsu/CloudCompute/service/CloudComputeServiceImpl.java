package com.nsu.CloudCompute.service;

import javax.annotation.Resource;

import com.nsu.CloudCompute.dao.CloudComputeDao;
import com.nsu.CloudCompute.dao.CloudComputeMapper;
import com.nsu.CloudCompute.exception.CustomerException;
import com.nsu.CloudCompute.pojo.Student;

public class CloudComputeServiceImpl implements CloudComputeService{
	
	
	@Resource(name="dao")
	private CloudComputeDao dao;

	@Override
	public boolean login(String phoneNum, String password) throws CustomerException {
		//查看该账号是否被注册
		Student student=dao.queryByPhoneNum(phoneNum);
		if(student==null){
			throw new CustomerException("该账号没有被注册");
		}
		
		String password_old=student.getPassword();
		if(password.equals(password_old)==false){
			throw new CustomerException("密码不正确");
		}
		
		
		
		return false;
		
		
	}

	@Override
	public String register(Student student) throws CustomerException{
		System.out.println("注册");
		System.out.println("dao:"+dao);
		//首先判断手机号码是否注册过
		Student stu=dao.queryByPhoneNum(student.getPhoneNum());
		
		if(stu!=null){
			throw new CustomerException("该手机号已被注册");
		}
		
		dao.insertStudent(student);

		return null;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	




}
