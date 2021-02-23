package gr.hua.katanemimena.forms;

import javax.validation.Valid;

import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.entity.Students;

public class ApplicationForm {
	
	@Valid 
	Students student;
	
	@Valid
	Application application;
	
	public ApplicationForm() {}
	
	public ApplicationForm(Students student, Application application) {
		super();
		this.student = student;
		this.application = application;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	
	

}
