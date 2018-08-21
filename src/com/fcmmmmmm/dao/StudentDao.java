package com.fcmmmmmm.dao;

import java.util.List;

import com.fcmmmmmm.entity.Student;

public interface StudentDao {
	public Student queryById(int id);
	public Student deletById(int id);
	public int updateById(Student student);
	public void creat(Student student);
	public List<Student> queryAll();
}
