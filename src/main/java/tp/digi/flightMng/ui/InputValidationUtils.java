package tp.digi.flightMng.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import tp.digi.flightMng.models.PlaneModel;

public class InputValidationUtils {
	
	public static LocalDate validateDate(Scanner in) {
		LocalDate date;
		System.out.print("Entrez la date de départ (jj/mm/aaaa) ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while(true) {
			try {
				date = LocalDate.parse(in.next(), formatter);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Veuillez entrer une date valide au "
						+ "format jj/mm/aaaa !");
			}
		}
		return date;
	}

	public static Integer validatePositiveInteger(Scanner in) {
		Integer i = null;
		do {
			try {
				i = Integer.valueOf(in.nextLine());
				if (i<0) {
					System.out.println("Veuillez entrer un nombre entier positif !");
				}
			} catch (InputMismatchException e) {
				System.out.println("Veuillez entrer un nombre entier positif !");
			}
		} while (i == null || i < 0);
		return i;
	}

	public static PlaneModel validatePlaneModel(Scanner in) {
		PlaneModel p;
		String msg = "Entrez le modèle d'avion (";
		for (PlaneModel p2 : PlaneModel.values()) msg += p2 + " ";
		msg = msg.trim() + ") ";
		System.out.print(msg);
		while (true) {
			try {
				p = PlaneModel.valueOf(in.next().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Veuillez entrer un modèle"
						+ " d'avion présent dans la liste !");
			}
		}
		return p;
	}

	public static String validateFlightNumber(Scanner in) {
		System.out.print("Entrez le numéro de vol (4 caractères) : ");
		String input = in.nextLine().trim();
		while (input.length() != 4) {
			System.out.println("Numéro invalide !");
			System.out.print("Entrez le numéro de vol (4 caractères) : ");
			input = in.nextLine().trim();
		}
		return input;
	}
}
