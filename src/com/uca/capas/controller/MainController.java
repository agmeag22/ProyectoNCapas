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
import com.uca.capas.domain.Municipio;
import com.uca.capas.domain.Paises;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.UserService;
import com.uca.capas.service.MunicipioService;
import com.uca.capas.service.PaisService;
import com.uca.capas.service.RoleService;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	
	@Autowired
	private AccountService accountServ;
	@Autowired
	private MunicipioService municipioServ;
	@Autowired
	private RoleService roleServ;
	
	@Autowired
	private PaisService paiseServ;
	@Autowired
	private UserService userServ;
	
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
	
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mav =new ModelAndView();
		List<Municipio> municipalities=municipioServ.findAll();
		List<Paises> paises=paiseServ.findAll();
		mav.addObject("municipalities", municipalities);
		mav.addObject("countries", paises);
		mav.setViewName("client/register");
		return mav;
	}
	
	@RequestMapping("client/store")
	public ModelAndView storeclient(@RequestParam("uname") String uname, @RequestParam("ulastname") String ulastname, @RequestParam("ucountry") String ucountry,@RequestParam("umunicipality") String umunicipality, @RequestParam("uaddress") String uaddress, @RequestParam("ubirthdate") String ubirthdate, @RequestParam("username") String username, @RequestParam("password") String password){
		ModelAndView mav=new ModelAndView();
		Account account = new Account();
		User user = new User(); 
		user.setUname(uname);
		user.setUlastname(ulastname);
		user.setUcountry(ucountry);
		user.setUadress(uaddress);
		user.setUbirthdate(ubirthdate);
		user.setUmunicipality(umunicipality);
		User userSaved=userServ.savedUser(user);
		account.setUsername(username);
		account.setPassword(password);
		account.setActivestate(0);
		account.setOnlinestatus(0);
		account.setComment("");;
		account.setCredit(20);
		account.setRole(roleServ.findOne(2));
		account.setUser(userSaved);
		accountServ.save(account);
		mav.setViewName("redirect:/");
		return mav;
		
}
	
	
	
	
}
