package com.nsu.CloudCompute.dao;

import com.nsu.CloudCompute.pojo.Student;

public interface CloudComputeMapper {
	public Student queryByPhoneNum(String phoneNum);
	public void insertStudent(Student student) ;
}
