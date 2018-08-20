package com.fcmmmmmm.dao.work;


import org.springframework.jdbc.core.JdbcTemplate;

import com.fcmmmmmm.dao.StudentDao;
import com.fcmmmmmm.entity.Student;

/*@ComponentScan(basePackages="com.fcmmmmmm")*/
/*@ContextConfiguration(classes=MConfig.class)*/
/*上下文*/
public class StudentJDBCTemplate implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public StudentJDBCTemplate() {
		super();
	}

	public StudentJDBCTemplate(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Student queryById(int id) {
		
		return null;
	}

	@Override
	public Student deletById(int id) {
		
		return null;
	}

	@Override
	public Student updateById(int id) {
		
		return null;
	}

	@Override
	public void creat(Student student) {
		 String SQL = "insert into Student (name, age) values (?, ?)";
		 String SQL2 = "insert into Student (id,name, age) values (?,?,?)";
		 if(student.getId()==null) {
			 jdbcTemplate.update(SQL,student.getName(),student.getAge());
		 }else {
			 jdbcTemplate.update(SQL2,student.getId(),student.getName(),student.getAge());
		}
		System.out.println("creat success");		 
	}

}
