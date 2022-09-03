package com.example.delivery;

public enum StatusPedido {
	
	ABERTO ("ABERTO"),
	FECHADO ("FECHADO");
	
	private String descricao;
	
	public static StatusPedido buscaStatusPedidos(String status) {
		StatusPedido retorno = null;
		for (StatusPedido pedidoStatus : StatusPedido.values()) {
			if(pedidoStatus.getDescricao().equals(status.toUpperCase())) {
				retorno = pedidoStatus;
			}
		}
		return retorno;
		
	}
	
	StatusPedido(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
