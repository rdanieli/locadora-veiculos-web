package br.com.tt.locadoraveiculosweb.model.dto;

import br.com.tt.locadoraveiculosweb.model.enums.Cambio;
import br.com.tt.locadoraveiculosweb.model.enums.Cilindrada;
import br.com.tt.locadoraveiculosweb.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCaminhao;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCarro;
import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;
import br.com.tt.locadoraveiculosweb.model.enums.TipoVeiculo;

public class VeiculoDTO {

	private TipoVeiculo tipoVeiculo;
	private String placa;
	private String marca;
	private String modelo;
	private float quilometragem;
	private TipoCombustivel tipoCombustivel;
	private TipoCaminhao tipoCaminhao;
	private Cambio cambio;
	private Cilindrada cilindrada;
	private TipoCarro tipoCarro;
	private NumeroPortas numeroPortas;

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(float quilometragem) {
		this.quilometragem = quilometragem;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public TipoCaminhao getTipoCaminhao() {
		return tipoCaminhao;
	}

	public void setTipoCaminhao(TipoCaminhao tipoCaminhao) {
		this.tipoCaminhao = tipoCaminhao;
	}

	public Cambio getCambio() {
		return cambio;
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	public Cilindrada getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Cilindrada cilindrada) {
		this.cilindrada = cilindrada;
	}

	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	public NumeroPortas getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(NumeroPortas numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
}
