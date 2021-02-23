package gr.hua.katanemimena.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.katanemimena.dao.ApplicationDAO;
import gr.hua.katanemimena.dao.ClassesDAO;
import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.dao.StathmoiDAO;
import gr.hua.katanemimena.dao.StudentsDAO;
import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.entity.Students;
import gr.hua.katanemimena.forms.TeacherClassForm;

@Controller
public class DiefthidisService {

	@Autowired 
	StathmoiDAO stathmoiDAO;

	@Autowired 
	ApplicationDAO applicationDAO;
	
	@Autowired 
	ClassesDAO classesDAO;
	
	@Autowired 
	MyUsersDAO myUsersDAO;
	
	@Autowired 
	StudentsDAO studentsDAO;
	
	@RequestMapping(value = "/dief/updatestathmo", method = RequestMethod.GET)
	public String editstathmo(Model model) {
		
		Stathmoi newStathmos = new Stathmoi();
		model.addAttribute("updatestathmo", newStathmos);
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		
		List<MyUsers> list = myUsersDAO.getMyUsersByUsername(username);
		MyUsers diefthidis = list.get(0);
		
		Stathmoi stathmos = stathmoiDAO.getStathmoByDiaxID(diefthidis.getId());
		
		List<Application> mylist = new ArrayList<Application>();
		stathmos.setApplications(mylist);
		
		model.addAttribute("stathmos", stathmos);
		
		return "dief_epikeropiisi";
	}
	
	@RequestMapping(value = "/dief/updatestathmo", method = RequestMethod.POST)
	public String editstathmopost(Map<String, Object> model, @ModelAttribute("updatestathmo") Stathmoi stathmos, @RequestParam String UpdateStathmoButton) {
	
		stathmos.setId(Integer.parseInt(UpdateStathmoButton));
		
		Stathmoi tempstathmos = stathmoiDAO.getStathmoByDiaxID(Integer.parseInt(UpdateStathmoButton));
		
		stathmos.setEnabled(tempstathmos.isEnabled());
		stathmos.setDiefthidisID(tempstathmos.getDiefthidisID());
		
		stathmos = stathmoiDAO.updateStathmo(stathmos);
		
		model.put("stathmos", stathmos);
		
		return "print_stathmos";
	}
	
	@RequestMapping(value = "/dief/printallapp", method = RequestMethod.GET)
	public String printallapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplications();
		
		model.addAttribute("applications", applications);
		
		return "deif_print_apps";
	}
	
	@RequestMapping(value = "/dief/printprossapp", method = RequestMethod.GET)
	public String printprossapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Submitted");
		
		model.addAttribute("applications", applications);
		
		return "deif_print_apps";
	}
	
	@RequestMapping(value = "/dief/printaccapp", method = RequestMethod.GET)
	public String printaccapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Accepted");
		
		model.addAttribute("applications", applications);
		
		return "deif_print_apps";
	}
	
	@RequestMapping(value = "/dief/printrejapp", method = RequestMethod.GET)
	public String printrejapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Rejected");
		
		model.addAttribute("applications", applications);
		
		return "deif_print_apps";
	}
	
	@RequestMapping(value = "/dief/printallapp", method = RequestMethod.POST,  params = "AcceptButton")
	public String printstathmoipost(Map<String, Object> model, @ModelAttribute("rjapp") Application application, @RequestParam String AcceptButton) {
		
		application = applicationDAO.getApplicationByID(Integer.parseInt(AcceptButton));
		
		application.setStatus("Accepted");
		
		application = applicationDAO.updateApplication(application);
		
		model.put("application", application);
		
		return "print_application";
	}
	
	@RequestMapping(value = "/dief/printallapp", method = RequestMethod.POST,  params = "RejectButton")
	public String printstathmoipost2(Map<String, Object> model, @ModelAttribute("rjapp") Application application, @RequestParam String RejectButton) {
		
		application = applicationDAO.getApplicationByID(Integer.parseInt(RejectButton));
		
		application.setStatus("Rejected");
		
		application = applicationDAO.updateApplication(application);
		
		model.put("application", application);
		
		return "print_application";
	}

	@RequestMapping(value = "/dief/setclassteacher", method = RequestMethod.GET)
	public String setclassteacher(Model model) {
		
		TeacherClassForm myForm = new TeacherClassForm();
		model.addAttribute("setteacherclass", myForm);
		
		
		List<Classes> classlist = classesDAO.getClasses();
		
		model.addAttribute("classlist", classlist);
		
		List<MyUsers> teacherlist = myUsersDAO.getTeachers();

		model.addAttribute("teacherlist", teacherlist);
		
		return "set_teachclass";
	}

	@RequestMapping(value = "/dief/setclassteacher", method = RequestMethod.POST)
	public String setclassteacher(Model model, @ModelAttribute("setclassteacher") TeacherClassForm myForm) {
		
		Classes myClass = classesDAO.getClassByID(myForm.getMyClass().getId());
				
		MyUsers teacher = myUsersDAO.getMyUserByID(myForm.getTeacher().getId());
		
		myClass.setTeacherID(teacher);
		
		myClass = classesDAO.updateClass(myClass);
		
		model.addAttribute("myClass", myClass);
		
		return "print_class";
	}
	

	@RequestMapping(value = "/dief/setstudents", method = RequestMethod.GET)
	public String setstudents(Model model) {
		
		TeacherClassForm myForm = new TeacherClassForm();
		model.addAttribute("setstudents", myForm);
		
		
		List<Classes> classlist = classesDAO.getClasses();
		
		model.addAttribute("classlist", classlist);
		
		List<Students> studentlist = studentsDAO.getStudents();

		model.addAttribute("studentlist", studentlist);
		
		return "set_students";
	}
	

	@RequestMapping(value = "/dief/setstudents", method = RequestMethod.POST)
	public String setstudents(Model model, @ModelAttribute("setclassteacher") TeacherClassForm myForm) {
		
		Classes myClass = classesDAO.getClassByID(myForm.getMyClass().getId());
				
		Students student = studentsDAO.getStudentByID(myForm.getStudent().getId());
		
		student.setClassID(myClass);
		
		student = studentsDAO.updateStudent(student);
		
		model.addAttribute("student", student);
		
		return "print_student";
	}
	
	
}
