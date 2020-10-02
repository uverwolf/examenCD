package com.uverwolf.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uverwolf.auth.models.ShowUser;

public interface ShowUserRepository extends CrudRepository<ShowUser, Long> {
	@Transactional
	@Modifying
	@Query(value="insert into shows_users (show_id,user_id,rating) values (?1,?2,?3)",nativeQuery=true)
	void Rating(Long id,Long id2,int rate);
	
	@Transactional
	@Modifying
	@Query(value="select * from shows_users inner join users on shows_users.user_id = users.id inner join shows on shows.id = shows_users.show_id where shows_users.show_id=?1 order by shows_users.rating ASC",nativeQuery=true)
	List<ShowUser> verRate(Long id);
	
	
	

	
						
}
