package gr.hua.katanemimena.forms;

import javax.validation.Valid;

import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Students;

public class TeacherClassForm {

	@Valid
	private Classes myClass;
	
	@Valid
	private MyUsers teacher;
	
	@Valid 
	private Students student;
	
	public TeacherClassForm() {}
	
	public TeacherClassForm(Classes myClass, MyUsers teacher, Students student) {
		super();
		this.myClass = myClass;
		this.teacher = teacher;
		this.student = student;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Classes getMyClass() {
		return myClass;
	}

	public void setMyClass(Classes myClass) {
		this.myClass = myClass;
	}

	public MyUsers getTeacher() {
		return teacher;
	}

	public void setTeacher(MyUsers teacher) {
		this.teacher = teacher;
	}
	
	
}
