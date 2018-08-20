package com.fcmmmmmm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcmmmmmm.config.MConfig;
import com.fcmmmmmm.dao.work.StudentJDBCTemplate;
import com.fcmmmmmm.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MConfig.class)
public class TestStudent {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Test
	public void test01()
	{
		StudentJDBCTemplate template=new StudentJDBCTemplate(jdbctemplate);
		Student student = new Student();
		student.setAge(15);
		student.setName("jdbc");
		template.creat(student);
	}
}
