package tp.digi.flightMng.dao;

import javax.persistence.EntityManager;

public class GenericDAO<T> {
	
	// Need to know class name for certain methods of Entity Manager.
	//private Class<T> qlass;
	
	public T findById(Long id) {
		// TODO: Not yet implemented
		return null;
	}
	
	public T remove(T t) {
		// TODO: Not yet implemented
		return null;
	}
	
	/**
	 * Makes t persistent.
	 * @param t
	 * @return
	 */
	public T[] persist(T...t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (T singleT : t) em.persist(singleT);
		DatabaseHelper.commitTxAndClose(em);
		return t;
	}
	
	
}
