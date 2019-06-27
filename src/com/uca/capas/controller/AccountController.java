package com.uca.capas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Film;
import com.uca.capas.domain.User;
import com.uca.capas.repositories.FilmRepository;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.FilmService;
import com.uca.capas.service.UserService;
@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("account/list")
		public ModelAndView vertodos(HttpSession session, 
				HttpServletRequest request, 
				@RequestParam(required = false) Integer direccion) throws Exception{
			ModelAndView mav = new ModelAndView();
			int pagina=0;
			
			List<Account> accounts = null;
			
			accounts = accountService.findAll(pagina);
			System.out.println("El tamañò es:"+accounts.size());
			mav.addObject("accounts", accounts);
			mav.addObject("actual", (pagina + 1) * 10);
			mav.addObject("total", accountService.countAll());
			mav.addObject("pagina", pagina + 1);
			mav.setViewName("account/view_all");
			return mav;
		}
	
	
	@RequestMapping(value="account/store",method=RequestMethod.POST)
	public String store(@ModelAttribute(name="account") Account account ,HttpServletRequest request) throws Exception{
		accountService.save(account);
		return "redirect:/account/list";	
	}
	

	
	@RequestMapping(value="account/view/{id}")
	public ModelAndView view(@PathVariable(value="id") int id ,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Account account=accountService.findOne(id);
		if(account!=null) {
			mav.addObject("account", account);
			System.out.println("El tamañò es:"+account.getUser().getUadress());
			mav.setViewName("account/view");
			}
			else {
				return new ModelAndView("redirect:/account/list");
			}
		return mav;	
	}
}

