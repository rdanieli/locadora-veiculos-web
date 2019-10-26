package br.com.tt.locadoraveiculosweb.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tt.locadoraveiculosweb.exception.CampoObrigatorioException;
import br.com.tt.locadoraveiculosweb.exception.RegraNegocioException;
import br.com.tt.locadoraveiculosweb.exception.TamanhoExatoCaracteresException;
import br.com.tt.locadoraveiculosweb.model.Veiculo;
import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.Cilindrada;
import br.com.tt.locadoraveiculosweb.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCaminhao;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCarro;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;
import br.com.tt.locadoraveiculosweb.model.enums.TipoVeiculo;
import br.com.tt.locadoraveiculosweb.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;

	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public List<Veiculo> listarTodos() {
		// return veiculoRepository.listarTodos();
		return veiculoRepository.findAll();
	}

	public void incluir(Veiculo veiculo) throws RegraNegocioException {
		// validações de entrada de dados
		if (veiculo.getPlaca() == null || veiculo.getPlaca().isBlank()) {
			throw new CampoObrigatorioException("Placa");
		}
		
		if (veiculo.getPlaca().length() != 7) {
			throw new TamanhoExatoCaracteresException("Placa", 7);
		}
		
		// veiculoRepository.incluir(veiculo);
		veiculoRepository.save(veiculo);
	}

	public List<TipoVeiculo> listarTiposVeiculo() {
		TipoVeiculo[] array = TipoVeiculo.values();
		List<TipoVeiculo> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(TipoVeiculo::name));
		return lista;
	}

	public List<TipoCombustivel> listarTiposCombustivel() {
		TipoCombustivel[] array = TipoCombustivel.values();
		List<TipoCombustivel> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(TipoCombustivel::name));
		return lista;
	}

	public List<TipoCaminhao> listarTiposCaminhao() {
		TipoCaminhao[] array = TipoCaminhao.values();
		List<TipoCaminhao> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(TipoCaminhao::name));
		return lista;
	}

	public List<Cambio> listarTiposCambio() {
		Cambio[] array = Cambio.values();
		List<Cambio> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(Cambio::name));
		return lista;
	}

	public List<Cilindrada> listarTiposCilindrada() {
		Cilindrada[] array = Cilindrada.values();
		List<Cilindrada> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(Cilindrada::name));
		return lista;
	}

	public List<TipoCarro> listarTiposCarro() {
		TipoCarro[] array = TipoCarro.values();
		List<TipoCarro> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(TipoCarro::name));
		return lista;
	}

	public List<NumeroPortas> listarNumerosPorta() {
		NumeroPortas[] array = NumeroPortas.values();
		List<NumeroPortas> lista = Arrays.asList(array);
		Collections.sort(lista, Comparator.comparing(NumeroPortas::name));
		return lista;
	}
}
