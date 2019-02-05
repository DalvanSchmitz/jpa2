package dao;

import java.util.List;

import domain.Cartao;

public class CartaoDAO extends GenericDao<Cartao>{
	
	public void salvar(Cartao c) {
        save(c);
    }
	
	public void salvar(List<Cartao> c) {
        save(c);
    }

    public void alterar(Cartao c) {
        update(c);
    }

    public void excluir(long id) {
    	Cartao c = findById(id);
        delete(c);
    }
}
