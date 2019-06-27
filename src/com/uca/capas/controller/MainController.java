package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.User;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.UserService;

import java.util.logging.Logger;

@Controller
public class MainController {
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	public static Account acc = null;
	
	@Autowired
	private AccountService accountServ;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		Object accId = accountServ.findOneUser(username, password);
		
		if(accId != null) {
			acc = this.accountServ.findOne((Integer) accId);
			mav.setViewName("redirect:/dashboard-client");
		} else {
			redirectAttributes.addFlashAttribute("error", 0);
			mav.setViewName("redirect:/login");
		}
		
		return mav; 
	}
	
	
	
}
