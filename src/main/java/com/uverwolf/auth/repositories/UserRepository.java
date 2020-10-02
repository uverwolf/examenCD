package com.uverwolf.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uverwolf.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String email);
	List<User>findAll();
	@Transactional
	@Modifying
	@Query(value="update users_roles set role_id = 1 where user_id =?1",nativeQuery=true)
	void joinUserUsers_roles(Long id);
	
	
}
