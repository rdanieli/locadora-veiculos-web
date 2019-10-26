package br.com.tt.locadoraveiculosweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCarro;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

@Entity
@Table(name = "VEICULO_CARRO")
public class Carro extends Veiculo {

	@Column
	@Enumerated(EnumType.STRING)
	private TipoCarro tipo;
	@Column
	@Enumerated(EnumType.STRING)
	private Cambio cambio;
	@Column
	@Enumerated(EnumType.STRING)
	private NumeroPortas numeroPortas;
	
	@SuppressWarnings("unused")
	private Carro() {
		super();
	}
	
	public Carro(String placa, String marca, String modelo, 
			Double quilometragem, TipoCombustivel tipoCombustivel,
			TipoCarro tipo, Cambio cambio, NumeroPortas numeroPortas) {
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		this.tipo = tipo;
		this.cambio = cambio;
		this.numeroPortas = numeroPortas;
	}

	public TipoCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	public Cambio getCambio() {
		return cambio;
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	public NumeroPortas getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(NumeroPortas numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
}
