package br.com.tt.locadoraveiculosweb.model;

import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

public abstract class Veiculo {

	protected String placa;
	protected String marca;
	protected String modelo;
	protected float quilometragem;
	protected TipoCombustivel tipoCombustivel;
	
	public Veiculo(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}
}
