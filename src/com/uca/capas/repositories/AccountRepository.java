package com.uca.capas.repositories;




import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Account;
import com.uca.capas.domain.User;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public Page<Account> findAll(Pageable page);
	
	@Query(nativeQuery=true, value="select count(*) from public.table_account where username= :username and password= :password")
	public int findOneUserInt(@Param("username")String username,@Param("password") String password) throws DataAccessException ;
	
	@Query(nativeQuery=true, value="select * from public.table_account where username= :username and password= :password")
	public Account findOneUser(@Param("username")String username,@Param("password") String password) throws DataAccessException ;
	
}
