package com.nsu.CloudCompute.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nsu.CloudCompute.pojo.Student;

public class CloudComputeDao implements CloudComputeMapper{
    private SqlSessionFactory sqlSessionFactory;

	@Override
	public Student queryByPhoneNum(String phoneNum){
		System.out.println("开始进行查询了，根据手机号码");
		SqlSession session=sqlSessionFactory.openSession();
		CloudComputeMapper cloudComputeDao=session.getMapper(CloudComputeMapper.class);
		Student student=cloudComputeDao.queryByPhoneNum(phoneNum);
		session.close();
		return student;
	}

	@Override
	public void insertStudent(Student student) {
		System.out.println("插入学生");
		SqlSession session=sqlSessionFactory.openSession();
		CloudComputeMapper cloudComputeDao=session.getMapper(CloudComputeMapper.class);
		cloudComputeDao.insertStudent(student);
		session.close();
	}
	
	
    //设置SqlSessionFactory
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	


}
