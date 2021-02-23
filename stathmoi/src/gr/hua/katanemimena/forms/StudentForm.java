package gr.hua.katanemimena.forms;

import javax.persistence.Column;
import javax.validation.Valid;

import gr.hua.katanemimena.entity.Students;

public class StudentForm {

	@Valid
	private Students student;
	
	@Column
	private int classID;

	public StudentForm() {}
	
	public StudentForm(Students student, int classID) {
		super();
		this.student = student;
		this.classID = classID;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	
	
}
