package br.com.tt.locadoraveiculosweb.exception;

public class TamanhoExatoCaracteresException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;
	
	public TamanhoExatoCaracteresException(String campo, int numeroCaracteres) {
		super(String.format("Campo %s deve ter %d caracteres.", 
				campo, 
				numeroCaracteres));
	}
}
