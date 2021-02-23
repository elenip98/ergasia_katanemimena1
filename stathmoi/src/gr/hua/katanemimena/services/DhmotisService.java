package gr.hua.katanemimena.services;

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
import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.dao.StathmoiDAO;
import gr.hua.katanemimena.dao.StudentsDAO;
import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.entity.Students;
import gr.hua.katanemimena.forms.ApplicationForm;

@Controller
public class DhmotisService {
	
	@Autowired 
	MyUsersDAO myUsersDAO;

	@Autowired 
	StudentsDAO studentsDAO;
	
	@Autowired 
	ApplicationDAO applicationDAO;

	@Autowired 
	StathmoiDAO stathmoiDAO;
	
	
	@RequestMapping(value = "/dhmotis/getstathmoi", method = RequestMethod.GET)
	public String editstathmo(Model model) {
		
		Stathmoi newStathmos = new Stathmoi();
		model.addAttribute("getstathmoi", newStathmos);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getEnabledStathmoi(true);
		
		model.addAttribute("stathmoi", stathmoi);
		
		return "get_stathmoi";
	}
	
	
	@RequestMapping(value = "/dhmotis/getstathmoi", method = RequestMethod.POST,  params = "ApplyButton")
	public String editstathmo(Map<String, Object> model, @ModelAttribute("getstathmoi") Stathmoi stathmos, @RequestParam String ApplyButton) {
		

		model.put("stathmos", stathmos);
		
		ApplicationForm myForm = new ApplicationForm();
		model.put("createapp", myForm);
		
		return "new_app";
	}
	
	
	
	@RequestMapping(value = "/dhmotis/createapp", method = RequestMethod.POST,  params = "ApplyButtonSec")
	public String createapp(Map<String, Object> model, @ModelAttribute("createapp") ApplicationForm myForm, @RequestParam String ApplyButtonSec) {
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		
		List<MyUsers> list = myUsersDAO.getMyUsersByUsername(username);
		MyUsers dhmostis = list.get(0);
		
		Students student = myForm.getStudent();
		Application app = myForm.getApplication();
		app.setStudentID(student);
		app.setDhmotisID(dhmostis);
		app.setStatus("Submitted");
		
		student = studentsDAO.createStudent(student);
		
		app = applicationDAO.createApplication(app);

		model.put("application", app);
		model.put("student", student);
		
		
		return "print_new_app";
	}
	
	@RequestMapping(value = "/dhmotis/printallapp", method = RequestMethod.GET)
	public String printallapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplications();
		
		model.addAttribute("applications", applications);
		
		return "dim_print_apps";
	}
	
	@RequestMapping(value = "/dhmotis/printprossapp", method = RequestMethod.GET)
	public String printprossapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Submitted");
		
		model.addAttribute("applications", applications);
		
		return "dim_print_apps";
	}
	
	@RequestMapping(value = "/dhmotis/printaccapp", method = RequestMethod.GET)
	public String printaccapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Accepted");
		
		model.addAttribute("applications", applications);
		
		return "dim_print_apps";
	}
	
	@RequestMapping(value = "/dhmotis/printrejapp", method = RequestMethod.GET)
	public String printrejapp(Model model) {
		
		Application application = new Application();
		model.addAttribute("rjapp", application);
		
		
		List<Application> applications = applicationDAO.getApplicationByStatus("Rejected");
		
		model.addAttribute("applications", applications);
		
		return "dim_print_apps";
	}
	
	
	
	
	
}
