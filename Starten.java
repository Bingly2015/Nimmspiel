package nimmspiel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * zur besseren Uebersicht ausgelagerte Main-Methode;
 * 
 * @authors Bing und Josy
 *
 */

	

	public class Starten {

	/**
	 * das Spiel starten;
	 */
		
	
	public static void main(String[] args) {
		
		/*JFrame jf=new JFrame();
		 JLabel jl3=new JLabel("versuchen zu machen");
		JPanel jp1=new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.X_AXIS));
		jf.setSize(400, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(500, 200);
		//JPanel jp=new JPanel();
		JLabel jl=new JLabel("Rest Steine in Steinhaufen");
		 JLabel jl2=new JLabel("versuchte Mal");
		//jl.setBounds(20, 20, 100, 20);
		//jf.setLocationRelativeTo(jf);
		//jf.setLocation(20, 20);
		jf.add(jl);
		jf.add(jl2);*/
		
		
		Scanner neuesSpiel = new Scanner(System.in);
		while (true){
		Spiel spiel = new Spiel();

		System.out.println("Es wurden " + spiel.getAnzahlSteine() + " Steine fuer diese Runde festgelegt.");
		spiel.spielRegeln();
		
		/**
		 * @param getende setzt den Zustand des Spiels (Ende/ laufend)
		 */
		
		boolean getende = false;
		
		while (!getende) {

			spiel.getaktuelleSpieler();
			
			spiel.steinNehmen();
			
			if (spiel.getAnzahlSteine() <= 0) {
				getende = true;
				System.out.println("Das Spiel ist zu ende.");
				if (spiel.getmenschFaengtAn()) {
					if (spiel.getindex() % 2 == 0) {
						System.out.println("Du hast gewonnen.");
					} else {
						System.out.println("Du hast verloren.");
					}
				} else {
					if (spiel.getindex() % 2 == 0) {
						System.out.println("Du hast gewonnen.");
					} else {
						System.out.println("Du hast verloren.");
					}

				}

			}
		}
			   String weiter;
	            System.out.println("Neues Spiel? (ja/nein)");
	            weiter = neuesSpiel.nextLine();
	            while (!weiter.equals("ja") && !weiter.equals("nein")) {
	                System.out.println("Eingabe nicht korrekt.");
	                System.out.println("Neues Spiel? (ja/nein)");
	                weiter = neuesSpiel.nextLine();
	            }
	            if (weiter.equals("nein")) {
	                break;
					
			}
		}
	}
}
