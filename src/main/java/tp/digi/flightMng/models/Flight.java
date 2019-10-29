package tp.digi.flightMng.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Flight {
	
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * Number of the flight. Is specified by user input, must be composed 
	 * of 4 characters and must be unique.
	 */
	@Column(unique=true)
	private String number;
	
	/**
	 * List of reservations on this flight.
	 */
	@OneToMany(mappedBy="flight")
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	/**
	 * Maximum number of seats in the flight.
	 */
	@Column
	private Integer maxCapacity; 
	
	@Column
	@Enumerated(EnumType.STRING)
	private PlaneModel planeModel;
	
	/**
	 * Town of departure.
	 */
	@Column
	private String departureTown;
	
	/**
	 * Town of arrival.
	 */
	@Column
	private String destination;
	
	/**
	 * Date of departure
	 */
	@Column
	private LocalDate departureDate;
	
	public Flight() {
	}
	
	// ----------------------------- Getters & Setters -----------------------------

	public String getNumber() {
		return number;
	}

	/**
	 * Set this flight's number to 'number' if the new number is valid.
	 * Returns true if number has been set, false otherwise.
	 * To be valid, a number must have a length of exactly 4 characters.
	 * @param number
	 * @return
	 */
	public boolean setNumber(String number) {
		if (number.trim().length() == 4) {
			this.number = number;
			return true;
		}
		return false;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public PlaneModel getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(PlaneModel planeModel) {
		this.planeModel = planeModel;
	}

	public String getDepartureTown() {
		return departureTown;
	}

	public void setDepartureTown(String departureTown) {
		this.departureTown = departureTown;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public int getNumberOfReserv() {
		return reservations.size();
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String toString() {
		return "[FLIGHT(" + id + ")"
				+ "\n\tnumber=" + number
				+ "\n\tplaneModel=" + planeModel
				+ "\n\tmaxCapacity=" + maxCapacity
				+ "\n\tdepartureTown=" + departureTown
				+ "\n\tdestination=" + destination
				+ "\n\tdepartureDate=" + departureDate
				+ "\n\tnumberReserv=" + reservations.size() + "]";
	}
	
}
