/**
 * 下面是为定义的 DAO 接口 StudentDAO 的实现类文件 StudentJDBCTemplate.java
 */

package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		this.jdbcTemplateObject.update(SQL, name, age);
	}

	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
		Student student = this.jdbcTemplateObject.queryForObject(
				SQL, new Object[]{id}, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = this.jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id =?";
		this.jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		this.jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id );
	}

}
