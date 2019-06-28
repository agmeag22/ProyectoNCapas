package com.uca.capas.controller;


import java.util.Date;

import java.text.SimpleDateFormat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;	


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Film;
import com.uca.capas.domain.Transaction;
import com.uca.capas.repositories.FilmRepository;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.FilmService;
import com.uca.capas.service.TransactionService;
import com.uca.capas.service.UserService;
@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transService;
	
	@Autowired
	private AccountService accountService;
	
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    }
	 
	@RequestMapping("transaction/list")
		public ModelAndView vertodos(HttpSession session, 
				HttpServletRequest request, 

				@RequestParam(required = false) Integer page,@RequestParam(required = false)  String start, @RequestParam(required = false)  String end ) throws Exception{
				if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
					
//					System.out.println("Se va a retornar :S");
					return new ModelAndView("redirect:/");
				}

			ModelAndView mav = new ModelAndView();
			int pagina=0;
			System.out.println("La pagina es:"+page);
			if(page!=null) {pagina = page;}
			
			List<Transaction> films = null;
			long count=0;
			Account account = accountService.findOne((int)session.getAttribute("account_id"));
			if(start!=null && end!=null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date start_d = sdf.parse(start);
				System.out.println(start+":"+start_d.toString());
				Date end_d = sdf.parse(end);
				System.out.println(end+":"+end_d.toString());
				films = transService.findAll(start_d,end_d,pagina,account);
				mav.addObject("end", end_d);
				mav.addObject("start", start_d);
				count=transService.countAll(start_d,end_d,pagina,account);
				
				
			}else {
				films = transService.findAll(pagina,account);
				count=transService.countAll();
			}
			
			//System.out.println("El tamañò es:"+films.size());
			//films=(List<Film>) filmRepo.findAll();
			//Como Page no es una coleccion en si, utilizo el metodo getContent() el cual me devuelve la coleccion (de clientes) que representa la pagina
			mav.addObject("films", films);
			
			mav.addObject("actual", Math.min((pagina + 1) * 10,count));
			mav.addObject("total", count);
			
			mav.addObject("pagina", pagina + 1);
			mav.setViewName("client/transactions_all");
			return mav;
		}
	

}


