package old;

import java.util.List;

import javax.persistence.Query;

import domain.Cartao;

public class CartaoDAOJPA extends AbstractDAO<Cartao> implements CartaoDAOOld{

	public CartaoDAOJPA() {
	}

	@SuppressWarnings("unchecked")
	public List<Cartao> getCartaosByNome(String nome) {
		if (nome == null || nome.isEmpty())
			return null;
		Query query = getPersistenceContext().createQuery("SELECT o FROM Mercadoria o WHERE o.nome like :nome");
		query.setParameter("nome", nome.concat("%"));
		return (List<Cartao>) query.getResultList();
	}

}
