package com.nicolas.wsmongo.recursos.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nicolas.wsmongo.servicos.excecao.ObjetoNaoEncotradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManiuladorDeRecursoExcecao {

	@ExceptionHandler(ObjetoNaoEncotradoExcecao.class)
	public ResponseEntity<PadraoError> objectNotFound(ObjetoNaoEncotradoExcecao e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		PadraoError err = new PadraoError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}