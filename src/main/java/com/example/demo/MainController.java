package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.User;
import com.example.demo.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller //Indica que la clase es un controlador
@RequestMapping(path="/api") //Indica la ruta URL del controlador
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
	
	@GetMapping(path="/user/{id}")//Mapeo a GET
	public @ResponseBody Optional<User> getUser(@PathVariable Integer id){ //Tipo respuesta
		return userRepository.findById(id);
	}
	
	@GetMapping(path="/all")//Mapeo a GET
	public @ResponseBody Iterable<User> getAllUsers(){ //Tipo respuesta
		return userRepository.findAll();
	}
	
	@PostMapping(path="/addPost")
	public @ResponseBody Iterable<User> addUser(@RequestBody Iterable<User> users) {
	
		return userRepository.saveAll(users);
	}

}
