package gr.hua.katanemimena.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.katanemimena.dao.ClassesDAO;
import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.dao.StudentsDAO;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.entity.Students;

@Controller
public class TeacherService {

	@Autowired 
	ClassesDAO classesDAO;
	
	@Autowired 
	MyUsersDAO myUsersDAO;
	
	@Autowired 
	StudentsDAO studentsDAO;
	
	@RequestMapping(value = "/teacher/viewclasses", method = RequestMethod.GET)
	public String viewclasses(Model model) {
		
		Classes myForm = new Classes();
		model.addAttribute("viewclasses", myForm);
		
		//get user id
		
		List<Classes> classes = classesDAO.getClassesByTeacherID(5);
		
		model.addAttribute("classes", classes);
		
		return "teach_print_classes";
	}
	
	@RequestMapping(value = "/teacher/viewclasses", method = RequestMethod.POST,  params = "ClassButton")
	public String viewclasses(Map<String, Object> model, @ModelAttribute("viewclasses") Classes myClass, @RequestParam String ClassButton) {
	
		myClass.setId(Integer.parseInt(ClassButton));
		
		List<Students> students = studentsDAO.getStudentsByClassID(1);
		
		model.put("students", students);
		
		return "teach_print_students";
	}
	
	
	
	
	
	
	
	
	
	//viewclasses
	///teacher/printclasses
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
