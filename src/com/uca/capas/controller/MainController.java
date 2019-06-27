package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	@Autowired
	private AccountService accountServ;
	
	@RequestMapping(value="/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		Account account = null;	
		if(accountServ.findOneUser(username, password)) {
			account=accountServ.findOneUserByUsernamePassword(username, password);
			account.setOnlinestatus(1);
			accountServ.save(account);
			if(account.getRole().getIdrole()==1) {
				mav.setViewName("redirect:/dashboard-client");
			}else {
				mav.setViewName("redirect:/function/list");
			}
		} else {
			redirectAttributes.addFlashAttribute("error", 0);
			
			mav.setViewName("redirect:/login");
		}
		
		return mav; 
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(@ModelAttribute(name="account")Account account) {
		account.setOnlinestatus(0);
		accountServ.save(account);
		return new ModelAndView("redirect:/login");
	}
	
}
