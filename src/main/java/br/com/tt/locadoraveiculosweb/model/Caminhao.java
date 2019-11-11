package br.com.tt.locadoraveiculosweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCaminhao;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

@Entity
@Table(name = "VEICULO_CAMINHAO")
public class Caminhao extends Veiculo {

	@Column
	@Enumerated(EnumType.STRING)
	private TipoCaminhao tipo;
	@Column
	@Enumerated(EnumType.STRING)
	private Cambio cambio;
	
	@SuppressWarnings("unused")
	private Caminhao() {
		super();
	}
	
	public Caminhao(String placa, String marca, String modelo, 
			Double quilometragem, TipoCombustivel tipoCombustivel,
			TipoCaminhao tipoCaminhao, Cambio cambio) {
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		this.tipo = tipoCaminhao;
		this.cambio = cambio;
	}

	public TipoCaminhao getTipo() {
		return tipo;
	}

	public void setTipo(TipoCaminhao tipo) {
		this.tipo = tipo;
	}

	public Cambio getCambio() {
		return cambio;
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
}
