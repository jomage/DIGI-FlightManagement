package tp.digi.flightMng.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import tp.digi.flightMng.dao.FlightDAO;
import tp.digi.flightMng.dao.ReservationDAO;
import tp.digi.flightMng.models.Flight;
import tp.digi.flightMng.models.Reservation;

public class MenuLogics {
	
	private static void printStartMessage() {
		printSeparator();
		System.out.println("Bienvenue dans l'application de Gestion de Vols.");
		printSeparator();
	}
	
	public static void mainMenu(Scanner in) {
		printStartMessage();
		while (true) {
			System.out.println("\nMenu principal :");
			printSeparator();
			System.out.println("1) Gestion des vols\n"
					+ "2) Gestion des r�servations\n"
					+ "q) Quitter");
			System.out.println("Entrez votre choix (1 / 2 / q) :");
			if (in.hasNext()) {
				switch (in.next().charAt(0)) {
				case '1': flightMngMenu(in); break;
				case '2': reservMngMenu(in); break;
				case 'q':
				case 'Q':
				case '3': return;
				default:
				}
			}
		}
	}
	
	private static void printSeparator() {
		System.out.println("=================================================");
	}

	private static void flightMngMenu(Scanner in) {
		while (true) {
			System.out.println("\nGestion des vols");
			printSeparator();
			System.out.println("1) Cr�er un vol\n"
					+ "2) Liste des vols\n"
					+ "3) Rechercher un vol par num�ro\n"
					+ "4) Rechercher un avion par villes d�part & arriv�e\n"
					+ "q) Retour au menu principal");
			System.out.println("Entrez votre choix (1 / 2 / 3 / 4 / q) :");
			if (in.hasNext()) {
				switch (in.next().charAt(0)) {
				case '1':
					createFlightMenu(in);
					break;
				case '2':
					viewFlightsMenu();
					break;
				case '3':
					searchFlightByNumberMenu(in);
					break;
				case '4':
					searchFlightsByTownsMenu(in);
					break;
				case '5':
				case 'q':
				case 'Q':
					return;
				default:
				}
			}
		}
	}

	private static void searchFlightsByTownsMenu(Scanner in) {
		System.out.println("\nRecherche par ville de d�part et ville d'arriv�e :");
		printSeparator();
		in.nextLine();
		System.out.print("Veuillez entrer une ville de d�part : ");
		String departureTown = in.nextLine();
		System.out.print("Veuillez entrer une ville d'arriv�e : ");
		String destination = in.nextLine();
		FlightDAO fdao = new FlightDAO();
		
		try {
			printFlightsAsTable(fdao.findByTowns(departureTown, destination));
		} catch (NoResultException e) {
			System.out.println("Aucun vol trouv� avec ces villes.");
		}
		
	}

	private static void searchFlightByNumberMenu(Scanner in) {
		System.out.println("\nRecherche par num�ro de vol :");
		printSeparator();
		System.out.print("Veuillez entrer un num�ro de vol "
				+ "(4 caract�res) :");
		FlightDAO fdao = new FlightDAO();
		try {
			Flight f = fdao.findByNumber(InputValidationUtils.validateFlightNumber(in));
			System.out.println(f);
		} catch (NoResultException e) {
			System.out.println("Aucun vol trouv� avec ce num�ro.");
		}
	}

	private static void viewFlightsMenu() {
		System.out.println("\nAffichage des vols :");
		printSeparator();
		FlightDAO fdao = new FlightDAO();
		printFlightsAsTable(fdao.getAll());
	}

