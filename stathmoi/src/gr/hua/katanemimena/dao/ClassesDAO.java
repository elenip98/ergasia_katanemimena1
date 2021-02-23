package gr.hua.katanemimena.dao;

import java.util.List;

import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.forms.ClassForm;



public interface ClassesDAO {

	public List<Classes> getClasses();
	
	public Classes getClassByID(int id);
		
	public Classes createClass(ClassForm classForm);
	
	public Classes updateClass(Classes myClass);
	
	public List<Classes> getClassesByTeacherID(int id);
	
	public List<Classes> getClassesByName(String name);
}

