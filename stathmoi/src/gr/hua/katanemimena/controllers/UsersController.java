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

import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.entity.MyUsers;

@Controller
public class UsersController {

	@Autowired 
	MyUsersDAO myUsersDAO;
	
	@RequestMapping(value = "/admin/printusers", method = RequestMethod.GET)
	public String printusers(Model model) {
		
		List<MyUsers> myusers = myUsersDAO.getMyUsers();
		
		model.addAttribute("myusers", myusers);
		
		return "print_users";
	}
	
	@RequestMapping(value = "/admin/finduser", method = RequestMethod.GET)
	public String finduser(Model model) {
		
		MyUsers myuser = new MyUsers();
		
		model.addAttribute("finduser", myuser);
		
		return "find_user";
	}
	
	@RequestMapping(value = "/admin/finduser", method = RequestMethod.POST)
	public String finduser(Model model, @ModelAttribute("finduser") MyUsers myUser) {
		
		List<MyUsers> myusers = myUsersDAO.getMyUsersByUsername(myUser.getUsername());
		
		model.addAttribute("myusers", myusers);
		
		return "print_users";
	}
	
	@RequestMapping(value = "/admin/createuser", method = RequestMethod.GET)
	public String createuser(Map<String, Object> model) {
		
				MyUsers myUser = new MyUsers();
				model.put("createUser", myUser);
		
				List<String> roleList = new ArrayList<>();
				roleList.add("ROLE_ADMIN");
				roleList.add("ROLE_DIAX");
				roleList.add("ROLE_DIEF");
				roleList.add("ROLE_TEACHER");
				roleList.add("ROLE_DIM");

				model.put("roleList", roleList);

				List<Integer> enabledList = new ArrayList<>();
				enabledList.add(1);
				enabledList.add(0);
				model.put("enabledList", enabledList);
		
		
		
		return "create_user";
	}
	
	@RequestMapping(value = "/admin/createuser", method = RequestMethod.POST)
	public String createuser(Model model, @ModelAttribute("createUser") MyUsers myUser) {
		
		int i = myUsersDAO.createMyUser(myUser);
		
		model.addAttribute("myuser", myUser);
		
		return "print_user";
	}
	
	
}