	private static void printFlightsAsTable(List<Flight> flights) {
		
		System.out.println(StringUtils.normalizeLength("Num�ro") + "|"
				+ StringUtils.normalizeLength("Mod�le") + "|"
				+ StringUtils.normalizeLength("Places") + "|"
				+ StringUtils.normalizeLength("D�part") + "|"
				+ StringUtils.normalizeLength("Arriv�e") + "|"
				+ StringUtils.normalizeLength("Date") + "|");
		for(Flight f : flights) {
			System.out.print(StringUtils.normalizeLength(f.getNumber()) + "|");
			System.out.print(StringUtils.normalizeLength(f.getPlaneModel()) + "|");
			System.out.print(StringUtils.normalizeLength(f.getNumberOfReserv() + "/"
					+ f.getMaxCapacity()) + "|");
			System.out.print(StringUtils.normalizeLength(f.getDepartureTown()) + "|");
			System.out.print(StringUtils.normalizeLength(f.getDestination()) + "|");
			System.out.println(StringUtils.normalizeLength(f.getDepartureDate()));
		}
	}

	private static void createFlightMenu(Scanner in) {
		System.out.println("\nCr�ation d'un vol : ");
		printSeparator();
		Flight f = new Flight();
		in.nextLine();
		// Number
		f.setNumber(InputValidationUtils.validateFlightNumber(in));
		
		// Plane Model
		f.setPlaneModel(InputValidationUtils.validatePlaneModel(in));
		
		// Max Capacity
		System.out.print("Entrez le nombre max de places : ");
		f.setMaxCapacity(InputValidationUtils.validatePositiveInteger(in));
		
		// Departure Town
		System.out.print("Entrez la ville de d�part : ");
		f.setDepartureTown(in.nextLine());
		
		// Arrival Town
		System.out.print("Entrez la ville d'arriv�e : ");
		f.setDestination(in.nextLine());
		
		// Departure Date
		f.setDepartureDate(InputValidationUtils.validateDate(in));
		
		FlightDAO fdao = new FlightDAO();
		fdao.persist(f);
	}

	private static void reservMngMenu(Scanner in) {
		while (true) {
			System.out.println("\nGestion des R�servations");
			printSeparator();
			System.out.println("1) Cr�er une r�servation\n"
					+ "2) Voir les r�servations d'un vol\n"
					+ "3) Annuler une r�servation\n"
					+ "4) Voir toutes les r�servations d�une personne\n"
					+ "q) Retour au menu principal");
			System.out.println("Entrez votre choix (1 / 2 / 3 / 4 / q) :");
			if (in.hasNext()) {
				switch (in.next().charAt(0)) {
				case '1':
					createReservMenu(in);
					break;
				case '2':
					System.out.println("Voir r�servation : Pas encore impl�ment�.");
					break;
				case '3':
					System.out.println("Annuler r�servation : Pas encore impl�ment�.");
					break;
				case '4':
					System.out.println("Voir toutes les r�servations : Pas encore impl�ment�.");
					break;
				case '5':
				case 'q':
				case 'Q':
					return;
				default:
				}
			}
		}
	}

	private static void createReservMenu(Scanner in) {
		System.out.println("\nCr�ation d'une R�servation");
		printSeparator();

		FlightDAO fdao = new FlightDAO();
		ReservationDAO rdao = new ReservationDAO();
		// We verify that there is at least 1 flight available for reservation.
		try { 
			fdao.getAll();
		} catch (NoResultException e) {
			System.out.println("Auncun vol disponible � la r�servation.");
			return;
		}
		
		Reservation r = new Reservation();
		in.nextLine();
		
		// Flight that will be reserved
		System.out.print("Veuillez entrer le num�ro de vol � r�server : ");
		Flight f = null;
		do {
			try {
				f = fdao.findByNumber(InputValidationUtils.validateFlightNumber(in));
			} catch (NoResultException e) {
				System.out.println("Aucun vol trouv� avec ce num�ro.");
			}
		} while(f == null);
		r.setFlight(f);
		
		// Last name
		System.out.print("Veuillez entrer le nom de famille : ");
		r.setLastName(in.nextLine());
		
		// First name
		System.out.print("Veuillez entrer le pr�nom : ");
		r.setFirstName(in.nextLine());
		
		// Age
		System.out.print("Veuillez entrer l'age : ");
		r.setAge(InputValidationUtils.validatePositiveInteger(in));

		rdao.persist(r);
	}
}
