package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class aplicarDescontoSobre implements Desconto {
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

}
