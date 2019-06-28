package com.uca.capas.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.Film;
import com.uca.capas.domain.Function;
import com.uca.capas.domain.Transaction;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.FilmService;
import com.uca.capas.service.FunctionService;
import com.uca.capas.service.TransactionService;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CinemaController {
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FunctionService functionService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
@RequestMapping(value = "/dashboard-client" )
	public ModelAndView dashboard (HttpSession session) {
	if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
		return new ModelAndView("redirect:/");
	}
		ModelAndView dashboard = new ModelAndView();
		
		List<Film> filmList = filmService.findAllActive();
		dashboard.addObject("films", filmList);
		dashboard.setViewName("client/client-dashboard");
		
		return dashboard;
	}
	
	@RequestMapping(value = "/film-detail/{id}")
	public ModelAndView filmDetail (HttpSession session,@PathVariable(value="id") int id ) {
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
			return new ModelAndView("redirect:/");
		}
		ModelAndView filmDetail = new ModelAndView();
		
		Film film = filmService.findOne(id);
		List<Function> functions=functionService.findAllbyIdFilm(id);
		filmDetail.addObject("film", film);
		filmDetail.addObject("functions", functions);
		filmDetail.setViewName("client/film-detail");
		
		return filmDetail;
	}
	
	@RequestMapping(value = "/film-detail/{id}/reserva")
	public ModelAndView filmReserve (HttpSession session,@PathVariable(value="id") int id ) {
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
			return new ModelAndView("redirect:/");
		}
		ModelAndView filmDetail = new ModelAndView();
		List<Function> functions=functionService.findAllbyIdFilm(id);
		Film film = filmService.findOne(id);
		
		filmDetail.addObject("film", film);
		filmDetail.addObject("functions",functions);
		filmDetail.setViewName("client/transaction");
		
		return filmDetail;	
	}
	
	@RequestMapping(value = "/film-detail/{id}/reservacion")
	public ModelAndView filmReserving (HttpSession session,@PathVariable(value="id") int id,@RequestParam(value="idfunction") Integer idfunction,@RequestParam(value="ticketquantity") Integer ticketquantity,@RequestParam(value="accountcredit",required=false) String accountcredit) {
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		Transaction transaction=new Transaction();
		float total=ticketquantity*(functionService.findOne(idfunction).getTickettype().getTicketcost());
		float subtotal=ticketquantity*(functionService.findOne(idfunction).getTickettype().getTicketcost());;
		float saldocuenta=accountService.findOne((int)session.getAttribute("account_id")).getCredit();;
		float saldoutilizado=0;
		float saldocuentaaux=saldocuenta;
	
		transaction.setAccount(accountService.findOne((int)session.getAttribute("account_id")));
		transaction.setFunction(functionService.findOne(idfunction));
		transaction.setTicketquantity(ticketquantity);
		transaction.setTransactiondatehour(new Date(System.currentTimeMillis()  ));
		if(accountcredit==null) {
		}else {
			if(saldocuenta<total) {
			total=total-saldocuenta;
			saldoutilizado=saldocuenta;
			saldocuenta=0;
			}else if(saldocuenta==total){
				total=total-saldocuenta;
				saldocuenta=saldocuenta-total;
				saldoutilizado=saldocuenta;
			}else if(saldocuenta>total){
				saldocuenta=saldocuenta-total;
				saldoutilizado=saldocuentaaux-saldocuenta;
				total=0;
			}
		}
		transaction.setUsedcredit(saldoutilizado);
		transaction.setTotal(total);
		session.setAttribute("transaction", transaction);
		mav.addObject("transaction", transaction);
		mav.addObject("total", total);
		mav.addObject("subtotal", subtotal);
		mav.addObject("saldocuenta", saldocuenta);
		mav.addObject("saldoutilizado", saldoutilizado);
		mav.setViewName("client/transactionconfirm");
		return mav;
	}
	@RequestMapping(value = "/film-detail/{id}/reservado")
	public ModelAndView filmReserved (HttpSession session,
			@PathVariable(value="id") int id,
			@RequestParam(value="idfunction") Integer idfunction,
			@RequestParam(value="ticketquantity") Integer ticketquantity,
			@RequestParam(value="idaccount") Integer idaccount,
			@RequestParam(value="saldocuenta") float saldocuenta) {
		if(session.getAttribute("user") == null || session.getAttribute("role")==null || session.getAttribute("account_id")==null || (Integer)session.getAttribute("role")!=2){
			return new ModelAndView("redirect:/");
		}
		Account account=accountService.findOne(idaccount);
		account.setCredit(saldocuenta);
		accountService.save(account);
		transactionService.save((Transaction)session.getAttribute("transaction"));
		return new ModelAndView("redirect:/transaction/list");
	}
		
}
