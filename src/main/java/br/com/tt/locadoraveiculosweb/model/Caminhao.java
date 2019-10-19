package br.com.tt.locadoraveiculosweb.model;

import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCaminhao;

public class Caminhao extends Veiculo {

	private TipoCaminhao tipo;
	private Cambio cambio;
	
	public Caminhao(String placa) {
		super(placa);
	}
}
