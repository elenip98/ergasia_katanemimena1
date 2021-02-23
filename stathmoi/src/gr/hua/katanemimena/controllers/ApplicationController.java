package gr.hua.katanemimena.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.katanemimena.dao.ApplicationDAO;
import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.entity.Classes;

@Controller
public class ApplicationController {

	@Autowired 
	ApplicationDAO applicationDAO;
	
	
	@RequestMapping(value = "/admin/printapplications", method = RequestMethod.GET)
	public String printusers(Model model) {
		
		List<Application> applications = applicationDAO.getApplications();
		
		model.addAttribute("applications", applications);
		
		return "print_applications";
	}
	
	@RequestMapping(value = "/admin/findapplication", method = RequestMethod.GET)
	public String finduser(Model model) {
		
		Application application = applicationDAO.getApplicationByID(1);
		
		model.addAttribute("application", application);
		
		return "print_application";
	}
	
	
}


//applications application