package gr.hua.katanemimena.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.katanemimena.dao.ClassesDAO;
import gr.hua.katanemimena.dao.StudentsDAO;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.entity.Students;
import gr.hua.katanemimena.forms.ClassForm;
import gr.hua.katanemimena.forms.StudentForm;

@Controller
public class StudentsController {

	@Autowired
	StudentsDAO studentsDAO;
	
	@Autowired
	ClassesDAO classesDAO;
	
	@RequestMapping(value = "/admin/printstudents", method = RequestMethod.GET)
	public String printusers(Model model) {
		
		List<Students> students = studentsDAO.getStudents();
		
		model.addAttribute("students", students);
		
		return "print_students";
	}
	
	@RequestMapping(value = "/admin/findstudent", method = RequestMethod.GET)
	public String finduser(Model model) {
		
		Students student = new Students();
		
		model.addAttribute("findstudent", student);
		
		return "find_students";
	}	
	
	@RequestMapping(value = "/admin/findstudent", method = RequestMethod.POST)
public String findclasses(Model model, @ModelAttribute("findstudent") Students student) {
		
		List<Students> students = studentsDAO.getStudentsByName(student.getFirstname());
		
		model.addAttribute("students", students);
		
		return "print_students";
	}
	
	@RequestMapping(value = "/admin/createstudent", method = RequestMethod.GET)
	public String createuser(Map<String, Object> model) {
		
				StudentForm myForm = new StudentForm();
				model.put("createStudent", myForm);
								
				List<Classes> classlist = classesDAO.getClasses();
				model.put("classlist", classlist);
		
		
		
		return "create_student";
	}
	
	@RequestMapping(value = "/admin/createstudent", method = RequestMethod.POST)
	public String createuser(Model model, @ModelAttribute("createStudent") StudentForm studentForm) {
		
		Students student = studentsDAO.createStudent(studentForm);
		
		model.addAttribute("student", student);
		
		return "print_student";
	}
	
}
