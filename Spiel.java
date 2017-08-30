package nimmspiel;

import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 * Die Hauptklasse;
 * 
 * @author Bing und Josy
 */
public class Spiel {
	/**
	 * @param Index zaehlt, wie oft das Spiel gelaufen ist;
	 * @param anzahlSteine gibt an, wie viele Steine zu Beginn im Haufen liegen, wird auf zufaelligen Wert zwischen 20 und 30 gelegt;
	 * 
	 */
	private int index = 0;
	private int anzahlSteine = (int) (Math.random() * 11 + 20);
	private boolean menschFaengtAn;

	/**
	 * speichert die Anzahl der Steine im Haufen
	 * 
	 * @return anzahlSteine
	 */
	public int getAnzahlSteine() {
		return anzahlSteine;
	}

	/**
	 * ??
	 * @return
	 */
	public int getindex() {
		int anzahl = index;
		return anzahl;

	}
	/**
	 * prueft ob der Spieler oder der PC beginnt
	 * 
	 */
	public boolean getmenschFaengtAn() {
		return menschFaengtAn;
	}

	/**
	 * Diese Methode legt den ersten Spieler fest und gibt den aktuellen Spieler an;
	 * 
	 * @return Akueller Spieler;
	 */
	public String getaktuelleSpieler() {
		Spieler[] spieler = new Spieler[2];

		spieler[0] = new Spieler("Du");
		spieler[1] = new Spieler("Der Computer");

		/*
		 * hier wird der erste Spieler ermittelt
		 */
		if (index == 0) {
			if (Wuerfel.wuerfel() <= 3) {
				System.out.println(spieler[0].getName() + " (b)ist der erste Spieler");
				menschFaengtAn = true;
				return spieler[0].getName() + " (b)ist der erste Spieler";
			} else {
				System.out.println(spieler[1].getName() + " (b)ist der erste Spieler");
				
				int za =(int) (Wuerfel.wuerfel()+1)/2;
				anzahlSteine -= za;
				System.out.println("Der Computer hat " + za + " Stein(e) genommen, damit sind noch " + anzahlSteine
						+ " Steine im Haufen.");				
				return spieler[1].getName() + " (b)ist der erste Spieler";
			}
		}
		
		/*
		 * hier wird anhand des Index der aktuelle Spieler ausgegeben
		 */
		
		if (index % 2 == 0 && index != 0) {
			System.out.println(spieler[0].getName() + " (b)ist der aktuelle Spieler");
			return spieler[0].getName() + " (b)ist der aktuelle Spieler";

		}
		if (index % 2 == 1 && index != 0) {
			System.out.println(spieler[1].getName() + " (b)ist der aktuelle Spieler");
			return spieler[1].getName() + " (b)ist der aktuelle Spieler";
		}
		return null;
	};

	/**
	 * die Regeln des Spiel werden dargestellt;
	 */

	public void spielRegeln() {
		System.out.println(
				"Du und der Computer waehlen abwechselnd 1-3 Steine, die Sie vom Haufen nehmen. Wer den letzten Stein nimmt, hat verloren.\n");

	}

	/**
	 * Der Spieler soll eine Zahl(eins bis drei) eingeben.
	 * 
	 * @return Anzahl der genommenen Steine;
	 */

	public int steinNehmen() {
		if (index % 2 == 0) {

			/*
			 * 	Teil 1: stellt sicher, dass der Spieler genau 1-3 Steine nimmt
			 */
			
			try{
				if(anzahlSteine>3){
				
				System.out.println("Bitte gebe eine Zahl ein:");
				 Scanner input = new Scanner(System.in);
			      int anzahl = input.nextInt();
			      index+=1;
			  
			  if (anzahl < 1 || anzahl > 3 ) {
				anzahl = 0;
				System.out.println("Es gibt einen Fehler, bitte eine Zahl zwischen 1-3 eingeben:");
				System.out.println("Es sind noch " + anzahlSteine + " Steine im Haufen.");
				
			}else {
				anzahlSteine -=anzahl;
				System.out.println("Es sind noch " + anzahlSteine + " Steine im Haufen.");
			}
				}
			  

			else 
				if(anzahlSteine==2){
					
					System.out.println("Bitte gebe eine Zahl ein:");
					 Scanner input = new Scanner(System.in);
				      int anzahl = input.nextInt();
				       
				  if (anzahl < 1 || anzahl > 2 ) {
					anzahl = 0;
					System.out.println("Es gibt einen Fehler, bitte eine Zahl zwischen 1-2 eingeben:");
					System.out.println("Es sind noch " + anzahlSteine + " Steine im Haufen.");
					
				}else {
				   anzahlSteine-=anzahl;
				   index+=1;   
				}
				  return anzahl;
				  }
		else if(anzahlSteine==1){
						
						System.out.println("Bitte gebe eine Zahl ein:");
						 Scanner input = new Scanner(System.in);
						
						 int anzahl = input.nextInt();
					  
					  if (anzahl !=1 ) {
						anzahl = 0;
						System.out.println("Es gibt einen Fehler, es liegt nur noch 1 Stein im Haufen:");
						System.out.println("Es sind noch " + anzahlSteine + " Steine im Haufen.");
						
					}else{
					  anzahlSteine-=anzahl;
					  index+=1;
					}
					  return anzahl;
					  }		
				
				
				
				
			} catch (java.util.InputMismatchException e){
				System.out.println("Es gibt einen Fehler, bitte eine Zahl zwischen 1-3 eingeben:");
			}

		} 
		/*
		 * Teil 2: spezifiziert das taktische Verhalten des PCs;
		 */
		
		else {
			
			/*
			 * Teil 2.1 Verhalten fuer 1-4 Steine im Haufen
			 * diese methode setzt auch die anzahl steine fuer den menschen, das ist schlecht
			 */ 
			
			if (anzahlSteine == 4) {
				anzahlSteine -= 3;
				System.out.println(
						"Der Computer hat 3 Steine genommen, damit sind noch " + anzahlSteine + " Steine im Haufen \n");
				index+=1;
			}
			else if (anzahlSteine == 3) {
				anzahlSteine -= 2;
				System.out.println(
						"Der Computer hat 2 Steine genommen, damit sind noch " + anzahlSteine + " Steine im Haufen \n");
			index+=1;
			}
			else if (anzahlSteine == 2) {
				anzahlSteine -= 1;
				System.out.println(
						"Der Computer hat 3 Steine genommen, damit sind noch " + anzahlSteine + " im Haufen \n");
				index +=1;
			}

			else if (anzahlSteine == 1) {
				anzahlSteine -= 1;
				System.out.println("Der Computer hat 1 Stein genommen, der Haufen ist leer.");
				index+=1;
			}
			/*
			 * Teil 2.2: Verhalten fuer mehr als 4 Steine auf zuf. Wert zwischen 1-3 gesetzt
			 */
			else if (anzahlSteine > 4) {
				int za = 1 + (int) Math.random() * 3;
				anzahlSteine -= za;
				System.out.println("Der Computer hat " + za + " Stein(e) genommen, damit sind noch " + anzahlSteine
						+ " Steine im Haufen.");
				index += 1;
			}
			
		}
		return anzahlSteine;
	
	}	

}
