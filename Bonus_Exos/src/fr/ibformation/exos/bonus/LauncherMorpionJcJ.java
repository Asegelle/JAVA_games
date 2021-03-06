package fr.ibformation.exos.bonus;

//import java.util.Arrays;
import java.util.Scanner;

public class LauncherMorpionJcJ {


	public static String ORD_1 = "1", 
			ORD_2 = "2", 
			ORD_3 = "3";
	public static String ABS_A = "a",
			ABS_B = "b",
			ABS_C = "c";
	public static String P1_X = "x",
			P2_O = "o";
	public static String PLAYER1 = "J1",
			PLAYER2 = "J2";
	public static String[][] EMPTY = new String[][]{ {" "," "," "},{" "," "," "},{" "," "," "}};

	public static Scanner scanInput = new Scanner(System.in);

	public static String [][] m1, m2, m3, m4, m5, m6, m7;

	public static void main(String[] args) {
		
		
		/*
		?Morpion JcJ (notions de tableaux) :
		Coder un jeu de morpion standard o? 2 joueurs s'affrontent en pla?ant dans une grille les symboles X ou O.		
		 */		

		// variable de boucle pour relancer le jeu 
		boolean retry = true;
		System.out.println("Bienvenue dans le jeu du Morpion JcJ ! \n\nLe but du jeu est d?aligner avant son adversaire 3 symboles identiques horizontalement, verticalement ou en diagonale. Chaque joueur a donc son propre symbole, une croix pour le Joueur 1 et un rond pour le Joueur 2. La partie se termine quand l?un des 2 joueurs a aligner 3 symboles ou quand la grille est compl?t?e sans vainqueur. Il y a alors ?galit?. Que le meilleur gagne !\n");
		do {
			// d?claration des variables
			boolean isVictoryJ1 = false;
			boolean isVictoryJ2 = false;
			boolean isNull = false;

			// fonction pour affichage de la grille
			// attribution des variables (le tableau)
			m1 = Grid(EMPTY);					//m1 = tableau morpion initial avec 9 cases vides

			// interroger J1 sur case ? jouer
			String [] coordinatesJ1 = DisplayPlayer(PLAYER1);
			// determiner dans quelle case va le choix du joueur
			m2 = TurnPlayer1 (m1, coordinatesJ1);
			// renvoyer le tableau ? afficher
			m3 = Grid(m2);

			// entr?e de boucle pour r?p?tition
			do {
				// interroger J2 sur case ? jouer
				String [] coordinatesJ2 = DisplayPlayer(PLAYER2);
				// comparer aux cases precedemment jou?es et re-interroge si d?j? prise
				String [] coordinatesJ2v2 = LockCase (m3 , coordinatesJ2, PLAYER2);
				// determiner dans quelle case va le choix du joueur
				m4 = TurnPlayer2 (m3, coordinatesJ2v2);
				// renvoyer le tableau ? afficher
				m5 = Grid(m4);
				// conditions de victoire J2
				isVictoryJ2 = Victory (
						m5, isVictoryJ2, PLAYER2);
				// conditions d'?galit?
				isNull = Null (
						m5, isVictoryJ2);

				if (!isVictoryJ2 && !isNull) {
					// interroger J1 sur case ? jouer
					coordinatesJ1 = DisplayPlayer(PLAYER1);
					// comparer aux cases precedemment jou?es et re-interroge si d?j? prise
					String [] coordinatesJ1v2 = LockCase (m4, coordinatesJ1, PLAYER1);
					System.out.println("abs : "+coordinatesJ1v2[0]);
					System.out.println("abs : "+coordinatesJ1v2[1]);

					// determiner dans quelle case va le choix du joueur
					m6 = TurnPlayer1 (m4, coordinatesJ1v2);
					// renvoyer le tableau ? afficher
					m7 = Grid(m6);
					// conditions de victoire J2
					isVictoryJ1 = Victory (m7, isVictoryJ1, PLAYER1);
					// conditions d'?galit?
					isNull = Null (m7, isVictoryJ1);
				}
			}
			// fin boucle de r?p?tition
			// d?finition des conditions de sortie de boucle 
			while (!isVictoryJ1 && !isVictoryJ2 && !isNull);

			// relancer une partie
			System.out.println("\nvoulez vous rejouer ? (true/false)");
			Scanner scanRetry = new Scanner(System.in);
			retry = scanRetry.nextBoolean();
			if (retry == true) {
				System.out.println("bienvenue dans une nouvelle partie de Morpion JcJ ! \n");
				String[][] reset = new String[][]{ {" "," "," "},{" "," "," "},{" "," "," "}};
				EMPTY = reset;
			}
			else if (retry == false){
				System.out.println("A bient?t pour une nouvelle partie !");
				retry=false;
				scanRetry.close();}
		}
		while (retry);
	}





	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction affichage grille --------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] Grid(
			String [][]gride) {

		System.out.println("   "+ABS_A+"  "+ABS_B+"  "+ABS_C+" ");		
		System.out.println(ORD_1+" ["+gride [0][0]+"]["+gride [0][1]+"]["+gride [0][2]+"]  Joueur 1 : "+P1_X);		
		System.out.println(ORD_2+" ["+gride [1][0]+"]["+gride [1][1]+"]["+gride [1][2]+"]  Joueur 2 : "+P2_O);		
		System.out.println(ORD_3+" ["+gride [2][0]+"]["+gride [2][1]+"]["+gride [2][2]+"]");	

		return gride; 
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction interroger Joueur sur case ? jouer --------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] DisplayPlayer(
			String player) {	

		System.out.println("\nau tour du Joueur "+player+" : ");
		System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
		String []coordinates = new String [2];
		coordinates[0] = scanInput.nextLine();
		while (!coordinates[0].equals(ABS_A) && !coordinates[0].equals(ABS_B) &&!coordinates[0].equals(ABS_C)) {
			System.out.println("erreur dans la saisie");
			System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
			coordinates[0] = scanInput.nextLine();		
		}
		System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
		coordinates[1] = scanInput.nextLine();
		while (!coordinates[1].equals(ORD_1) && !coordinates[1].equals(ORD_2) &&!coordinates[1].equals(ORD_3)) {
			System.out.println("erreur dans la saisie");
			System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
			coordinates[1] = scanInput.nextLine();		
		}
		System.out.println("abscisse "+player+" : "+coordinates[0]+" et ordonn?e "+player+" : "+coordinates[1]);

		return coordinates;
	}

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction prise en compte choix joueur --------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	// --------------------- fonction prise en compte choix joueur J1 -----------------------------------------

	public static String[][] TurnPlayer1(
			String [][]gride, 
			String[] coordinateJ1) {

		System.out.println(	"before turnplayer abs "+coordinateJ1[0]);
		System.out.println(	"before turnplayer ord "+coordinateJ1[1]);

		if (coordinateJ1[0].equals(ABS_A) && coordinateJ1[1].equals(ORD_1) && !gride[0][0].equals(P1_X)&& !gride[0][0].equals(P2_O)) {
			gride[0][0]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_B) && coordinateJ1[1].equals(ORD_1) && !gride[0][1].equals(P1_X)&& !gride[0][1].equals(P2_O)) 
		{
			gride[0][1]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_C) && coordinateJ1[1].equals(ORD_1) && !gride[0][2].equals(P1_X)&& !gride[0][2].equals(P2_O)) {
			gride[0][2]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_A) && coordinateJ1[1].equals(ORD_2) && !gride[1][0].equals(P1_X)&& !gride[1][0].equals(P2_O)) {
			gride[1][0]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_B) && coordinateJ1[1].equals(ORD_2) && !gride[1][1].equals(P1_X)&& !gride[1][1].equals(P2_O)) {
			gride[1][1]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_C) && coordinateJ1[1].equals(ORD_2) && !gride[1][2].equals(P1_X)&& !gride[1][2].equals(P2_O)) {
			gride[1][2]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_A) && coordinateJ1[1].equals(ORD_3) && !gride[2][0].equals(P1_X)&& !gride[2][0].equals(P2_O)) {
			gride[2][0]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_B) && coordinateJ1[1].equals(ORD_3) && !gride[2][1].equals(P1_X)&& !gride[2][1].equals(P2_O)) {
			gride[2][1]=P1_X;
		}
		else if (coordinateJ1[0].equals(ABS_C) && coordinateJ1[1].equals(ORD_3) && !gride[2][2].equals(P1_X)&& !gride[2][2].equals(P2_O)) {
			gride[2][2]=P1_X;
		}
		/*		else {
			System.out.println("erreur dans la saisie");	
		}*/

		return gride;
	}	

	// --------------------- fonction prise en compte choix joueur J1 -----------------------------------------

	public static String[][] TurnPlayer2(
			String [][]gride, 
			String[] coordinateJ2) {

		if (coordinateJ2[0].equals(ABS_A) && coordinateJ2[1].equals(ORD_1) && !gride[0][0].equals(P1_X)&& !gride[0][0].equals(P2_O)) {
			gride[0][0]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_B) && coordinateJ2[1].equals(ORD_1) && !gride[0][1].equals(P1_X)&& !gride[0][1].equals(P2_O)) {
			gride[0][1]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_C) && coordinateJ2[1].equals(ORD_1) && !gride[0][2].equals(P1_X)&& !gride[0][2].equals(P2_O)) {
			gride[0][2]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_A) && coordinateJ2[1].equals(ORD_2) && !gride[1][0].equals(P1_X)&& !gride[1][0].equals(P2_O)) {
			gride[1][0]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_B) && coordinateJ2[1].equals(ORD_2) && !gride[1][1].equals(P1_X)&& !gride[1][1].equals(P2_O)) {
			gride[1][1]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_C) && coordinateJ2[1].equals(ORD_2) && !gride[1][2].equals(P1_X)&& !gride[1][2].equals(P2_O)) {
			gride[1][2]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_A) && coordinateJ2[1].equals(ORD_3) && !gride[2][0].equals(P1_X)&& !gride[2][0].equals(P2_O)) {
			gride[2][0]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_B) && coordinateJ2[1].equals(ORD_3) && !gride[2][1].equals(P1_X)&& !gride[2][1].equals(P2_O)) {
			gride[2][1]=P2_O;
		}
		else if (coordinateJ2[0].equals(ABS_C) && coordinateJ2[1].equals(ORD_3) && !gride[2][2].equals(P1_X)&& !gride[2][2].equals(P2_O)) {
			gride[2][2]=P2_O;
		}
		/*		else {
			System.out.println("erreur dans la saisie");	
		}*/

		return gride;
	}	


	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction v?rouiller case jou?e ---------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] LockCase (
			String [][]gride, 
			String[] coordinates, 
			String player) {
		while	(
				(coordinates[0].equals(ABS_A) && coordinates[1].equals(ORD_1) && (gride[0][0].equals(P1_X) || gride[0][0].equals(P2_O))) || 
				(coordinates[0].equals(ABS_B) && coordinates[1].equals(ORD_1) && (gride[0][1].equals(P1_X) || gride[0][1].equals(P2_O))) || 
				(coordinates[0].equals(ABS_C) && coordinates[1].equals(ORD_1) && (gride[0][2].equals(P1_X) || gride[0][2].equals(P2_O))) || 
				(coordinates[0].equals(ABS_A) && coordinates[1].equals(ORD_2) && (gride[1][0].equals(P1_X) || gride[1][0].equals(P2_O))) || 
				(coordinates[0].equals(ABS_B) && coordinates[1].equals(ORD_2) && (gride[1][1].equals(P1_X) || gride[1][1].equals(P2_O))) || 
				(coordinates[0].equals(ABS_C) && coordinates[1].equals(ORD_2) && (gride[1][2].equals(P1_X) || gride[1][2].equals(P2_O))) || 
				(coordinates[0].equals(ABS_A) && coordinates[1].equals(ORD_3) && (gride[2][0].equals(P1_X) || gride[2][0].equals(P2_O))) || 
				(coordinates[0].equals(ABS_B) && coordinates[1].equals(ORD_3) && (gride[2][1].equals(P1_X) || gride[2][1].equals(P2_O))) || 
				(coordinates[0].equals(ABS_C) && coordinates[1].equals(ORD_3) && (gride[2][2].equals(P1_X) || gride[2][2].equals(P2_O)))) {			
			System.out.println("cette case a d?j? ?t? s?lectionn?e !");
			System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
			//	String []coordinates = new String [2];
			coordinates[0] = scanInput.nextLine();
			while (!coordinates[0].equals(ABS_A) && !coordinates[0].equals(ABS_B) &&!coordinates[0].equals(ABS_C)) {
				System.out.println("erreur dans la saisie");
				System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
				coordinates[0] = scanInput.nextLine();		
			}
			System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
			coordinates[1] = scanInput.nextLine();
			while (!coordinates[1].equals(ORD_1) && !coordinates[1].equals(ORD_2) &&!coordinates[1].equals(ORD_3)) {
				System.out.println("erreur dans la saisie");
				System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
				coordinates[1] = scanInput.nextLine();		
			}
			System.out.println("abscisse "+player+" : "+coordinates[0]+" et ordonn?e "+player+" : "+coordinates[1]);
		}
		return (coordinates);
	}

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction conditions de victoire --------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static boolean Victory (
			String [][]gride, 
			boolean isVictory,
			String player) {

		if	(
				(
						(gride[0][0].equals(P2_O) && gride[0][1].equals(P2_O) && gride[0][2].equals(P2_O)) ||
						(gride[1][0].equals(P2_O) && gride[1][1].equals(P2_O) && gride[1][2].equals(P2_O)) ||
						(gride[2][0].equals(P2_O) && gride[2][1].equals(P2_O) && gride[2][2].equals(P2_O)) ||
						(gride[0][0].equals(P2_O) && gride[1][0].equals(P2_O) && gride[2][0].equals(P2_O)) ||
						(gride[0][1].equals(P2_O) && gride[1][1].equals(P2_O) && gride[2][1].equals(P2_O)) ||
						(gride[0][2].equals(P2_O) && gride[1][2].equals(P2_O) && gride[2][2].equals(P2_O)) ||
						(gride[0][0].equals(P2_O) && gride[1][1].equals(P2_O) && gride[2][2].equals(P2_O))) || 
				(		
						(gride[0][0].equals(P1_X) && gride[0][1].equals(P1_X) && gride[0][2].equals(P1_X)) ||
						(gride[1][0].equals(P1_X) && gride[1][1].equals(P1_X) && gride[1][2].equals(P1_X)) ||
						(gride[2][0].equals(P1_X) && gride[2][1].equals(P1_X) && gride[2][2].equals(P1_X)) ||
						(gride[0][0].equals(P1_X) && gride[1][0].equals(P1_X) && gride[2][0].equals(P1_X)) ||
						(gride[0][1].equals(P1_X) && gride[1][1].equals(P1_X) && gride[2][1].equals(P1_X)) ||
						(gride[0][2].equals(P1_X) && gride[1][2].equals(P1_X) && gride[2][2].equals(P1_X)) ||
						(gride[0][0].equals(P1_X) && gride[1][1].equals(P1_X) && gride[2][2].equals(P1_X)))) {
			System.out.println("\nvictoire du joueur "+player+" !");
			isVictory = true;
		}

		return isVictory;
	}

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction conditions match nul --------------------------------------------------
	//---------------------------------------------------------------------------------------------------------		

	public static boolean Null (
			String [][]gride, 
			boolean isNull) {

		if	(
				(gride[0][0].equals(P2_O) || gride[0][0].equals(P1_X)) && 
				(gride[0][1].equals(P2_O) || gride[0][1].equals(P1_X)) && 
				(gride[0][2].equals(P2_O) || gride[0][2].equals(P1_X)) && 
				(gride[1][0].equals(P2_O) || gride[1][0].equals(P1_X)) && 
				(gride[1][1].equals(P2_O) || gride[1][1].equals(P1_X)) && 
				(gride[1][2].equals(P2_O) || gride[1][2].equals(P1_X)) && 
				(gride[2][0].equals(P2_O) || gride[2][0].equals(P1_X)) && 
				(gride[2][1].equals(P2_O) || gride[2][1].equals(P1_X)) && 
				(gride[2][2].equals(P2_O) || gride[2][2].equals(P1_X))) {
			System.out.println("\n?galit? !");
			isNull = true;	
		}
		return isNull;
	}


}

