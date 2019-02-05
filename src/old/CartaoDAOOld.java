package old;

import java.util.List;

import domain.Cartao;

public interface CartaoDAOOld {

	void save(Cartao Cartao);
	
	void save(List<Cartao> cartao);
	
	void remove(Cartao Cartao);
	
	List<Cartao> getAll();
	
	List<Cartao> getCartaosByNome(String nome);
	
	Cartao findById(Integer id);

}

