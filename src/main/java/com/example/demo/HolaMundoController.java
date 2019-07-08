package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonEncoding;

@RestController
public class HolaMundoController {
	
	@RequestMapping("/saludar")
	public Map<String, String> saludar() {
		HashMap<String, String> map = new HashMap<>();
		map.put("nombre", "Alexander");
	    map.put("apellido", "Rodriguez");
	    map.put("edad", "38");
	    return map;
	}

}
