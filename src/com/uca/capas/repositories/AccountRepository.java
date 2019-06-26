package com.uca.capas.repositories;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.uca.capas.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public Page<Account> findAll(Pageable page);
}
