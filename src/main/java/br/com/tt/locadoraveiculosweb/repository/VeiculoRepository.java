package br.com.tt.locadoraveiculosweb.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tt.locadoraveiculosweb.model.Caminhao;
import br.com.tt.locadoraveiculosweb.model.Carro;
import br.com.tt.locadoraveiculosweb.model.Moto;
import br.com.tt.locadoraveiculosweb.model.Veiculo;

@Repository
public class VeiculoRepository {

	private List<Veiculo> veiculos;

	public VeiculoRepository() {
		veiculos = new LinkedList<>();
		veiculos.add(new Caminhao("ABC1234"));
		veiculos.add(new Carro("BBB1234"));
		veiculos.add(new Moto("CCC1234"));
	}

	public List<Veiculo> listarTodos() {
		return veiculos;
	}

	public void incluir(Veiculo veiculo) {
		veiculos.add(veiculo);
	}
}
