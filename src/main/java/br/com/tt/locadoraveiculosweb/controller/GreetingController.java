package br.com.tt.locadoraveiculosweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tt.locadoraveiculosweb.model.dto.GreetingDTO;

@RestController
public class GreetingController {

	private static int contador = 0;
	
	@RequestMapping("/greeting")
	public GreetingDTO greeting(@RequestParam(value = "name", 
										      defaultValue = "Não informado", 
										      required = true) String name) {
		
		if(contador == 10) {
			contador = 0;
		}
		
		return new GreetingDTO(name, "Trust", ++ contador);
	}
	
	
}
