package br.com.tt.locadoraveiculosweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.com.tt.locadoraveiculosweb.model.enums.TipoCombustivel;

@Entity
@Table(name = "VEICULO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(name = "PLACA")
	protected String placa;
	@Column(name = "MARCA")
	protected String marca;
	@Column
	protected String modelo;
	@Column(name = "KM_ATUAL")
	protected Double quilometragem;
	@Column(name = "TIPO_COMBUSTIVEL")
	@Enumerated(EnumType.STRING)
	protected TipoCombustivel tipoCombustivel;
	
	protected Veiculo() {
		super();
	}
	
	public Veiculo(String placa, String marca, String modelo, 
			Double quilometragem, TipoCombustivel tipoCombustivel) {
		this();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.quilometragem = quilometragem;
		this.tipoCombustivel = tipoCombustivel;
	}

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Double getQuilometragem() {
		return quilometragem;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
}
