package br.com.tt.locadoraveiculosweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/rota-cliente-listar")
	public String redirecionarParaListaClientes() {
		return "cliente-listar";
	}

	@GetMapping("/rota-locacao-listar")
	public String redirecionarParaListaLocacoes() {
		return "locacao-listar";
	}
}
