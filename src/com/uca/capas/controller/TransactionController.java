package com.uca.capas.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
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
	
	
	@RequestMapping("transaction/list")
		public ModelAndView vertodos(HttpSession session, 
				HttpServletRequest request, 
				@RequestParam(required = false) Integer page,@RequestParam(required = false)  @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @RequestParam(required = false)  @DateTimeFormat(pattern="yyyy-MM-dd") Date end ) throws Exception{
				if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
					System.out.println("Se va a retornar :S");
					return new ModelAndView("redirect:/");
				}
			ModelAndView mav = new ModelAndView();
			int pagina=0;
			System.out.println("La pagina es:"+page);
			if(page!=null) {pagina = page;}
			
//			String referer = request.getHeader("referer"); //Referer me dice de que URL vengo (quien la llama)
//			
//			if(referer.contains("index")) { //Si vengo de index
//				pagina = 0; //Si es primera vez que entro, inicializo en pagina 0
//				session.setAttribute("pagina", pagina); //Seteo como objeto de sesion el valor de la pagina
//			}
//			else { //Sino la obtengo de la sesion y le sumo o le resto 1 (siguiente pagina o anterior pagina)
//				if(direccion == 1) { //Siguiente
//					pagina = new Integer(session.getAttribute("pagina").toString()) + 1;
//					session.setAttribute("pagina", pagina); //Actualizo la pagina en la sesion con nuevo valor
//				}
//				else { //Anterior
//					pagina = new Integer(session.getAttribute("pagina").toString()) - 1;
//					pagina = pagina < 0 ? 0 : pagina; //Si pagina es menor que 0 significa que ya llegue al principio, asi que siempre sera la pagina 0
//					session.setAttribute("pagina", pagina); //Actualizo la pagina en la sesion con nuevo valor
//				}
//			}
//	
			//Page = objeto de spring data que representa la pagina
			List<Transaction> films = null;
			Account account = accountService.findOne((int)session.getAttribute("account_id"));
			if(start!=null && end!=null) {
				films = transService.findAll(start,end,pagina,account);
			}else {
				films = transService.findAll(pagina,account);
			}
			
			System.out.println("El tamañò es:"+films.size());
			//films=(List<Film>) filmRepo.findAll();
			//Como Page no es una coleccion en si, utilizo el metodo getContent() el cual me devuelve la coleccion (de clientes) que representa la pagina
			mav.addObject("films", films);
			
			mav.addObject("actual", Math.min((pagina + 1) * 10,transService.countAll()));
			mav.addObject("total", transService.countAll());
			
			mav.addObject("pagina", pagina + 1);
			mav.setViewName("client/transactions_all");
			return mav;
		}
	

}


