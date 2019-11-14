package br.com.tt.locadoraveiculosweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tt.locadoraveiculosweb.model.Veiculo;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	public List<Veiculo> findByMarca(String marca);
	
	public List<Veiculo> findByMarcaAndModelo(String marca, String modelo);
	
	public List<Veiculo> findByTipoCombustivel(TipoCombustivel tipoCombustivel);
	
}
