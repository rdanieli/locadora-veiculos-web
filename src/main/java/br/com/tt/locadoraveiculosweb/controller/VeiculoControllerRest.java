package br.com.tt.locadoraveiculosweb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tt.locadoraveiculosweb.exception.RegraNegocioException;
import br.com.tt.locadoraveiculosweb.model.Carro;
import br.com.tt.locadoraveiculosweb.model.Moto;
import br.com.tt.locadoraveiculosweb.model.Veiculo;
import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCarro;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;
import br.com.tt.locadoraveiculosweb.service.VeiculoService;

@RestController
public class VeiculoControllerRest {

	private final VeiculoService veiculoService;
	
	public VeiculoControllerRest(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	@GetMapping("/veiculos/{id}")
	public ResponseEntity<Veiculo> obterVeiculo(@PathVariable("id") String id) {
		
		Veiculo veiculo = veiculoService.findById(Long.parseLong(id));
		
		if(veiculo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	
	@GetMapping("/veiculos")
	public List<Veiculo> obtemTodosOsVeiculo(){
		return veiculoService.listarTodos();
	}
	
	@PostMapping("/veiculos/moto")
	public ResponseEntity criarNovaMoto(@RequestBody Moto moto) {
		return criarNovoVeiculo(moto);
	}
	
	@PostMapping("/veiculos/carro")
	public ResponseEntity criarNovoCarro(@RequestBody Carro carro) {
		return criarNovoVeiculo(carro);
	}
	
	private ResponseEntity criarNovoVeiculo(Veiculo veiculo) {
		try {
			veiculoService.incluir(veiculo);
		} catch (RegraNegocioException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}
