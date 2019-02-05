package domain;


public enum Bandeira {
	
	VISA(1, "Visa"),
	MASTER(2, "MasterCard"),
	ELO(3, "Elo"),
	PAGSEGURO(3, "PagSeguro");
	
	private int cod;
	private String descricao;
	
	private Bandeira(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Bandeira toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Bandeira x : Bandeira.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	public static Bandeira toEnum(String descricao) {
		if (descricao == null) {
			return null;
		}
		
		for (Bandeira x : Bandeira.values()) {
			if (descricao.contains(x.getDescricao())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + descricao);
	}
}
