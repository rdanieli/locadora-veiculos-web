package br.com.tt.locadoraveiculosweb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.tt.locadoraveiculosweb.exception.CampoObrigatorioException;
import br.com.tt.locadoraveiculosweb.exception.DadoInvalidoException;
import br.com.tt.locadoraveiculosweb.exception.RegraNegocioException;
import br.com.tt.locadoraveiculosweb.exception.TamanhoExatoCaracteresException;
import br.com.tt.locadoraveiculosweb.model.Carro;
import br.com.tt.locadoraveiculosweb.model.Moto;
import br.com.tt.locadoraveiculosweb.model.Veiculo;
import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.Cilindrada;
import br.com.tt.locadoraveiculosweb.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCarro;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;
import br.com.tt.locadoraveiculosweb.repository.VeiculoRepository;

@ExtendWith(MockitoExtension.class)
public class VeiculoServiceTest {

	@Mock
	private VeiculoRepository veiculoRepository;
	@InjectMocks
	private VeiculoService service;
	
	@Test
	public void deveIncluirVeiculoComSucesso() throws RegraNegocioException {
		Veiculo veiculo = 
				new Moto("ABC1234", null, null, 1000D, null, null);
		
		service.incluir(veiculo);
		Mockito.verify(veiculoRepository).save(veiculo);
	}
	
	@Test
	public void deveRetornarNenhumVeiculo() {
		assertEquals(0, service.listarTodos().size());
	}
	
	@Test
	public void deveRetornar3Veiculos() {
		List<Veiculo> veiculos = new LinkedList<>();
		veiculos.add(new Carro("ABC1234", "Marca Teste", 
				"Modelo Teste", 0D, TipoCombustivel.GASOLINA, 
				TipoCarro.HATCH, Cambio.AUTOMATICO, NumeroPortas.DUAS_PORTAS));
		veiculos.add(new Carro("ABC1235", "Marca Teste", 
				"Modelo Teste", 0D, TipoCombustivel.GASOLINA, 
				TipoCarro.HATCH, Cambio.AUTOMATICO, NumeroPortas.DUAS_PORTAS));
		veiculos.add(new Carro("ABC1236", "Marca Teste", 
				"Modelo Teste", 0D, TipoCombustivel.GASOLINA, 
				TipoCarro.HATCH, Cambio.AUTOMATICO, NumeroPortas.DUAS_PORTAS));
		
		Mockito.when(veiculoRepository.findAll()).thenReturn(veiculos);
		
		assertEquals(3, service.listarTodos().size());
	}
	
	@Test
	public void deveRetonarExcecaoAoIncluirVeiculoComPlacaVazia() throws RegraNegocioException {
		Veiculo veiculo = 
				new Moto("", "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		CampoObrigatorioException excecao = 
				assertThrows(CampoObrigatorioException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Campo obrigatório não informado: Placa.", 
				excecao.getMessage());
	}
	
	@Test
	public void deveRetonarExcecaoAoIncluirVeiculoComPlacaNula() throws RegraNegocioException {
		Veiculo veiculo = 
				new Moto(null, "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		CampoObrigatorioException excecao = 
				assertThrows(CampoObrigatorioException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Campo obrigatório não informado: Placa.", 
				excecao.getMessage());
	}
	
	@Test
	public void deveRetonarExcecaoAoIncluirVeiculoComPlacaEmBranco() throws RegraNegocioException {
		Veiculo veiculo = 
				new Moto("       ", "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		CampoObrigatorioException excecao = 
				assertThrows(CampoObrigatorioException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Campo obrigatório não informado: Placa.", 
				excecao.getMessage());
	}
	
	@Test
	public void 
		deveRetornarExcecaoAoIncluirVeiculoComPlacaComMenosDe7Caracteres() {
		Veiculo veiculo = 
				new Moto("ABC123", "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		TamanhoExatoCaracteresException excecao = 
				assertThrows(TamanhoExatoCaracteresException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Campo Placa deve ter 7 caracteres.", 
				excecao.getMessage());
	}
	
	@Test
	public void 
		deveRetornarExcecaoAoIncluirVeiculoComPlacaComMaisDe7Caracteres() {
		Veiculo veiculo = 
				new Moto("ABC123456", "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		TamanhoExatoCaracteresException excecao = 
				assertThrows(TamanhoExatoCaracteresException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Campo Placa deve ter 7 caracteres.", 
				excecao.getMessage());
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "1111AAA", "123A123", "123A2AA" })
	public void deveRetornarExcecaoAoIncluirPlacaInvalida(String placa) {
		Veiculo veiculo = 
				new Moto(placa, "Kawasaki", "Ninja", 
						0D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		DadoInvalidoException excecao =
				assertThrows(DadoInvalidoException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("Placa inválida.", excecao.getMessage());
	}
	
	@Test
	public void deveRetornarExcecaoAoIncluirKmNegativa() {
		Veiculo veiculo = 
				new Moto("ABC1234", "Kawasaki", "Ninja", 
						-1D, TipoCombustivel.GASOLINA, Cilindrada.CC1000);
		
		DadoInvalidoException excecao =
				assertThrows(DadoInvalidoException.class, 
						() -> service.incluir(veiculo));
		
		assertEquals("KM deve ser maior ou igual à 0.", excecao.getMessage());
	}
}
