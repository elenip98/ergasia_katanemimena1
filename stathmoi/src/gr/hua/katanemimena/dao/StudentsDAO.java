package gr.hua.katanemimena.dao;

import java.util.List;

import gr.hua.katanemimena.entity.Students;
import gr.hua.katanemimena.forms.StudentForm;

public interface StudentsDAO {

	public List<Students> getStudents();
	
	public Students getStudentByID(int id);

	public Students createStudent(StudentForm studentForm);
	
	public Students createStudent(Students student);
	
	public Students updateStudent(Students student);
	
	public List<Students> getStudentsByClassID(int id);
	
	public List<Students> getStudentsByName(String name);
	
}
