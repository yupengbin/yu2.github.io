package com.nsu.CloudCompute.service;

import com.nsu.CloudCompute.exception.CustomerException;
import com.nsu.CloudCompute.pojo.Student;

public interface CloudComputeService {
    public boolean login(String phoneNum,String password) throws CustomerException;
    public String register(Student student) throws CustomerException;
    public void test();
}
