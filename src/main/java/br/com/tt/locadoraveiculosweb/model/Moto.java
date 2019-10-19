package br.com.tt.locadoraveiculosweb.model;

import br.com.tt.locadoraveiculosweb.model.enums.Cilindrada;

public class Moto extends Veiculo {

	private Cilindrada cilindrada;

	public Moto(String placa) {
		super(placa);
	}
}
