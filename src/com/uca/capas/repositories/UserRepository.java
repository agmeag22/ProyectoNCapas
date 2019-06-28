package com.uca.capas.repositories;

import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.uca.capas.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query(nativeQuery=true, value="select count(*) from public.table_user where username= :username and pass= :password")
	public int findOneUser(@Param("username")String username,@Param("password") String password) throws DataAccessException ;


	@Query(nativeQuery=true, value="select * from table_user where id_store=:code")
	public List<User> findBySucursal(@Param("code") int code) throws DataAccessException ;
	
	@Query(nativeQuery=true, value="select id_user from public.table_user "
			+ "where u_name= :uname "
			+ "and u_lastname= :ulastname "
			+ "and u_birthdate=:ubirthdate "
			+ "and u_country=:ucountry"
			+ "and u_municipality=:umunicipality"
			+ "and u_address=:uaddress")
	public int findIdUser(
			@Param("uname")String uname,
			@Param("ulastname") String ulastname,
			@Param("ubirthdate") String ubirthdate,
			@Param("ucountry") String ucountry,
			@Param("umunicipality") String umunicipality,
			@Param("uaddress") String uaddress
			)throws DataAccessException;
	
	
}
