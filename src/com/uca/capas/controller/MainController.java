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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	
	@Autowired
	private AccountService accountServ;
	
	@RequestMapping(value="/")
	public ModelAndView initMain(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("user") != null && session.getAttribute("role")!=null && session.getAttribute("account_id")!=null ){
			
			
			if((Integer)session.getAttribute("role")==2) {
				mav.setViewName("redirect:/dashboard-client");
			}else {
				mav.setViewName("redirect:/function/list");
			}
		}else {
			mav.setViewName("login");
		}
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password, HttpServletRequest request, HttpServletResponse response, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		Account account = null;	
		if(accountServ.findOneUserActive(username, password)) {
			account=accountServ.findOneUserByUsernamePassword(username, password);
			if(account!=null) {
			account.setOnlinestatus(1);
			accountServ.save(account);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", account.getUsername());
			session.setAttribute("account_id", account.getIdaccount());
			session.setAttribute("role", account.getRole().getIdrole());
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			
			
			if(account.getRole().getIdrole()==2) {
				mav.setViewName("redirect:/dashboard-client");
			}else {
				mav.setViewName("redirect:/function/list");
			}
			} else {
				redirectAttributes.addFlashAttribute("error", 0);
				
				mav.setViewName("redirect:/");
			}
		}
		else {
			redirectAttributes.addFlashAttribute("error", 0);
			
			mav.setViewName("redirect:/");
		}
		
		return mav; 
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session,HttpServletRequest request) {
//		int account_id = (Integer)session.getAttribute("account_id");
//		Account account = accountServ.findOne(account_id);
//		account.setOnlinestatus(0);
//		accountServ.save(account);
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	
	
	
}
