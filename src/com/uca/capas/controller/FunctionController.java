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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Film;
import com.uca.capas.domain.Function;
import com.uca.capas.domain.Ticket_type;
import com.uca.capas.repositories.FunctionRepository;
import com.uca.capas.service.FilmService;
import com.uca.capas.service.FunctionService;
import com.uca.capas.service.Ticket_typeService;

@Controller
public class FunctionController {
	@Autowired
	private FunctionService functionService;
	@Autowired
	private FilmService filmService;
	@Autowired
	private Ticket_typeService ticketService;
	
	@Autowired
	private FunctionRepository functionRepo;
	
	@RequestMapping("function/list")
		public ModelAndView vertodos(HttpSession session, 
				HttpServletRequest request, 
				@RequestParam(required = false) Integer direccion) throws Exception{
			ModelAndView mav = new ModelAndView();
			int pagina=0;
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
			List<Function> functions = null;
			
			functions = functionService.findAll(pagina);
			//functions=(List<Function>) functionRepo.findAll();
			//Como Page no es una coleccion en si, utilizo el metodo getContent() el cual me devuelve la coleccion (de clientes) que representa la pagina
			mav.addObject("functions", functions);
			mav.addObject("actual", (pagina + 1) * 10);
			mav.addObject("total", functionService.countAll());
			mav.addObject("pagina", pagina + 1);
			mav.setViewName("function/view_all");
			return mav;
		}
	
	@RequestMapping("function/new")
	public ModelAndView crear(HttpSession session, 
			HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView();
			List<Film> films= filmService.findAll();
			List<Ticket_type> tickettypes= ticketService.findAll();
			mav.addObject("films", films);
			mav.addObject("tickettypes", tickettypes);
			mav.setViewName("function/new");
			return mav;
	}
	
	
	 @RequestMapping(value = "function/store")
	   public String redirect(@RequestParam(required = false) Integer idfunction ,@RequestParam("starttime") String starttime, @RequestParam("film") int film_id,@RequestParam("tickettype") int tickettype,@RequestParam(required = false) String activestate) {
		 Function function;
		   if(idfunction==null) {
			 function = new Function();
			
		   }else {
			  function = functionService.findOne(idfunction);
			  
			  
		   }
		   
		   Film film = filmService.findOne(film_id);
			 Ticket_type ticket = ticketService.findOne(tickettype);
			 function.setIdfunction(idfunction);
			 function.setTickettype(ticket);
			 function.setFilm(film);
			 System.out.println("ESTADO DEL CHECKBOX"+idfunction);
			 System.out.println("ESTADO DEL CHECKBOX"+activestate!=null?1:0);
			 function.setActivestate(activestate!=null?1:0);
			 function.setStarttime(starttime);
		   
		 functionService.save(function);
	      return "redirect:/function/list";
	   }
	 
	 @RequestMapping(value="function/edit/{id}")
		public ModelAndView edit(@PathVariable(value="id") int id ,HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView();
			Function function=functionService.findOne(id);
			if(function!=null) {
			mav.addObject("function", function);
			List<Film> films= filmService.findAll();
			List<Ticket_type> tickettypes= ticketService.findAll();
			mav.addObject("films", films);
			mav.addObject("tickettypes", tickettypes);
			mav.setViewName("function/edit");
			}
			else {
				return new ModelAndView("redirect:/function/list");
			}
			return mav;	
		}
		
		@RequestMapping(value="function/view/{id}")
		public ModelAndView view(@PathVariable(value="id") int id ,HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView();
			Function function=functionService.findOne(id);
			if(function!=null) {
				
				List<Film> films= filmService.findAll();
				List<Ticket_type> tickettypes= ticketService.findAll();
				mav.addObject("films", films);
				mav.addObject("tickettypes", tickettypes);
				mav.addObject("function", function);
				mav.setViewName("function/view");
				}
				else {
					return new ModelAndView("redirect:/function/list");
				}
			return mav;	
		}
}
