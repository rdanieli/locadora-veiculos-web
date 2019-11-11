package br.com.tt.locadoraveiculosweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.tt.locadoraveiculosweb.model.enums.Cilindrada;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

@Entity
@Table(name = "VEICULO_MOTO")
public class Moto extends Veiculo {

	@Column
	@Enumerated(EnumType.STRING)
	private Cilindrada cilindrada;
	
	@SuppressWarnings("unused")
	private Moto() {
		super();
	}
	
	public Moto(String placa, String marca, String modelo, 
			Double quilometragem, TipoCombustivel tipoCombustivel,
			Cilindrada cilindrada) {
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		this.cilindrada = cilindrada;
	}

	public Cilindrada getCilindrada() {
		return cilindrada;
	}
}
