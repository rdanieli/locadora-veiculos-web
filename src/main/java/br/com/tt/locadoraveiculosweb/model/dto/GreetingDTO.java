package br.com.tt.locadoraveiculosweb.model.dto;

public class GreetingDTO {

	private final String name;
	private final String content;
	private final int contador;
	
	public GreetingDTO(String name, String content, int contador) {
		this.name = name;
		this.content = content;
		this.contador = contador;
	}
	
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	
	public int getContador() {
		return contador;
	}
}
