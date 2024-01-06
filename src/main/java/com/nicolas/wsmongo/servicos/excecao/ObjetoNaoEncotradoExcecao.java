package com.nicolas.wsmongo.servicos.excecao;

public class ObjetoNaoEncotradoExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public ObjetoNaoEncotradoExcecao(String msg) {
		super(msg);
	}
}
