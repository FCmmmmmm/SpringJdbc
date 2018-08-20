package com.fcmmmmmm.mapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fcmmmmmm.entity.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
		Student student = new Student();
		student.setId((BigInteger.valueOf((long) arg0.getDouble("id"))));
		student.setName(arg0.getString("name"));
		student.setAge(arg0.getInt("age"));
		return student;
	}

}
