package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.User;

import com.uca.capas.repositories.UserRepository;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.data.domain.Sort;
@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	

	
	

	@Autowired
	private UserService userServ;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
		ModelAndView mav = new ModelAndView();
		if(userServ.findOneUser(username, password)) {
			log.info("Entrando a funcion init-min" + log.getName());
			mav.setViewName("main");
		}else {
			mav.setViewName("login");
		}
			log.info("No se pudo realizar" + log.getName() +"u:::::::"+ username+ "p::::::"+password);
		return mav; 
	}
	
	@RequestMapping("/register")
	public String redirect(@RequestParam("uname") String uname, @RequestParam("ulastname") String ulastname, @RequestParam("ucountry") String ucountry, @RequestParam("uaddress") String uaddress, @RequestParam("ubirthdate") String ubirthdate, @RequestParam("username") String username, @RequestParam("password") String password){
		Account account = new Account();
		User user = new User(); 
		
		user.setU_name(uname);
		user.setU_lastname(ulastname);
		user.setU_country(ucountry);
		user.setU_adress(uaddress);
		user.setU_birthdate(ubirthdate);
		account.setUsername(username);
		account.setPassword(password);
		
		UserService.save(user);
		AccountService.save(account); 
		
		return "redirect:/film/view";
		
	}

	
}
