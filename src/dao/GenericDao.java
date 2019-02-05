package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDao<T> {

    @PersistenceContext(unitName = "conciliacao")
    private final EntityManager entityManager;
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
	public GenericDao() {
        this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    protected void save(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().persist(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }
    
    protected void save(List<T> entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            entity.forEach(l ->{
            	getEntityManager().persist(l);
            });
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    protected void update(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().merge(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }

    }

    protected void delete(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().remove(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	public List<T> findAll() throws Exception {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(persistentClass).list();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	public T findByName(String nome) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass)
			.add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
	public T findById(long id) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass)
			.add(Restrictions.eq("id", id)).uniqueResult();
    }

    private void close() {
        if (getEntityManager().isOpen()) {
            getEntityManager().close();
        }
        shutdown();
    }

    private void shutdown() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.close();
    }
}