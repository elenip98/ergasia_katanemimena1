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
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.katanemimena.dao.MyUsersDAO;
import gr.hua.katanemimena.dao.StathmoiDAO;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.forms.StathmoiForm;

@Controller
public class StathmoiController {

	@Autowired 
	StathmoiDAO stathmoiDAO;
	
	@Autowired 
	MyUsersDAO myUsersDAO;
	
	@RequestMapping(value = "/admin/printstathmoi", method = RequestMethod.GET)
	public String printusers(Model model) {
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoi();
		
		model.addAttribute("stathmoi", stathmoi);
		
		return "print_stathmoi";
	}
	
	@RequestMapping(value = "/admin/findstathmoi", method = RequestMethod.GET)
	public String findstathmoi(Model model) {
		
		Stathmoi stathmos = new Stathmoi();
		
		model.addAttribute("findstathmoi", stathmos);
		
		return "find_stathmoi";
	}
	
	
	@RequestMapping(value = "/admin/findstathmoi", method = RequestMethod.POST)
	public String finduser(Model model, @ModelAttribute("findstathmoi") Stathmoi stathmos) {
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoiByName(stathmos.getName());
		
		model.addAttribute("stathmoi", stathmoi);
		
		return "print_stathmoi";
	}
	
	@RequestMapping(value = "/admin/createstathmos", method = RequestMethod.GET)
	public String createuser(Map<String, Object> model) {
		
				StathmoiForm stathmosForm = new StathmoiForm();
				model.put("createstathmos", stathmosForm);
	
				
				List<MyUsers> dieflist = myUsersDAO.getDiefthides();
				model.put("dieflist", dieflist);

				List<Integer> enabledList = new ArrayList<>();
				enabledList.add(1);
				enabledList.add(0);
				model.put("enabledList", enabledList);
		
		return "create_stathmoi";
	}

	@RequestMapping(value = "/admin/createstathmos", method = RequestMethod.POST)
	public String createuser(Model model, @ModelAttribute("createstathmos") StathmoiForm stathmosForm) {
		
		Stathmoi stathmos = stathmoiDAO.createStathmo(stathmosForm);
		
		model.addAttribute("stathmos", stathmos);
		
		return "print_stathmos";
	}
	

	@RequestMapping(value = "/diax/stathmoilist", method = RequestMethod.GET)
	public String printstathmoi(Map<String, Object> model) {
		
		Stathmoi stathmos = new Stathmoi();
		model.put("addremovestathmo", stathmos);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoi();
		
		model.put("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	
	}
	

	@RequestMapping(value = "/diax/stathmoilist", method = RequestMethod.POST, params = "RemoveButton")
	public String printstathmoipost(Map<String, Object> model, @ModelAttribute("addremovestathmo") Stathmoi stathmos, @RequestParam String RemoveButton) {
		
		Boolean temp = false;
		
		stathmos = stathmoiDAO.changeEnabled(Integer.parseInt(RemoveButton), temp);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoi();
		
		model.put("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	}
	
	@RequestMapping(value = "/diax/stathmoilist", method = RequestMethod.POST, params = "AddButton")
	public String printstathmoipostadd(Map<String, Object> model, @ModelAttribute("addremovestathmo") Stathmoi stathmos, @RequestParam String AddButton) {
		
		Boolean temp = true;
		
		stathmos = stathmoiDAO.changeEnabled(Integer.parseInt(AddButton), temp);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoi();
		
		model.put("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	}
	
	@RequestMapping(value = "/diax/addstathmo", method = RequestMethod.GET)
	public String addstathmo(Map<String, Object> model) {
		
		Stathmoi stathmos = new Stathmoi();
		model.put("addremovestathmo", stathmos);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getEnabledStathmoi(false);
		
		model.put("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	
	}
	
	@RequestMapping(value = "/diax/removestathmo", method = RequestMethod.GET)
	public String removestathmo(Map<String, Object> model) {
		
		Stathmoi stathmos = new Stathmoi();
		model.put("addremovestathmo", stathmos);
		
		List<Stathmoi> stathmoi = stathmoiDAO.getEnabledStathmoi(true);
		
		model.put("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	
	}
	
	@RequestMapping(value = "/diax/createstathmos", method = RequestMethod.GET)
	public String createstathmo(Map<String, Object> model) {
		
				StathmoiForm stathmosForm = new StathmoiForm();
				model.put("createstathmos", stathmosForm);
	
				
				List<MyUsers> dieflist = myUsersDAO.getDiefthides();
				model.put("dieflist", dieflist);

				List<Integer> enabledList = new ArrayList<>();
				enabledList.add(1);
				enabledList.add(0);
				model.put("enabledList", enabledList);
		
		return "create_stathmoi";
	}

	@RequestMapping(value = "/diax/createstathmos", method = RequestMethod.POST)
	public String createstathmopost(Model model, @ModelAttribute("createstathmos") StathmoiForm stathmosForm) {
		
		Stathmoi stathmos = stathmoiDAO.createStathmo(stathmosForm);
		
		model.addAttribute("stathmos", stathmos);
		
		return "print_stathmos";
	}
	
	@RequestMapping(value = "/diax/findstathmo", method = RequestMethod.GET)
	public String findstathmo(Model model) {
		
		Stathmoi stathmos = new Stathmoi();
		
		model.addAttribute("findstathmo", stathmos);
		
		return "find_stathmo";
	}
	

	@RequestMapping(value = "/diax/findstathmo", method = RequestMethod.POST)
	public String findstathmopost(Model model, @ModelAttribute("findstathmo") Stathmoi stathmos) {
		
		List<Stathmoi> stathmoi = stathmoiDAO.getStathmoiByName(stathmos.getName());
		
		model.addAttribute("stathmoi", stathmoi);
		
		return "diax_print_stathmoi";
	}
	
	
}
