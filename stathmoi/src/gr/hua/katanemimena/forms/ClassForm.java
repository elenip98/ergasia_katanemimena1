package gr.hua.katanemimena.forms;

import javax.persistence.Column;
import javax.validation.Valid;

import gr.hua.katanemimena.entity.Classes;

public class ClassForm {

	@Valid
	private Classes myClass;
	
	@Column
	private int stathmosID;
	
	@Column
	private int teacherID;

	public ClassForm() {}
	
	public ClassForm(Classes myClass, int stathmosID, int teacherID) {
		super();
		this.myClass = myClass;
		this.stathmosID = stathmosID;
		this.teacherID = teacherID;
	}

	public Classes getMyClass() {
		return myClass;
	}

	public void setMyClass(Classes myClass) {
		this.myClass = myClass;
	}

	public int getStathmosID() {
		return stathmosID;
	}

	public void setStathmosID(int stathmosID) {
		this.stathmosID = stathmosID;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	
	
	
	
	
	
}
