package br.com.tt.locadoraveiculosweb.exception;

public class DadoInvalidoException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;
	
	public DadoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
