package com.uverwolf.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uverwolf.auth.models.Show;


public interface ShowRepository extends CrudRepository<Show, Long>{

	
	List<Show> findAll();
	
	@Transactional
	@Modifying
	@Query(value="update shows set average =?1 where shows.id = ?2 ",nativeQuery=true)
	void actualizarPromedio(double rating,Long id);
	
}
