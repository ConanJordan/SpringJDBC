/**
 * 以下是数据访问对象接口文件 StudentDAO.java 的内容
 */

package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDao {
	
	public void setDataSource(DataSource ds);
	
	public void create(String name, Integer age); 
	
	public Student getStudent(Integer id);
	
	public List<Student> listStudents();
	
	public void delete(Integer id);
	
	public void update(Integer id, Integer age);
	
}
