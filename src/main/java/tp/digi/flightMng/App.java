package tp.digi.flightMng;

import java.util.Scanner;

import tp.digi.flightMng.ui.MenuLogics;

public class App {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MenuLogics.mainMenu(in);
		in.close();
		
	}
}
