package com.fcmmmmmm.dao;

import com.fcmmmmmm.entity.Student;

public interface StudentDao {
	public Student queryById(int id);
	public Student deletById(int id);
	public Student updateById(int id);
	public void creat(Student student);
}
