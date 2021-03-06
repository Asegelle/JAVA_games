package fr.ibformation.exos.bonus;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LauncherMorpionIA {

	public static final String ORD_1 = "1", 
			ORD_2 = "2", 
			ORD_3 = "3";
	public static final String ABS_A = "a",
			ABS_B = "b",
			ABS_C = "c";
	public static final String P1_X = "x",
			P2_O = "o";
	public static final String PLAYER1 = "J1",
			PLAYER2 = "IA";
	public static String[][] empty = new String[][]{ {" "," "," "},{" "," "," "},{" "," "," "}};

	public static Scanner scanInput = new Scanner(System.in);

	public static String [][] m1, m2, m3, m4, m5, m6, m7;

	public static void main(String[] args) {


		/*
		?Morpion IA (notions de tableaux) :
		Coder un jeu de morpion standard o? 2 joueurs s'affrontent en pla?ant dans une grille les symboles X ou O.		
		 */		

		// variable de boucle pour relancer le jeu 
		boolean retry = true;
		System.out.println("Bienvenue dans le jeu du Morpion vs IA ! \n\nLe but du jeu est d?aligner avant son adversaire 3 symboles identiques horizontalement, verticalement ou en diagonale. Chaque joueur a donc son propre symbole, une croix pour le Joueur 1 et un rond pour le Joueur 2. La partie se termine quand l?un des 2 joueurs a aligner 3 symboles ou quand la grille est compl?t?e sans vainqueur. Il y a alors ?galit?. Que le meilleur gagne !\n");
		do {
			// d?claration des variables
			boolean isVictoryJ1 = false;
			boolean isVictoryIA = false;
			boolean isNull = false;

			// d?termination du joueur qui commence
			int firstPlayer = firstPlayer();
			// fonction pour affichage de la grille
			m1 = Grid(empty);					//m1 = tableau morpion initial avec 9 cases vides

			// si J1 commence (random =0)
			if (firstPlayer==0) {
				// interroger J1 sur case ? jouer
				String [] coordinatesJ1 = DisplayPlayerJ1(PLAYER1);
				// determiner dans quelle case va le choix du joueur
				m2 = TurnPlayer1 (m1, coordinatesJ1);
				// renvoyer le tableau ? afficher
				m3 = Grid(m2);
			}
			// si IA commence (random =1)
			else if(firstPlayer==1){
				// interroger J1 sur case ? jouer
				String [] coordinatesIA = DisplayPlayerRandom(PLAYER2);
				// determiner dans quelle case va le choix du joueur
				m2 = TurnPlayerIA (m1, coordinatesIA);
				// renvoyer le tableau ? afficher
				m3 = Grid(m2);
			}

			// entr?e de boucle pour r?p?tition
			do {
				if (firstPlayer==0) {
					// interroger IA sur case ? jouer
					String []coordinatesIA = DisplayPlayerRandom(PLAYER2);
					// comparer aux cases precedemment jou?es et re-interroge si d?j? prise
					String [] coordinatesIAv2 = LockCaseIA (m3 , coordinatesIA, PLAYER2);
					// determiner dans quelle case va le choix du joueur
					m4 = TurnPlayerIA (m3, coordinatesIAv2);
					// renvoyer le tableau ? afficher
					m5 = Grid(m4);
					// conditions de victoire IA
					isVictoryIA = Victory (m5, isVictoryIA, PLAYER2);
					// conditions d'?galit?
					isNull = Null (m5, isVictoryIA);
				}
				if (!isVictoryIA && !isNull) {
					if (firstPlayer==1) {
						m4 = m3;
					}
					firstPlayer=0;
					// interroger J1 sur case ? jouer
					String[]coordinatesJ1 = DisplayPlayerJ1(PLAYER1);
					// comparer aux cases precedemment jou?es et re-interroge si d?j? prise
					String [] coordinatesJ1v2 = LockCaseJ1 (m4, coordinatesJ1, PLAYER1);
					// determiner dans quelle case va le choix du joueur
					m6 = TurnPlayer1 (m4, coordinatesJ1v2);
					// renvoyer le tableau ? afficher
					m7 = Grid(m6);
					// conditions de victoire J1
					isVictoryJ1 = Victory (m7, isVictoryJ1, PLAYER1);
					// conditions d'?galit?
					isNull = Null (m7, isVictoryJ1);
				}
			}
			// fin boucle de r?p?tition
			// d?finition des conditions de sortie de boucle 
			while (!isVictoryJ1 && !isVictoryIA && !isNull);

			// relancer une partie
			Scanner scanRetry = new Scanner(System.in);
					try {
			System.out.println("\nvoulez vous rejouer ? (true/false)");
			retry = scanRetry.nextBoolean();
					}
					catch (InputMismatchException e) {			
						e.printStackTrace();
						System.out.println("erreur de saisie dans la relance du jeu !");
						retry = false;
					}
			if (retry == true) {
				System.out.println("bienvenue dans une nouvelle partie de Morpion JcJ ! \n");
				// reset tu tableau initial
				String[][] reset = new String[][]{ {" "," "," "},{" "," "," "},{" "," "," "}};
				empty = reset;
			}
			else {
				System.out.println("A bient?t pour une nouvelle partie !");
				retry=false;
				scanRetry.close();}
		}
		while (retry);
	}


	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction random pour joueur qui commence -----------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static int firstPlayer () {
		Random random = new Random();
		int firstPlayer = random.nextInt((1-0)+1);
		//	System.out.println(firstPlayer);
		return firstPlayer;
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
	// --------------------- fonction case random de l'IA -----------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] DisplayPlayerRandom(
			String player) {	

		Random random = new Random();
		int absIA = random.nextInt((3-1)+1);
		int ordIA = random.nextInt((3-1)+1);
		String []coordinates = new String [2];

		System.out.println("\nau tour du Joueur "+player+" : ");

		if (absIA==0) {
			coordinates[0]=ABS_A;
		}
		else if (absIA==1) {
			coordinates[0]=ABS_B;
		}
		else if (absIA==2) {
			coordinates[0]=ABS_C;
		}
		//	System.out.println(coordinates[0]);
		if (ordIA==0) {
			coordinates[1]=ORD_1;
		}
		else if (ordIA==1) {
			coordinates[1]=ORD_2;
		}
		else if (ordIA==2) {
			coordinates[1]=ORD_3;
		}
		//	System.out.println(coordinates[1]);

		System.out.println("abscisse "+player+" : "+coordinates[0]+" et ordonn?e "+player+" : "+coordinates[1]);

		return coordinates;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction interroger Joueur J1 sur case ? jouer -----------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] DisplayPlayerJ1(
			String player) {	

		System.out.println("\nau tour du Joueur "+player+" : ");
		System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
		String []coordinates = new String [2];
		coordinates[0] = scanInput.nextLine();
		while (!coordinates[0].equalsIgnoreCase(ABS_A) && !coordinates[0].equalsIgnoreCase(ABS_B) &&!coordinates[0].equalsIgnoreCase(ABS_C)) {
			System.out.println("erreur dans la saisie");
			System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
			coordinates[0] = scanInput.nextLine();		
		}
		System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
		coordinates[1] = scanInput.nextLine();
		while (!coordinates[1].equalsIgnoreCase(ORD_1) && !coordinates[1].equalsIgnoreCase(ORD_2) &&!coordinates[1].equalsIgnoreCase(ORD_3)) {
			System.out.println("erreur dans la saisie");
			System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
			coordinates[1] = scanInput.nextLine();		
		}
		System.out.println("abscisse "+player+" : "+coordinates[0]+" et ordonn?e "+player+" : "+coordinates[1]);

		return coordinates;
	}

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction prise en compte choix joueur J1 -----------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] TurnPlayer1(
			String [][]gride, 
			String[] coordinateJ1) {

		if (coordinateJ1[0].equalsIgnoreCase(ABS_A) && coordinateJ1[1].equalsIgnoreCase(ORD_1) && !gride[0][0].equalsIgnoreCase(P1_X)&& !gride[0][0].equalsIgnoreCase(P2_O)) {
			gride[0][0]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_B) && coordinateJ1[1].equalsIgnoreCase(ORD_1) && !gride[0][1].equalsIgnoreCase(P1_X)&& !gride[0][1].equalsIgnoreCase(P2_O)) 
		{
			gride[0][1]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_C) && coordinateJ1[1].equalsIgnoreCase(ORD_1) && !gride[0][2].equalsIgnoreCase(P1_X)&& !gride[0][2].equalsIgnoreCase(P2_O)) {
			gride[0][2]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_A) && coordinateJ1[1].equalsIgnoreCase(ORD_2) && !gride[1][0].equalsIgnoreCase(P1_X)&& !gride[1][0].equalsIgnoreCase(P2_O)) {
			gride[1][0]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_B) && coordinateJ1[1].equalsIgnoreCase(ORD_2) && !gride[1][1].equalsIgnoreCase(P1_X)&& !gride[1][1].equalsIgnoreCase(P2_O)) {
			gride[1][1]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_C) && coordinateJ1[1].equalsIgnoreCase(ORD_2) && !gride[1][2].equalsIgnoreCase(P1_X)&& !gride[1][2].equalsIgnoreCase(P2_O)) {
			gride[1][2]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_A) && coordinateJ1[1].equalsIgnoreCase(ORD_3) && !gride[2][0].equalsIgnoreCase(P1_X)&& !gride[2][0].equalsIgnoreCase(P2_O)) {
			gride[2][0]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_B) && coordinateJ1[1].equalsIgnoreCase(ORD_3) && !gride[2][1].equalsIgnoreCase(P1_X)&& !gride[2][1].equalsIgnoreCase(P2_O)) {
			gride[2][1]=P1_X;
		}
		else if (coordinateJ1[0].equalsIgnoreCase(ABS_C) && coordinateJ1[1].equalsIgnoreCase(ORD_3) && !gride[2][2].equalsIgnoreCase(P1_X)&& !gride[2][2].equalsIgnoreCase(P2_O)) {
			gride[2][2]=P1_X;
		}
		/*		else {
			System.out.println("erreur dans la saisie");	
		}*/

		return gride;
	}	

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction prise en compte choix joueur IA -----------------------------------------
	//---------------------------------------------------------------------------------------------------------	
	public static String[][] TurnPlayerIA(
			String [][]gride, 
			String[] coordinateIA) {

		if (coordinateIA[0].equalsIgnoreCase(ABS_A) && coordinateIA[1].equalsIgnoreCase(ORD_1) && !gride[0][0].equalsIgnoreCase(P1_X)&& !gride[0][0].equalsIgnoreCase(P2_O)) {
			gride[0][0]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_B) && coordinateIA[1].equalsIgnoreCase(ORD_1) && !gride[0][1].equalsIgnoreCase(P1_X)&& !gride[0][1].equalsIgnoreCase(P2_O)) {
			gride[0][1]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_C) && coordinateIA[1].equalsIgnoreCase(ORD_1) && !gride[0][2].equalsIgnoreCase(P1_X)&& !gride[0][2].equalsIgnoreCase(P2_O)) {
			gride[0][2]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_A) && coordinateIA[1].equalsIgnoreCase(ORD_2) && !gride[1][0].equalsIgnoreCase(P1_X)&& !gride[1][0].equalsIgnoreCase(P2_O)) {
			gride[1][0]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_B) && coordinateIA[1].equalsIgnoreCase(ORD_2) && !gride[1][1].equalsIgnoreCase(P1_X)&& !gride[1][1].equalsIgnoreCase(P2_O)) {
			gride[1][1]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_C) && coordinateIA[1].equalsIgnoreCase(ORD_2) && !gride[1][2].equalsIgnoreCase(P1_X)&& !gride[1][2].equalsIgnoreCase(P2_O)) {
			gride[1][2]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_A) && coordinateIA[1].equalsIgnoreCase(ORD_3) && !gride[2][0].equalsIgnoreCase(P1_X)&& !gride[2][0].equalsIgnoreCase(P2_O)) {
			gride[2][0]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_B) && coordinateIA[1].equalsIgnoreCase(ORD_3) && !gride[2][1].equalsIgnoreCase(P1_X)&& !gride[2][1].equalsIgnoreCase(P2_O)) {
			gride[2][1]=P2_O;
		}
		else if (coordinateIA[0].equalsIgnoreCase(ABS_C) && coordinateIA[1].equalsIgnoreCase(ORD_3) && !gride[2][2].equalsIgnoreCase(P1_X)&& !gride[2][2].equalsIgnoreCase(P2_O)) {
			gride[2][2]=P2_O;
		}
		/*		else {
			System.out.println("erreur dans la saisie");	
		}*/

		return gride;
	}	

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction v?rouiller case jou?e pour joueur IA ------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] LockCaseIA (
			String [][]gride, 
			String[] coordinates, 
			String player) {
		while	(
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][0].equalsIgnoreCase(P1_X) || gride[0][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][1].equalsIgnoreCase(P1_X) || gride[0][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][2].equalsIgnoreCase(P1_X) || gride[0][2].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][0].equalsIgnoreCase(P1_X) || gride[1][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][1].equalsIgnoreCase(P1_X) || gride[1][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][2].equalsIgnoreCase(P1_X) || gride[1][2].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][0].equalsIgnoreCase(P1_X) || gride[2][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][1].equalsIgnoreCase(P1_X) || gride[2][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][2].equalsIgnoreCase(P1_X) || gride[2][2].equalsIgnoreCase(P2_O)))) {			
			Random random = new Random();
			int absIA = random.nextInt((3-1)+1);
			int ordIA = random.nextInt((3-1)+1);
			System.out.println(absIA);
			System.out.println(ordIA);

			System.out.println("\nau tour du Joueur "+player+" : ");

			if (absIA==0) {
				coordinates[0]=ABS_A;
			}
			else if (absIA==1) {
				coordinates[0]=ABS_B;
			}
			else if (absIA==2) {
				coordinates[0]=ABS_C;
			}
			System.out.println(coordinates[0]);
			if (ordIA==0) {
				coordinates[1]=ORD_1;
			}
			else if (ordIA==1) {
				coordinates[1]=ORD_2;
			}
			else if (ordIA==2) {
				coordinates[1]=ORD_3;
			}
			System.out.println(coordinates[1]);

			System.out.println("abscisse "+player+" : "+coordinates[0]+" et ordonn?e "+player+" : "+coordinates[1]);
		}
		return (coordinates);
	}

	//---------------------------------------------------------------------------------------------------------	
	// --------------------- fonction v?rouiller case jou?e pour joueur J1 ------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[] LockCaseJ1 (
			String [][]gride, 
			String[] coordinates, 
			String player) {
		while	(
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][0].equalsIgnoreCase(P1_X) || gride[0][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][1].equalsIgnoreCase(P1_X) || gride[0][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_1) && (gride[0][2].equalsIgnoreCase(P1_X) || gride[0][2].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][0].equalsIgnoreCase(P1_X) || gride[1][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][1].equalsIgnoreCase(P1_X) || gride[1][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_2) && (gride[1][2].equalsIgnoreCase(P1_X) || gride[1][2].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_A) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][0].equalsIgnoreCase(P1_X) || gride[2][0].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_B) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][1].equalsIgnoreCase(P1_X) || gride[2][1].equalsIgnoreCase(P2_O))) || 
				(coordinates[0].equalsIgnoreCase(ABS_C) && coordinates[1].equalsIgnoreCase(ORD_3) && (gride[2][2].equalsIgnoreCase(P1_X) || gride[2][2].equalsIgnoreCase(P2_O)))) {			
			System.out.println("cette case a d?j? ?t? s?lectionn?e !");
			System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
			//	String []coordinates = new String [2];
			coordinates[0] = scanInput.nextLine();
			while (!coordinates[0].equalsIgnoreCase(ABS_A) && !coordinates[0].equalsIgnoreCase(ABS_B) &&!coordinates[0].equalsIgnoreCase(ABS_C)) {
				System.out.println("erreur dans la saisie");
				System.out.println("saissisez un abscisse ("+ABS_A+", "+ABS_B+", "+ABS_C+") :");
				coordinates[0] = scanInput.nextLine();		
			}
			System.out.println("saissisez une ordonn?e ("+ORD_1+", "+ORD_2+", "+ORD_3+"):");
			coordinates[1] = scanInput.nextLine();
			while (!coordinates[1].equalsIgnoreCase(ORD_1) && !coordinates[1].equalsIgnoreCase(ORD_2) &&!coordinates[1].equalsIgnoreCase(ORD_3)) {
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
						(gride[0][0].equalsIgnoreCase(P2_O) && gride[0][1].equalsIgnoreCase(P2_O) && gride[0][2].equalsIgnoreCase(P2_O)) ||
						(gride[1][0].equalsIgnoreCase(P2_O) && gride[1][1].equalsIgnoreCase(P2_O) && gride[1][2].equalsIgnoreCase(P2_O)) ||
						(gride[2][0].equalsIgnoreCase(P2_O) && gride[2][1].equalsIgnoreCase(P2_O) && gride[2][2].equalsIgnoreCase(P2_O)) ||
						(gride[0][0].equalsIgnoreCase(P2_O) && gride[1][0].equalsIgnoreCase(P2_O) && gride[2][0].equalsIgnoreCase(P2_O)) ||
						(gride[0][1].equalsIgnoreCase(P2_O) && gride[1][1].equalsIgnoreCase(P2_O) && gride[2][1].equalsIgnoreCase(P2_O)) ||
						(gride[0][2].equalsIgnoreCase(P2_O) && gride[1][2].equalsIgnoreCase(P2_O) && gride[2][2].equalsIgnoreCase(P2_O)) ||
						(gride[0][0].equalsIgnoreCase(P2_O) && gride[1][1].equalsIgnoreCase(P2_O) && gride[2][2].equalsIgnoreCase(P2_O))) || 
				(		
						(gride[0][0].equalsIgnoreCase(P1_X) && gride[0][1].equalsIgnoreCase(P1_X) && gride[0][2].equalsIgnoreCase(P1_X)) ||
						(gride[1][0].equalsIgnoreCase(P1_X) && gride[1][1].equalsIgnoreCase(P1_X) && gride[1][2].equalsIgnoreCase(P1_X)) ||
						(gride[2][0].equalsIgnoreCase(P1_X) && gride[2][1].equalsIgnoreCase(P1_X) && gride[2][2].equalsIgnoreCase(P1_X)) ||
						(gride[0][0].equalsIgnoreCase(P1_X) && gride[1][0].equalsIgnoreCase(P1_X) && gride[2][0].equalsIgnoreCase(P1_X)) ||
						(gride[0][1].equalsIgnoreCase(P1_X) && gride[1][1].equalsIgnoreCase(P1_X) && gride[2][1].equalsIgnoreCase(P1_X)) ||
						(gride[0][2].equalsIgnoreCase(P1_X) && gride[1][2].equalsIgnoreCase(P1_X) && gride[2][2].equalsIgnoreCase(P1_X)) ||
						(gride[0][0].equalsIgnoreCase(P1_X) && gride[1][1].equalsIgnoreCase(P1_X) && gride[2][2].equalsIgnoreCase(P1_X)))) {
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
				(gride[0][0].equalsIgnoreCase(P2_O) || gride[0][0].equalsIgnoreCase(P1_X)) && 
				(gride[0][1].equalsIgnoreCase(P2_O) || gride[0][1].equalsIgnoreCase(P1_X)) && 
				(gride[0][2].equalsIgnoreCase(P2_O) || gride[0][2].equalsIgnoreCase(P1_X)) && 
				(gride[1][0].equalsIgnoreCase(P2_O) || gride[1][0].equalsIgnoreCase(P1_X)) && 
				(gride[1][1].equalsIgnoreCase(P2_O) || gride[1][1].equalsIgnoreCase(P1_X)) && 
				(gride[1][2].equalsIgnoreCase(P2_O) || gride[1][2].equalsIgnoreCase(P1_X)) && 
				(gride[2][0].equalsIgnoreCase(P2_O) || gride[2][0].equalsIgnoreCase(P1_X)) && 
				(gride[2][1].equalsIgnoreCase(P2_O) || gride[2][1].equalsIgnoreCase(P1_X)) && 
				(gride[2][2].equalsIgnoreCase(P2_O) || gride[2][2].equalsIgnoreCase(P1_X))) {
			System.out.println("\n?galit? !");
			isNull = true;	
		}
		return isNull;
	}

	//---------------------------------------------------------------------------------------------------------	

}

