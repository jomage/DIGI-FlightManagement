package tp.digi.flightMng.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * The flight that will be reserved. One reservation have One flight.
	 * One flight have Many reservations.
	 */
	@ManyToOne
	private Flight flight;
	
	/**
	 * Reservation number. Composed of Flight.number + " " + this.id
	 */
	@Column(unique=true)
	private String number;
	
	/**
	 * Last name of the person that made the reservation.
	 */
	@Column
	@NotBlank
	private String lastName;
	
	/**
	 * First name of the person that made the reservation.
	 */
	@Column
	@NotBlank
	private String firstName;
	
	/**
	 * Age of the person that made the reservation.
	 */
	@Column
	private Integer age;

	// ----------------------------- Getters & Setters -----------------------------

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}
	
	public String toString() {
		return "[RESERVATION(" + id + ")\n"
				+"number=" + number + " "
				+ "lastName=" + lastName + " "
				+ "firstName=" + firstName + " "
				+ "age=" + age + "]";
	}
}
