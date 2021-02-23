package gr.hua.katanemimena.dao;

import java.util.List;

import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.forms.ApplicationForm;

public interface ApplicationDAO {

	public List<Application> getApplications();
	
	public Application getApplicationByID(int id);
		
	public Application createApplication(Application application);
	
	public List<Application> getApplicationByStatus(String status);
	
	public Application updateApplication(Application application);
}
