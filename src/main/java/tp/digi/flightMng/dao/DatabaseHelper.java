package tp.digi.flightMng.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseHelper {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager createEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("unit");
		}
		return entityManagerFactory.createEntityManager();
	}

	public static void commitTxAndClose(EntityManager entityManager) {
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void rollbackTxAndClose(EntityManager entityManager) {
		entityManager.getTransaction().rollback();
		entityManager.close();
	}

	public static void beginTx(EntityManager entityManager) {
		entityManager.getTransaction().begin();
	}
}
