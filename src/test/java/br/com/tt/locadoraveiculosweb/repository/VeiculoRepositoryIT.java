package br.com.tt.locadoraveiculosweb.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.tt.locadoraveiculosweb.model.Veiculo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VeiculoRepositoryIT {
	 
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Test
	@Sql(value = "classpath:insere_veiculo.sql")
	public void deveRetornarVeiculosPorMarcaFord() {
		String marca = "Ford";
		List<Veiculo> veiculos = veiculoRepository.findByMarca(marca);
		assertEquals(1, veiculos.size());
		
		for (Veiculo veiculo : veiculos) {
			assertEquals(marca, veiculo.getMarca());
		}
	}
}
