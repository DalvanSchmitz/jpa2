package old;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.AbstractEntity;

public abstract class AbstractDAO<T> {

	private final Class<T> persistentClass;

	private EntityManager em;
	private EntityManagerFactory emf;
	private static final String RESOURCE_LOCAL = "conciliacao";

	public AbstractDAO() {
		connect();
		this.persistentClass = (Class<T>) ((ParameterizedType) 
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void connect() {
		emf = Persistence.createEntityManagerFactory(RESOURCE_LOCAL);
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public EntityManagerFactory getPersistenceFactory() {
		return this.emf;
	}
	
	public EntityManager getPersistenceContext() {
		return this.em;
	}

	public void save(T e) {
		getPersistenceContext().persist(e);
		commit();
		close();
	}
	
	public void save(List<T> e) {
		e.forEach(l ->{
			getPersistenceContext().persist(l);
		});
		commit();
		close();
	}

	public void remove(T e) {
		getPersistenceContext().remove(e);
		close();
	}

	public T findById(Integer id) {
		T e = getPersistenceContext().find(this.persistentClass, id);
		close();
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Query query = getPersistenceContext().createQuery("FROM " + this.persistentClass.getName());
		close();
		return (List<T>) query.getResultList();
	}

	public void close() {
		getPersistenceContext().close();
		getPersistenceFactory().close();
	}

	public void persist(Object obj) {
		getPersistenceContext().persist(obj);
	}

	public void commit() {
		getPersistenceContext().getTransaction().commit();
	}
}