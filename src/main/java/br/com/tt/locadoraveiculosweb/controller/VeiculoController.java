package br.com.tt.locadoraveiculosweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.tt.locadoraveiculosweb.model.Carro;
import br.com.tt.locadoraveiculosweb.model.dto.VeiculoDTO;
import br.com.tt.locadoraveiculosweb.service.VeiculoService;

@Controller
public class VeiculoController {

	private final VeiculoService veiculoService;

	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping("/rota-veiculo-voltar-index")
	public String voltarTelaInicial() {
		return "index";
	}

	@GetMapping("/rota-cadastrar-veiculo")
	public String abrirTelaCadastroVeiculo(Model model) {
		model.addAttribute("tiposVeiculos", 
				veiculoService.listarTiposVeiculo());
		model.addAttribute("tiposCombustivel", 
				veiculoService.listarTiposCombustivel());
		model.addAttribute("tiposCaminhao", 
				veiculoService.listarTiposCaminhao());
		model.addAttribute("tiposCambio", 
				veiculoService.listarTiposCambio());
		model.addAttribute("numerosCilindrada", 
				veiculoService.listarTiposCilindrada());
		model.addAttribute("tiposCarro", 
				veiculoService.listarTiposCarro());
		model.addAttribute("numerosPortas", 
				veiculoService.listarNumerosPorta());
		
		return "veiculo-form";
	}

	// nome da rota chamada
	@GetMapping("/rota-veiculo-listar")
	public String redirecionarParaListaVeiculos(Model model) {
		model.addAttribute("veiculos", veiculoService.listarTodos());
		// nome do template que será renderizado
		return "/veiculo-listar";
	}

	@PostMapping("/rota-veiculo-form")
	public String adicionarVeiculo(VeiculoDTO veiculoDTO) {
		veiculoService.incluir(new Carro(veiculoDTO.getPlaca()));
		return "redirect:/rota-veiculo-listar";
	}
}
