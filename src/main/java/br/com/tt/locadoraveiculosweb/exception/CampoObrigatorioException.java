package br.com.tt.locadoraveiculosweb.exception;

public class CampoObrigatorioException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException(String campo) {
		super(String.format("Campo obrigatório não informado: %s.", campo));
	}
}
