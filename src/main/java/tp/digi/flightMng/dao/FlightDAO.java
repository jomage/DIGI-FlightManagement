package tp.digi.flightMng.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import tp.digi.flightMng.models.Flight;

public class FlightDAO extends GenericDAO<Flight> {

	public List<Flight> getAll() throws NoResultException {
		EntityManager em = DatabaseHelper.createEntityManager();
		String sql = "from Flight fl "
				+ "left join fetch fl.reservations";
		TypedQuery<Flight> q = em.createQuery(sql, Flight.class);
		List<Flight> f = q.getResultList();
		em.close();
		return f;
	}

	public Flight findByNumber(String flightNumber) throws NoResultException {
		EntityManager em = DatabaseHelper.createEntityManager();
		String sql = "from Flight fl "
				+ "left join fetch fl.reservations "
				+ "where fl.number = :number";
		TypedQuery<Flight> q = em.createQuery(sql, Flight.class);
		q.setParameter("number", flightNumber);
		Flight f = q.getSingleResult();
		em.close();
		return f;
	}

	public List<Flight> findByTowns(String departureTown, String destination)
			throws NoResultException {
		EntityManager em = DatabaseHelper.createEntityManager();
		String sql = "from Flight fl "
				+ "left join fetch fl.reservations "
				+ "where fl.departureTown = :depart "
				+ "and fl.destination = :dest";
		TypedQuery<Flight> q = em.createQuery(sql, Flight.class);
		q.setParameter("depart", departureTown);
		q.setParameter("dest", destination);
		List<Flight> f = q.getResultList();
		em.close();
		return f;
	}


}
