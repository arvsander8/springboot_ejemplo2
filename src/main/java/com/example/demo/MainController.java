package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.User;
import com.example.demo.UserRepository;


@Controller //Indica que la clase es un controlador
@RequestMapping(path="/demo") //Indica la ruta URL del controlador
public class MainController {
	
	@Autowired // Para obtener automaticamente el repositorio con el nombre indicado
	private UserRepository userRepository;
	
	@GetMapping(path="/add") //Para mapear operacion tipo GET
	public @ResponseBody String addNewUser( /*devuelve tipo de respuesta*/
			@RequestParam String name, @RequestParam String email) { /*Parametros*/
		
			User n = new User();
			n.setName(name);
			n.setEmail(email);
			userRepository.save(n);
					
			return "Saved";
		
	}
	
	@GetMapping(path="/all")//Mapeo a GET
	@Cacheable("users")
	public @ResponseBody Iterable<User> getAllUsers(){ //Tipo respuesta
		return userRepository.findAll();
	}

}
