package gr.hua.katanemimena.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.katanemimena.dao.ClassesDAO;
import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.dao.StathmoiDAO;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.forms.ClassForm;
import gr.hua.katanemimena.forms.StathmoiForm;

@Controller
public class ClassesController {

	@Autowired 
	ClassesDAO classesDAO;
	
	@Autowired 
	MyUsersDAO myUsersDAO;
	
	@Autowired 
	StathmoiDAO stathmoiDAO;
	
	
	@RequestMapping(value = "/admin/printclasses", method = RequestMethod.GET)
	public String printusers(Model model) {
		
		List<Classes> classes = classesDAO.getClasses();
		
		model.addAttribute("classes", classes);
		
		return "print_classes";
	}
	
	@RequestMapping(value = "/admin/findclasses", method = RequestMethod.GET)
	public String findclasses(Model model) {
		
		Classes myClass = new Classes();
		
		model.addAttribute("findclasses", myClass);
		
		return "findClasses";
	}
	
	
	@RequestMapping(value = "/admin/findclasses", method = RequestMethod.POST)
	public String findclasses(Model model, @ModelAttribute("findclasses") Classes myClass) {
		
		List<Classes> classes = classesDAO.getClassesByName(myClass.getName());
		
		model.addAttribute("classes", classes);
		
		return "print_classes";
	}
	
	@RequestMapping(value = "/admin/createclass", method = RequestMethod.GET)
	public String createuser(Map<String, Object> model) {
		
				ClassForm myForm = new ClassForm();
				model.put("createClass", myForm);
				
				List<MyUsers> teacherlist = myUsersDAO.getTeachers();
				model.put("teacherlist", teacherlist);

				
				List<Stathmoi> stathmoslist = stathmoiDAO.getStathmoi();
				model.put("stathmoslist", stathmoslist);
		
		
		
		return "create_class";
	}
	
	@RequestMapping(value = "/admin/createclass", method = RequestMethod.POST)
	public String createuser(Model model, @ModelAttribute("createClass") ClassForm classForm) {
		
		Classes myClass = classesDAO.createClass(classForm);
		
		model.addAttribute("myClass", myClass);
		
		return "print_class";
	}
	
}
