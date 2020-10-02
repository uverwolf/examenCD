package com.uverwolf.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uverwolf.auth.models.Show;
import com.uverwolf.auth.models.ShowUser;
import com.uverwolf.auth.models.User;
import com.uverwolf.auth.repositories.RoleRepository;
import com.uverwolf.auth.repositories.ShowRepository;
import com.uverwolf.auth.repositories.ShowUserRepository;
import com.uverwolf.auth.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	ShowRepository showRepo;
	@Autowired
	ShowUserRepository showUserRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
    // 2 
   public void saveUserWithAdminRole(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
       userRepo.save(user);
   }    
   
   // 3
   public User findByUsername(String username) {
       return userRepo.findByUsername(username);
   }
   public List<User> todos(){
	   return userRepo.findAll();
   }
   public List<Show> verShows(){
	   return showRepo.findAll();
   }
   
   

   
   
   public void saveShow(Show show) {
	   showRepo.save(show);
   }
   public Show buscarShow(Long id) {
	   Optional<Show> show = showRepo.findById(id);
	   if(show.isPresent()) {
		   return show.get();
	   }else {
		   return null;
	   }
   }
   public void actualizarShow(Show show) {
	   Optional<Show> programa = showRepo.findById(show.getId());
	   if(programa.isPresent()) {
		   programa.get().setName(show.getName());
		   programa.get().setNetwork(show.getNetwork());
		   showRepo.save(programa.get());
		   
	   }else {
		   
	   }
   }
   public void eliminarShow(Long id) {
	   showRepo.deleteById(id);
   }
   public void rateShow(Show show, User user, int rating) {
	  
		   if(show.getUsers().contains(user)) {
			  
		   }else {
			   showUserRepo.Rating(show.getId(), user.getId(), rating);
		   }
	   
	   
	   
	   showRepo.actualizarPromedio(rating, show.getId());
   }
   
   
   
   public List<ShowUser> verRating(Long id) {
	   return showUserRepo.verRate(id);
   }
   
   
 
   
   public void eliminar(Long id) {
	    userRepo.deleteById(id);
   }
   public void adminACT(Long id) {
	    userRepo.joinUserUsers_roles(id);
	
}

}
