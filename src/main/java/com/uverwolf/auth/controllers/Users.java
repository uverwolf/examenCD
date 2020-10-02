package com.uverwolf.auth.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uverwolf.auth.models.Show;
import com.uverwolf.auth.models.ShowUser;
import com.uverwolf.auth.models.User;
import com.uverwolf.auth.services.UserService;
import com.uverwolf.auth.validations.UserValidator;

@Controller
public class Users {
	@Autowired
	UserService servicios;
	@Autowired
	UserValidator userValidator;
    @GetMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result,Model modelo, HttpSession session) {
    	
    	userValidator.validate(user, result);
    	
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}else {
    		servicios.saveWithUserRole(user);
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Datos incorrecto intente denuevo.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Se deslogeo correctamente!");
        }
        return "loginPage.jsp";
    }
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", servicios.findByUsername(username));
        model.addAttribute("programas", servicios.verShows());
       
        return "homePage.jsp";
    }
    
    
    @GetMapping("/shows/new")
    public String crearShow(@Valid @ModelAttribute("show") Show show) {
    	
    	return "showAdd.jsp";	
    }
    @PostMapping("/shows/new")
    public String agregarShow(@Valid @ModelAttribute("show")Show show, BindingResult result) {
    	if(result.hasErrors()) {
    		return "showAdd.jsp";
    	}else {
    		servicios.saveShow(show);
    		return "redirect:/home";
    	}
    }
    
    @GetMapping("/shows/{id}")
    public String verShow(Principal principal,@Valid @ModelAttribute("showUser")ShowUser showUser,@PathVariable("id")Long id, Model modelo) {
    	modelo.addAttribute("show", servicios.buscarShow(id));
    	modelo.addAttribute("ratings", servicios.verRating(id));
        String username = principal.getName();
        modelo.addAttribute("currentUser", servicios.findByUsername(username));
        return "showVer.jsp";
    }
    
    @GetMapping("/shows/{id}/edit")
    public String verEditarShow(@PathVariable("id")Long id,Model modelo) {
    	modelo.addAttribute("show", servicios.buscarShow(id));
    	return "showEditar.jsp";
    }
    @PostMapping("shows/{id}/edit")
    public String editarShow(@Valid @ModelAttribute("show")Show show,BindingResult result,@PathVariable("id")Long id, Model modelo) {
    	if(result.hasErrors()) {
    		return "showEditar.jsp";
    	}else {
    	servicios.actualizarShow(show);
    	return "redirect:/shows/"+id;
    	}
    }
    @GetMapping("shows/{id}/delete")
    public String eliminarShow(@PathVariable("id")Long id) {
    	servicios.eliminarShow(id);
    	return"redirect:/home";
    }
    
    
    @PostMapping("shows/{id}/rating")
    public String calificar(Principal principal,@Valid @ModelAttribute("showUser")ShowUser showuser, BindingResult result,@PathVariable("id")Long id,Model modelo) {
    	if(result.hasErrors()) {
    		return "showVer.jsp";
    	}
    	else {
    		
            String username = principal.getName();
            User usuario= servicios.findByUsername(username);
            Show programa = servicios.buscarShow(id);
            int rating = showuser.getRating();
            
            
            servicios.rateShow(programa, usuario, rating);
            return "redirect:/shows/"+id;
    	}
    }
    
    
    
    
    
    
    
    @GetMapping("/delete/{id}")
    
    public String eliminar(@PathVariable("id")Long id) {
    	servicios.eliminar(id);
    	return "redirect:/admin";
    }
    @GetMapping("/updateA/{id}")
    public String updateToAdmin(@PathVariable("id")Long id) {
    	servicios.adminACT(id);
    	return "redirect:/admin";
    }
}
