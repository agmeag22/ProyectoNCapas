package com.uca.capas.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.uca.capas.domain.Account;
import com.uca.capas.repositories.AccountRepository;
import com.uca.capas.service.AccountService;
import com.uca.capas.service.AccountServiceImpl;
@WebListener
public class MySessionListener implements HttpSessionListener {
  
    public void sessionCreated(HttpSessionEvent se)  { 
       
      System.out.println("se ha creado una session leyendo info de la base de datos");
    }
    
    
  
    public void sessionDestroyed(HttpSessionEvent se)  {
    
    	 if(se.getSession().getAttribute("account_id")!=null ){
	    	int account_id = (Integer)se.getSession().getAttribute("account_id");
	    	System.out.println(account_id);
			Account account = accountServ().findOne(account_id);
			if(account!=null) {
				account.setOnlinestatus(0);
				accountServ().save(account);
			}
    	 }
    }
    

    
    private AccountService accountServ(){

    	AccountService accountService = BeanUtil.getBean(AccountService.class);

          return accountService;
    }
  
}