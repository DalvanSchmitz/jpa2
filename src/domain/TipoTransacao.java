package domain;

public enum TipoTransacao {
	
	DEBITO(1, "D�bito"),
	CREDITO(3, "Cr�dito");
	
	private int cod;
	private String descricao;
	
	private TipoTransacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoTransacao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoTransacao x : TipoTransacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inv�lido: " + cod);
	}
	
	public static TipoTransacao toEnum(String descricao) {
		if (descricao == null) {
			return null;
		}
		
		for (TipoTransacao x : TipoTransacao.values()) {
			if (descricao.contains(x.getDescricao())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inv�lido: " + descricao);
	}

}
