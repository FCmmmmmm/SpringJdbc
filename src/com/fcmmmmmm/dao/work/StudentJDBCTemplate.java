package com.fcmmmmmm.dao.work;


import java.math.BigInteger;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fcmmmmmm.dao.StudentDao;
import com.fcmmmmmm.entity.Student;
import com.fcmmmmmm.mapper.StudentMapper;

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
		String sql="select * from Student where id=?";
		return jdbcTemplate.queryForObject(sql, new StudentMapper(),id);
	}

	@Override
	public Student deletById(int id) {
		String sql="delete * from Student where id=?";
		return jdbcTemplate.queryForObject(sql, new StudentMapper(),id);
	}

	@Override
	public int updateById(Student student) {
		String sql="update student SET `name`=? ,age=? WHERE id=?";
		return jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getId());
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

	@Override
	public List<Student> queryAll() {
		String sql="select * from Student";
		return jdbcTemplate.query(sql,(rs,rowNum)->{
			Student student = new Student();
			student.setId((BigInteger.valueOf((long) rs.getDouble("id"))));
			student.setName(rs.getString("name"));
			student.setAge(rs.getInt("age"));
			return student;
		});
	}

}
