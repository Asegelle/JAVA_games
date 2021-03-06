package fr.ibformation.exos.bonus.bataille.navale.launcher;

import java.util.InputMismatchException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.Random;
import java.util.Scanner;
import fr.ibformation.exos.bonus.bataille.navale.bo.Grid;
import fr.ibformation.exos.bonus.bataille.navale.bo.Boats;


public class LauncherBatailleNavalle {

	// -----------------------------------------------------------------------------------------------------------------
	// --------------------------------------------- Variables globales ------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------

	//change colors text or background
	public static final String ANSI_RESET = "\u001B[0m";
	//	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	//	public static final String ANSI_GREEN = "\u001B[32m";
	//	public static final String ANSI_YELLOW = "\u001B[33m";
	//	public static final String ANSI_BLUE = "\u001B[34m";
	//	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	//	public static final String ANSI_WHITE = "\u001B[37m";
	//	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	//	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	//	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	//	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	//	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	//	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	//	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// variables de la grille
	public static final String 
	ABS_1 = "1", 	ABS_2 = "2", 	ABS_3 = "3",	ABS_4 = "4", 	ABS_5 = "5", 
	ABS_6 = "6",	ABS_7 = "7", 	ABS_8 = "8", 	ABS_9 = "9",	ABS_10 = "10",

	ORD_A = "A",	ORD_B = "B",	ORD_C = "C",	ORD_D = "D",	ORD_E = "E",
	ORD_F = "F",	ORD_G = "G",	ORD_H = "H",	ORD_I = "I",	ORD_J = "J",

	BOAT = "O",		TOUCHED = "X",	FLOADED = "*",
	PLAYER1 = "J1",	IA = "IA";

	// scanner
	public static Scanner scanInput = new Scanner(System.in);

	// diff?rentes grilles de tc (touch? coul?)
	public static String [][] tc;
	public static String [][] returnTC1, returnTC2;


	// variables pour d?terminer si inputUser est correct ou non
	public static String temp1, temp2, temp3;
	public static char 
	p1b1ord, p1b1abs,p1b1abs2,
	p1b2ord, p1b2abs,p1b2abs2,
	p1b3ord, p1b3abs,p1b3abs2,
	p1b4ord, p1b4abs,p1b4abs2,
	p1b5ord, p1b5abs,p1b5abs2,
	IAb1ord, IAb1abs,IAb1abs2,
	IAb2ord, IAb2abs,IAb2abs2,
	IAb3ord, IAb3abs,IAb3abs2,
	IAb4ord, IAb4abs,IAb4abs2,
	IAb5ord, IAb5abs,IAb5abs2,
	p1TargetOrd,p1TargetAbs,p1TargetAbs2,
	IATargetOrd,IATargetAbs,IATargetAbs2;
	public static String
	y, x;

	// bateaux
	public static final String 
	BOAT1 = "Porte-avion", 
	BOAT2 = "Croiseur", 
	BOAT3 = "contre-torpilleurs", 
	BOAT4 = "sous-marin", 
	BOAT5 = "Torpilleur";
	public static final int 
	REF_BOAT1 = 1, 	REF_BOAT2 = 2, 	REF_BOAT3 = 3, 
	REF_BOAT4 = 4, 	REF_BOAT5 = 5;
	public static String 
	player1boat1,	player1boat2,	player1boat3,
	player1boat4,	player1boat5,
	IAboat1,		IAboat2,		IAboat3,
	IAboat4,		IAboat5,
	playerTarget,	IATarget;

	// taille des bateaux 
	public static final int 
	SIZE5 = 5,
	SIZE4 = 4,
	SIZE3 = 3,
	SIZE2 = 2;

	// case pour positionner les bateaux
	public static final int
	CASE1 = 1;
	public static int 
	startAbs,
	startOrd,
	endAbs,
	endOrd,
	targetAbs,
	targetOrd;
	public static boolean
	isVerticalRight = false,
	isHorizontalRight = false,
	isRightLengthVer = false,
	isRightLengthHor = false;

	// boolean pour si bateau coul? ou non
	public static boolean 
	isP1B1Dead = true,	isP1B2Dead = true,	isP1B3Dead = true,
	isP1B4Dead = true,	isP1B5Dead = true,
	isIAB1Dead = true,	isIAB2Dead = true,	isIAB3Dead = true,
	isIAB4Dead = true,	isIAB5Dead = true;
	public static boolean 
	returnedIsP1B1Dead = false,	returnedIsP1B2Dead = false,	returnedIsP1B3Dead = false,
	returnedIsP1B4Dead = false,	returnedIsP1B5Dead = false,
	returnedIsIAB1Dead = false,	returnedIsIAB2Dead = false,	returnedIsIAB3Dead = false,
	returnedIsIAB4Dead = false,	returnedIsIAB5Dead = false;

	// grilles de TC
	public static String empty = " ";
	public static String[][] J1Grid = new String[][]{ 
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty}
	};
	public static String[][] IAGrid = new String[][]{ 
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty},
		{empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty,empty}
	};

	public static String[][] reset = new String[][]{ 
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
		{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "}
	};


	// ----------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------- main -------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		boolean retry = true;
		System.out.println("Bienvenue dans le jeu de la Bataille Navale vs IA !\n\nLa bataille navale oppose deux joueurs qui s'affrontent. \nChacun a une flotte compos?e de 5 bateaux : \n\t1 porte-avion (5 cases), \n\t1 croiseur (4 cases), \n\t1 contre-torpilleur (3 cases), \n\t1 sous-marin (3 cases), \n\t1 torpilleur (2 cases). \nAu d?but du jeu, chaque joueur place ses bateaux sur sa grille. \nCelle-ci est num?rot?e de 1 ? 10 verticalement et de A ? J horizontalement. \nUn ? un, les joueurs vont ? tirer ? sur une case de l'adversaire : par exemple, B3 ou encore H8. \nLe but est de couler les bateaux adverses, en ayant touch? toutes les cases occup?es par ces bateaux.\n");
		// boucle de relance du jeu
		do {
			boolean isVictory = false;
			// fonction pour renvoyer ? J1 la grille initiale vide (tc)
			System.out.println("voici votre grille de bataille !\n");
			tc = GridJ1(J1Grid);										
			System.out.println("\nvous devez maintenant d?terminer ou se trouvent vos 5 b?teaux de guerre sur cette grille.");
			// fonction pour interroger J1, d?terminer position bateaux sur la grille et renvoyer la grille
			String[][] p1b1 =  BoatPlaceJ1(J1Grid,BOAT1,REF_BOAT1,SIZE5,player1boat1,p1b1abs,p1b1abs2,p1b1ord);
			String[][] p1b2 =  BoatPlaceJ1(p1b1,BOAT2,REF_BOAT2,SIZE4,player1boat2,p1b2abs,p1b2abs2,p1b2ord);
			String[][] p1b3 =  BoatPlaceJ1(p1b2,BOAT3,REF_BOAT3,SIZE3,player1boat3,p1b3abs,p1b3abs2,p1b3ord);
			String[][] p1b4 =  BoatPlaceJ1(p1b3,BOAT4,REF_BOAT4,SIZE3,player1boat4,p1b4abs,p1b4abs2,p1b4ord);
			String[][] p1b5 =  BoatPlaceJ1(p1b4,BOAT5,REF_BOAT5,SIZE2,player1boat5,p1b5abs,p1b5abs2,p1b5ord);
			System.out.println("\nvous venez de placer l'ensemble de votre flotte, pr?parez vous au combat !\n");
			// fonction pour interroger IA, d?terminer position bateaux sur la grille (et renvoyer la grille)
			//		System.out.println("au tour de l'IA : \n");
			String[][] IAb1 =  BoatPlaceIA(IAGrid,BOAT1,REF_BOAT1,SIZE5,IAboat1,IAb1abs,IAb1abs2,IAb1ord);
			String[][] IAb2 =  BoatPlaceIA(IAb1,BOAT2,REF_BOAT2,SIZE4,IAboat2,IAb2abs,IAb2abs2,IAb2ord);
			String[][] IAb3 =  BoatPlaceIA(IAb2,BOAT3,REF_BOAT3,SIZE3,IAboat3,IAb3abs,IAb3abs2,IAb3ord);
			String[][] IAb4 =  BoatPlaceIA(IAb3,BOAT4,REF_BOAT4,SIZE3,IAboat4,IAb4abs,IAb4abs2,IAb4ord);
			String[][] IAb5 =  BoatPlaceIA(IAb4,BOAT5,REF_BOAT5,SIZE2,IAboat5,IAb5abs,IAb5abs2,IAb5ord);
			String[][] returnIAgrid = GridIA(IAb5);		
			// d?terminer qui commence (random 1-2)
			int firstPlayer = firstPlayer();
//			System.out.println(firstPlayer);
			//			firstPlayer = 0;
			// si joueur commence (random = 0)
			do {
				if (firstPlayer==0) {
					// fonction choix J1 de case a viser
					String [][] p1Targets =  targetP1 (p1b5, IAb5);
					firstPlayer=1;
				}
				//condition de victoire J1
				if (returnedIsIAB1Dead && returnedIsIAB2Dead && returnedIsIAB3Dead && returnedIsIAB4Dead && returnedIsIAB5Dead) {
					System.out.println("tous les b?teaux de la flotte de "+IA+" sont coul?s !");
					System.out.println("victoire de "+PLAYER1+" ! ");
					isVictory = true;
					break;
				}
				// si IA commence (random =1)
				if(firstPlayer==1){
					// fonction choix IA de case a viser
					String [][] IATargets =  targetIA (IAb5, p1b5);
					firstPlayer=0;
				}
				//condition de victoire IA
				if (returnedIsP1B1Dead && returnedIsP1B2Dead && returnedIsP1B3Dead && returnedIsP1B4Dead && returnedIsP1B5Dead) {
					System.out.println("tous les b?teaux de la flotte de "+PLAYER1+" sont coul?s !");
					System.out.println("victoire de "+IA+" ! ");
					isVictory = true;
					break;
				}
				// boucle de repetition tant que pas tout bateaux coul?s
			}
			while (!isVictory); 			// relancer une partie
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
				System.out.println("bienvenue dans une nouvelle partie de Bataille Navale ! \n");
				// reset tu tableau initial
				IAGrid = reset;
				J1Grid = reset;
			}
			else {
				System.out.println("A bient?t pour une nouvelle partie !");
				retry=false;
				scanRetry.close();}
		}
		while (retry);
	}



	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction affichage grille de choix position b?teaux (not used) -------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] emptyGrid(
			String [][]g) {

		System.out.println(" Grille Joueur                               ");
		System.out.println("     "+ORD_A+"   "+ORD_B+"   "+ORD_C+"   "+ORD_D+"   "+ORD_E+"   "+ORD_F+"   "+ORD_G+"   "+ORD_H+"   "+ORD_I+"   "+ORD_J);
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_1+" | "+g[0][0]+" | "+g[0][1]+" | "+g[0][2]+" | "+g[0][3]+" | "+g[0][4]+" | "+g[0][5]+" | "+g[0][6]+" | "+g[0][7]+" | "+g[0][8]+" | "+g[0][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_2+" | "+g[1][0]+" | "+g[1][1]+" | "+g[1][2]+" | "+g[1][3]+" | "+g[1][4]+" | "+g[1][5]+" | "+g[1][6]+" | "+g[1][7]+" | "+g[1][8]+" | "+g[1][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_3+" | "+g[2][0]+" | "+g[2][1]+" | "+g[2][2]+" | "+g[2][3]+" | "+g[2][4]+" | "+g[2][5]+" | "+g[2][6]+" | "+g[2][7]+" | "+g[2][8]+" | "+g[2][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_4+" | "+g[3][0]+" | "+g[3][1]+" | "+g[3][2]+" | "+g[3][3]+" | "+g[3][4]+" | "+g[3][5]+" | "+g[3][6]+" | "+g[3][7]+" | "+g[3][8]+" | "+g[3][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_5+" | "+g[4][0]+" | "+g[4][1]+" | "+g[4][2]+" | "+g[4][3]+" | "+g[4][4]+" | "+g[4][5]+" | "+g[4][6]+" | "+g[4][7]+" | "+g[4][8]+" | "+g[4][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_6+" | "+g[5][0]+" | "+g[5][1]+" | "+g[5][2]+" | "+g[5][3]+" | "+g[5][4]+" | "+g[5][5]+" | "+g[5][6]+" | "+g[5][7]+" | "+g[5][8]+" | "+g[5][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_7+" | "+g[6][0]+" | "+g[6][1]+" | "+g[6][2]+" | "+g[6][3]+" | "+g[6][4]+" | "+g[6][5]+" | "+g[6][6]+" | "+g[6][7]+" | "+g[6][8]+" | "+g[6][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_8+" | "+g[7][0]+" | "+g[7][1]+" | "+g[7][2]+" | "+g[7][3]+" | "+g[7][4]+" | "+g[7][5]+" | "+g[7][6]+" | "+g[7][7]+" | "+g[7][8]+" | "+g[7][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_9+" | "+g[8][0]+" | "+g[8][1]+" | "+g[8][2]+" | "+g[8][3]+" | "+g[8][4]+" | "+g[8][5]+" | "+g[8][6]+" | "+g[8][7]+" | "+g[8][8]+" | "+g[8][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(""+ABS_10+" | "+g[9][0]+" | "+g[9][1]+" | "+g[9][2]+" | "+g[9][3]+" | "+g[9][4]+" | "+g[9][5]+" | "+g[9][6]+" | "+g[9][7]+" | "+g[9][8]+" | "+g[9][9]+" | ");
		System.out.println("   --- --- --- --- --- --- --- --- --- ---   ");
		System.out.println("Bateau : "+BOAT+"\t Dans l'eau : "+FLOADED+"      touch? : "+TOUCHED);


		return g; 
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction affichage grille J1 -----------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] GridJ1(
			String [][]g) {

		System.out.println(" Grille Joueur                                  |   Grille Ennemi                                ");
		System.out.println("     "+ORD_A+"   "+ORD_B+"   "+ORD_C+"   "+ORD_D+"   "+ORD_E+"   "+ORD_F+"   "+ORD_G+"   "+ORD_H+"   "+ORD_I+"   "+ORD_J+"      |       "+ORD_A+"   "+ORD_B+"   "+ORD_C+"   "+ORD_D+"   "+ORD_E+"   "+ORD_F+"   "+ORD_G+"   "+ORD_H+"   "+ORD_I+"   "+ORD_J+"   ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_1+" | "+g[0][0]+" | "+g[0][1]+" | "+g[0][2]+" | "+g[0][3]+" | "+g[0][4]+" | "+g[0][5]+" | "+g[0][6]+" | "+g[0][7]+" | "+g[0][8]+" | "+g[0][9]+" |    |   "+ABS_1+" | "+g[0][10]+" | "+g[0][11]+" | "+g[0][12]+" | "+g[0][13]+" | "+g[0][14]+" | "+g[0][15]+" | "+g[0][16]+" | "+g[0][17]+" | "+g[0][18]+" | "+g[0][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_2+" | "+g[1][0]+" | "+g[1][1]+" | "+g[1][2]+" | "+g[1][3]+" | "+g[1][4]+" | "+g[1][5]+" | "+g[1][6]+" | "+g[1][7]+" | "+g[1][8]+" | "+g[1][9]+" |    |   "+ABS_2+" | "+g[1][10]+" | "+g[1][11]+" | "+g[1][12]+" | "+g[1][13]+" | "+g[1][14]+" | "+g[1][15]+" | "+g[1][16]+" | "+g[1][17]+" | "+g[1][18]+" | "+g[1][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_3+" | "+g[2][0]+" | "+g[2][1]+" | "+g[2][2]+" | "+g[2][3]+" | "+g[2][4]+" | "+g[2][5]+" | "+g[2][6]+" | "+g[2][7]+" | "+g[2][8]+" | "+g[2][9]+" |    |   "+ABS_3+" | "+g[2][10]+" | "+g[2][11]+" | "+g[2][12]+" | "+g[2][13]+" | "+g[2][14]+" | "+g[2][15]+" | "+g[2][16]+" | "+g[2][17]+" | "+g[2][18]+" | "+g[2][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_4+" | "+g[3][0]+" | "+g[3][1]+" | "+g[3][2]+" | "+g[3][3]+" | "+g[3][4]+" | "+g[3][5]+" | "+g[3][6]+" | "+g[3][7]+" | "+g[3][8]+" | "+g[3][9]+" |    |   "+ABS_4+" | "+g[3][10]+" | "+g[3][11]+" | "+g[3][12]+" | "+g[3][13]+" | "+g[3][14]+" | "+g[3][15]+" | "+g[3][16]+" | "+g[3][17]+" | "+g[3][18]+" | "+g[3][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_5+" | "+g[4][0]+" | "+g[4][1]+" | "+g[4][2]+" | "+g[4][3]+" | "+g[4][4]+" | "+g[4][5]+" | "+g[4][6]+" | "+g[4][7]+" | "+g[4][8]+" | "+g[4][9]+" |    |   "+ABS_5+" | "+g[4][10]+" | "+g[4][11]+" | "+g[4][12]+" | "+g[4][13]+" | "+g[4][14]+" | "+g[4][15]+" | "+g[4][16]+" | "+g[4][17]+" | "+g[4][18]+" | "+g[4][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_6+" | "+g[5][0]+" | "+g[5][1]+" | "+g[5][2]+" | "+g[5][3]+" | "+g[5][4]+" | "+g[5][5]+" | "+g[5][6]+" | "+g[5][7]+" | "+g[5][8]+" | "+g[5][9]+" |    |   "+ABS_6+" | "+g[5][10]+" | "+g[5][11]+" | "+g[5][12]+" | "+g[5][13]+" | "+g[5][14]+" | "+g[5][15]+" | "+g[5][16]+" | "+g[5][17]+" | "+g[5][18]+" | "+g[5][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_7+" | "+g[6][0]+" | "+g[6][1]+" | "+g[6][2]+" | "+g[6][3]+" | "+g[6][4]+" | "+g[6][5]+" | "+g[6][6]+" | "+g[6][7]+" | "+g[6][8]+" | "+g[6][9]+" |    |   "+ABS_7+" | "+g[6][10]+" | "+g[6][11]+" | "+g[6][12]+" | "+g[6][13]+" | "+g[6][14]+" | "+g[6][15]+" | "+g[6][16]+" | "+g[6][17]+" | "+g[6][18]+" | "+g[6][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_8+" | "+g[7][0]+" | "+g[7][1]+" | "+g[7][2]+" | "+g[7][3]+" | "+g[7][4]+" | "+g[7][5]+" | "+g[7][6]+" | "+g[7][7]+" | "+g[7][8]+" | "+g[7][9]+" |    |   "+ABS_8+" | "+g[7][10]+" | "+g[7][11]+" | "+g[7][12]+" | "+g[7][13]+" | "+g[7][14]+" | "+g[7][15]+" | "+g[7][16]+" | "+g[7][17]+" | "+g[7][18]+" | "+g[7][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_9+" | "+g[8][0]+" | "+g[8][1]+" | "+g[8][2]+" | "+g[8][3]+" | "+g[8][4]+" | "+g[8][5]+" | "+g[8][6]+" | "+g[8][7]+" | "+g[8][8]+" | "+g[8][9]+" |    |   "+ABS_9+" | "+g[8][10]+" | "+g[8][11]+" | "+g[8][12]+" | "+g[8][13]+" | "+g[8][14]+" | "+g[8][15]+" | "+g[8][16]+" | "+g[8][17]+" | "+g[8][18]+" | "+g[8][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(""+ABS_10+" | "+g[9][0]+" | "+g[9][1]+" | "+g[9][2]+" | "+g[9][3]+" | "+g[9][4]+" | "+g[9][5]+" | "+g[9][6]+" | "+g[9][7]+" | "+g[9][8]+" | "+g[9][9]+" |    |  "+ABS_10+" | "+g[9][10]+" | "+g[9][11]+" | "+g[9][12]+" | "+g[9][13]+" | "+g[9][14]+" | "+g[9][15]+" | "+g[9][16]+" | "+g[9][17]+" | "+g[9][18]+" | "+g[9][19]+" | ");
		System.out.println("   --- --- --- --- --- --- --- --- --- ---      |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println("\t\t\t Bateau : "+BOAT+"\t Dans l'eau : "+FLOADED+"      touch? : "+TOUCHED);

		return g; 
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction affichage grille IA -----------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] GridIA(
			String [][]g) {

		System.out.println(" Grille IA                                      |   Grille Joueur                              ");
		System.out.println("     "+ORD_A+"   "+ORD_B+"   "+ORD_C+"   "+ORD_D+"   "+ORD_E+"   "+ORD_F+"   "+ORD_G+"   "+ORD_H+"   "+ORD_I+"   "+ORD_J+"      |       "+ORD_A+"   "+ORD_B+"   "+ORD_C+"   "+ORD_D+"   "+ORD_E+"   "+ORD_F+"   "+ORD_G+"   "+ORD_H+"   "+ORD_I+"   "+ORD_J+"   ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_1+" | "+g[0][10]+" | "+g[0][11]+" | "+g[0][12]+" | "+g[0][13]+" | "+g[0][14]+" | "+g[0][15]+" | "+g[0][16]+" | "+g[0][17]+" | "+g[0][18]+" | "+g[0][19]+" |    |   "+ABS_1+" | "+g[0][0]+" | "+g[0][1]+" | "+g[0][2]+" | "+g[0][3]+" | "+g[0][4]+" | "+g[0][5]+" | "+g[0][6]+" | "+g[0][7]+" | "+g[0][8]+" | "+g[0][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_2+" | "+g[1][10]+" | "+g[1][11]+" | "+g[1][12]+" | "+g[1][13]+" | "+g[1][14]+" | "+g[1][15]+" | "+g[1][16]+" | "+g[1][17]+" | "+g[1][18]+" | "+g[1][19]+" |    |   "+ABS_2+" | "+g[1][0]+" | "+g[1][1]+" | "+g[1][2]+" | "+g[1][3]+" | "+g[1][4]+" | "+g[1][5]+" | "+g[1][6]+" | "+g[1][7]+" | "+g[1][8]+" | "+g[1][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_3+" | "+g[2][10]+" | "+g[2][11]+" | "+g[2][12]+" | "+g[2][13]+" | "+g[2][14]+" | "+g[2][15]+" | "+g[2][16]+" | "+g[2][17]+" | "+g[2][18]+" | "+g[2][19]+" |    |   "+ABS_3+" | "+g[2][0]+" | "+g[2][1]+" | "+g[2][2]+" | "+g[2][3]+" | "+g[2][4]+" | "+g[2][5]+" | "+g[2][6]+" | "+g[2][7]+" | "+g[2][8]+" | "+g[2][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_4+" | "+g[3][10]+" | "+g[3][11]+" | "+g[3][12]+" | "+g[3][13]+" | "+g[3][14]+" | "+g[3][15]+" | "+g[3][16]+" | "+g[3][17]+" | "+g[3][18]+" | "+g[3][19]+" |    |   "+ABS_4+" | "+g[3][0]+" | "+g[3][1]+" | "+g[3][2]+" | "+g[3][3]+" | "+g[3][4]+" | "+g[3][5]+" | "+g[3][6]+" | "+g[3][7]+" | "+g[3][8]+" | "+g[3][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_5+" | "+g[4][10]+" | "+g[4][11]+" | "+g[4][12]+" | "+g[4][13]+" | "+g[4][14]+" | "+g[4][15]+" | "+g[4][16]+" | "+g[4][17]+" | "+g[4][18]+" | "+g[4][19]+" |    |   "+ABS_5+" | "+g[4][0]+" | "+g[4][1]+" | "+g[4][2]+" | "+g[4][3]+" | "+g[4][4]+" | "+g[4][5]+" | "+g[4][6]+" | "+g[4][7]+" | "+g[4][8]+" | "+g[4][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_6+" | "+g[5][10]+" | "+g[5][11]+" | "+g[5][12]+" | "+g[5][13]+" | "+g[5][14]+" | "+g[5][15]+" | "+g[5][16]+" | "+g[5][17]+" | "+g[5][18]+" | "+g[5][19]+" |    |   "+ABS_6+" | "+g[5][0]+" | "+g[5][1]+" | "+g[5][2]+" | "+g[5][3]+" | "+g[5][4]+" | "+g[5][5]+" | "+g[5][6]+" | "+g[5][7]+" | "+g[5][8]+" | "+g[5][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_7+" | "+g[6][10]+" | "+g[6][11]+" | "+g[6][12]+" | "+g[6][13]+" | "+g[6][14]+" | "+g[6][15]+" | "+g[6][16]+" | "+g[6][17]+" | "+g[6][18]+" | "+g[6][19]+" |    |   "+ABS_7+" | "+g[6][0]+" | "+g[6][1]+" | "+g[6][2]+" | "+g[6][3]+" | "+g[6][4]+" | "+g[6][5]+" | "+g[6][6]+" | "+g[6][7]+" | "+g[6][8]+" | "+g[6][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_8+" | "+g[7][10]+" | "+g[7][11]+" | "+g[7][12]+" | "+g[7][13]+" | "+g[7][14]+" | "+g[7][15]+" | "+g[7][16]+" | "+g[7][17]+" | "+g[7][18]+" | "+g[7][19]+" |    |   "+ABS_8+" | "+g[7][0]+" | "+g[7][1]+" | "+g[7][2]+" | "+g[7][3]+" | "+g[7][4]+" | "+g[7][5]+" | "+g[7][6]+" | "+g[7][7]+" | "+g[7][8]+" | "+g[7][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ABS_9+" | "+g[8][10]+" | "+g[8][11]+" | "+g[8][12]+" | "+g[8][13]+" | "+g[8][14]+" | "+g[8][15]+" | "+g[8][16]+" | "+g[8][17]+" | "+g[8][18]+" | "+g[8][19]+" |    |   "+ABS_9+" | "+g[8][0]+" | "+g[8][1]+" | "+g[8][2]+" | "+g[8][3]+" | "+g[8][4]+" | "+g[8][5]+" | "+g[8][6]+" | "+g[8][7]+" | "+g[8][8]+" | "+g[8][9]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(""+ABS_10+" | "+g[9][10]+" | "+g[9][11]+" | "+g[9][12]+" | "+g[9][13]+" | "+g[9][14]+" | "+g[9][15]+" | "+g[9][16]+" | "+g[9][17]+" | "+g[9][18]+" | "+g[9][19]+" |    |  "+ABS_10+" | "+g[9][0]+" | "+g[9][1]+" | "+g[9][2]+" | "+g[9][3]+" | "+g[9][4]+" | "+g[9][5]+" | "+g[9][6]+" | "+g[9][7]+" | "+g[9][8]+" | "+g[9][9]+" | ");
		System.out.println("   --- --- --- --- --- --- --- --- --- ---      |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println("\t\t\t Bateau : "+BOAT+"\t Dans l'eau : "+FLOADED+"      touch? : "+TOUCHED);

		return g; 
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
	// --------------------- fonction d?termination position bateaux J1 ---------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] BoatPlaceJ1(
			String[][] grid,
			String boat,
			int refBoat,
			int size, 
			String playerBoat, 
			char playerBoatAbs, 
			char playerBoatAbs2, 
			char playerBoatOrd) 
	{
		// d?claration des variables
		System.out.println("\nposition du "+boat+" (taille de "+size+" cases) : ");
		boolean rightStartAbscissa = false;
		boolean rightStartOrdinate = false;
		boolean rightEndAbscissa = false;
		boolean rightEndOrdinate = false;	
		boolean lineOccupied = false;
		boolean reLoop = true;
		boolean returnedIsHorizontal = false;
		boolean returnedIsVertical = false;
		boolean returnedIsRightLengthHor = false;
		boolean returnedIsRightLengthVer = false;
		// boucle tant que position du bateau pas bonne
		while (reLoop == true) {
			reLoop = false;
			lineOccupied = false;
			returnedIsHorizontal = false;
			returnedIsVertical = false;
			rightStartAbscissa = false;
			rightStartOrdinate = false;
			rightEndAbscissa = false;
			rightEndOrdinate = false;
			// boucle pour v?rifier si bateau pos? en vertical/horizontal et si bonne taille
			while ((!returnedIsHorizontal && !returnedIsVertical) || (!returnedIsRightLengthHor && !returnedIsRightLengthVer)) {
				returnedIsRightLengthHor = false;
				returnedIsRightLengthVer = false;
				returnedIsHorizontal = false;
				returnedIsVertical = false;
				rightStartAbscissa = false;
				rightStartOrdinate = false;
				rightEndAbscissa = false;
				rightEndOrdinate = false;
				// boucle pour choisir premi?re case du bateau
				while (!rightStartAbscissa || !rightStartOrdinate) {
					rightStartAbscissa = false;
					rightStartOrdinate = false;
					//interrogation du joueur sur case ? choisir
					temp3 = " ";
					System.out.println("\nposition de la case "+(CASE1)+" sur "+size+" : (exemple "+ORD_A+ABS_1+", "+ORD_B+ABS_2+", ...) : ");
					playerBoat = scanInput.nextLine();
					//				System.out.println(playerBoat);
					// conversion de la saisie en char
					try {
						playerBoatOrd = playerBoat.charAt(0);
						temp1 = Character.toString(playerBoatOrd);	
						playerBoatAbs = playerBoat.charAt(1);
						temp2 = Character.toString(playerBoatAbs);				
						playerBoatAbs2 = playerBoat.charAt(2); 
						temp3 = Character.toString(playerBoatAbs2);	}
					catch (StringIndexOutOfBoundsException e) {
						//					System.out.println("StringIndexOutOfBoundsException");
						//					e.printStackTrace();
					}
					// v?rifier que saisie est bien une des cases de la grille
					try {
						if	(
								!temp1.equalsIgnoreCase(ORD_A) && 
								!temp1.equalsIgnoreCase(ORD_B) && 
								!temp1.equalsIgnoreCase(ORD_C) && 
								!temp1.equalsIgnoreCase(ORD_D) && 
								!temp1.equalsIgnoreCase(ORD_E) && 
								!temp1.equalsIgnoreCase(ORD_F) && 
								!temp1.equalsIgnoreCase(ORD_G) && 
								!temp1.equalsIgnoreCase(ORD_H) && 
								!temp1.equalsIgnoreCase(ORD_I) && 
								!temp1.equalsIgnoreCase(ORD_J)) 
						{
							System.err.println("erreur dans la saisie de l'ordonn?e (A, B, ...)\n");
						}
						else {
							rightStartOrdinate = true;
							//				System.out.println("rightOrdinate : "+rightOrdinate);
						}
						if (
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_2) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_3) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_4) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_5) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_6) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_7) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_8) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_9) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase("0")))
						{
							System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						}
						else 
						{
							rightStartAbscissa = true;
							//				System.out.println("rightAbscissa : "+rightAbscissa);
						}
					}
					catch (NullPointerException e){
						//					System.out.println("NullPointerException");
						System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						//					e.printStackTrace();
					}
					// d?termination de y (ordonn?e)
					if (rightStartAbscissa==true && rightStartOrdinate==true) {
						System.out.println("case s?lectionn?e : "+playerBoat+"\n");
						if (temp1.equalsIgnoreCase(ORD_A)) {startOrd = 0;
						}
						else if (temp1.equalsIgnoreCase(ORD_B)) {startOrd = 1;}
						else if (temp1.equalsIgnoreCase(ORD_C)) {startOrd = 2;}			
						else if (temp1.equalsIgnoreCase(ORD_D)) {startOrd = 3;}			
						else if (temp1.equalsIgnoreCase(ORD_E)) {startOrd = 4;}			
						else if (temp1.equalsIgnoreCase(ORD_F)) {startOrd = 5;}			
						else if (temp1.equalsIgnoreCase(ORD_G)) {startOrd = 6;}			
						else if (temp1.equalsIgnoreCase(ORD_H)) {startOrd = 7;}			
						else if (temp1.equalsIgnoreCase(ORD_I)) {startOrd = 8;}			
						else if (temp1.equalsIgnoreCase(ORD_J)) {startOrd = 9;}
						// d?termination de x (abscisse)
						if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase(" ")) {startAbs = 0;}
						else if (temp2.equalsIgnoreCase(ABS_2) && temp3.equalsIgnoreCase(" ")) {startAbs = 1;}
						else if (temp2.equalsIgnoreCase(ABS_3) && temp3.equalsIgnoreCase(" ")) {startAbs = 2;}			
						else if (temp2.equalsIgnoreCase(ABS_4) && temp3.equalsIgnoreCase(" ")) {startAbs = 3;}			
						else if (temp2.equalsIgnoreCase(ABS_5) && temp3.equalsIgnoreCase(" ")) {startAbs = 4;}			
						else if (temp2.equalsIgnoreCase(ABS_6) && temp3.equalsIgnoreCase(" ")) {startAbs = 5;}			
						else if (temp2.equalsIgnoreCase(ABS_7) && temp3.equalsIgnoreCase(" ")) {startAbs = 6;}			
						else if (temp2.equalsIgnoreCase(ABS_8) && temp3.equalsIgnoreCase(" ")) {startAbs = 7;}			
						else if (temp2.equalsIgnoreCase(ABS_9) && temp3.equalsIgnoreCase(" ")) {startAbs = 8;}			
						else if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase("0")) {startAbs = 9;}
						if (
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
								) {
							System.err.println("cette case a d?j? ?t? selectionn?e !\n");
							rightStartAbscissa = false;
							rightStartOrdinate = false;
						}
						// renvoie de la grille au joueur 
						else {
							grid[startAbs][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
							//					System.out.println("x : "+startAbs+", y : "+startOrd);
							returnTC1 = GridJ1(grid);			
						}
					}
				}
				// boucle pour choisir derni?re case du bateau (meme logique que la premi?re)
				while (!rightEndAbscissa || !rightEndOrdinate) {
					rightEndAbscissa = false;
					rightEndOrdinate = false;
					temp3 = " ";
					System.out.println("\nposition de la case "+size+" sur "+size+" : (exemple "+ORD_A+ABS_1+", "+ORD_B+ABS_2+", ...) : ");
					playerBoat = scanInput.nextLine();
					//				System.out.println(playerBoat);
					try {
						playerBoatOrd = playerBoat.charAt(0);
						temp1 = Character.toString(playerBoatOrd);	
						playerBoatAbs = playerBoat.charAt(1);
						temp2 = Character.toString(playerBoatAbs);				
						playerBoatAbs2 = playerBoat.charAt(2); 
						temp3 = Character.toString(playerBoatAbs2);	}
					catch (StringIndexOutOfBoundsException e) {
						//					System.out.println("StringIndexOutOfBoundsException");
						//					e.printStackTrace();
					}
					try {
						if	(
								!temp1.equalsIgnoreCase(ORD_A) && 
								!temp1.equalsIgnoreCase(ORD_B) && 
								!temp1.equalsIgnoreCase(ORD_C) && 
								!temp1.equalsIgnoreCase(ORD_D) && 
								!temp1.equalsIgnoreCase(ORD_E) && 
								!temp1.equalsIgnoreCase(ORD_F) && 
								!temp1.equalsIgnoreCase(ORD_G) && 
								!temp1.equalsIgnoreCase(ORD_H) && 
								!temp1.equalsIgnoreCase(ORD_I) && 
								!temp1.equalsIgnoreCase(ORD_J)) 
						{
							System.err.println("erreur dans la saisie de l'ordonn?e (A, B, ...)\n");
						}
						else {
							rightEndOrdinate = true;
							//				System.out.println("rightOrdinate : "+rightOrdinate);
						}
						if (
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_2) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_3) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_4) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_5) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_6) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_7) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_8) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_9) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase("0")))
						{
							System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						}
						else 
						{
							rightEndAbscissa = true;
							//				System.out.println("rightAbscissa : "+rightAbscissa);
						}
					}
					catch (NullPointerException e){
						//					System.out.println("NullPointerException");
						System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						//					e.printStackTrace();
					}
					// d?termination de y (ordonn?e)
					if (rightEndAbscissa==true && rightEndOrdinate==true) {
						System.out.println("case s?lectionn?e : "+playerBoat+"\n");
						if (temp1.equalsIgnoreCase(ORD_A)) {endOrd = 0;}
						else if (temp1.equalsIgnoreCase(ORD_B)) {endOrd = 1;}
						else if (temp1.equalsIgnoreCase(ORD_C)) {endOrd = 2;}			
						else if (temp1.equalsIgnoreCase(ORD_D)) {endOrd = 3;}			
						else if (temp1.equalsIgnoreCase(ORD_E)) {endOrd = 4;}			
						else if (temp1.equalsIgnoreCase(ORD_F)) {endOrd = 5;}			
						else if (temp1.equalsIgnoreCase(ORD_G)) {endOrd = 6;}			
						else if (temp1.equalsIgnoreCase(ORD_H)) {endOrd = 7;}			
						else if (temp1.equalsIgnoreCase(ORD_I)) {endOrd = 8;}			
						else if (temp1.equalsIgnoreCase(ORD_J)) {endOrd = 9;}
						// d?termination de x (abscisse)
						if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase(" ")) {endAbs = 0;}
						else if (temp2.equalsIgnoreCase(ABS_2) && temp3.equalsIgnoreCase(" ")) {endAbs = 1;}
						else if (temp2.equalsIgnoreCase(ABS_3) && temp3.equalsIgnoreCase(" ")) {endAbs = 2;}			
						else if (temp2.equalsIgnoreCase(ABS_4) && temp3.equalsIgnoreCase(" ")) {endAbs = 3;}			
						else if (temp2.equalsIgnoreCase(ABS_5) && temp3.equalsIgnoreCase(" ")) {endAbs = 4;}			
						else if (temp2.equalsIgnoreCase(ABS_6) && temp3.equalsIgnoreCase(" ")) {endAbs = 5;}			
						else if (temp2.equalsIgnoreCase(ABS_7) && temp3.equalsIgnoreCase(" ")) {endAbs = 6;}			
						else if (temp2.equalsIgnoreCase(ABS_8) && temp3.equalsIgnoreCase(" ")) {endAbs = 7;}			
						else if (temp2.equalsIgnoreCase(ABS_9) && temp3.equalsIgnoreCase(" ")) {endAbs = 8;}			
						else if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase("0")) {endAbs = 9;}
						if (
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
								) {
							System.err.println("cette case a d?j? ?t? selectionn?e !\n");
							rightEndAbscissa = false;
							rightEndOrdinate = false;
						}
					}
				}
				// v?rification que les 2 coordonn?es saisies sont bien sur la meme verticale/horizontale
				returnedIsHorizontal = isHorizontal (startAbs, endAbs, isHorizontalRight);
				returnedIsVertical = isVertical (startOrd, endOrd, isVerticalRight);
				//				System.out.println("returnedIsHorizontal : "+returnedIsHorizontal);
				//				System.out.println("returnedIsVertical : "+returnedIsVertical);
				if (returnedIsHorizontal==false && returnedIsVertical==false) {
					System.err.println("vous avez mal plac? votre b?teau !\n");
					grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
					grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
					//				System.out.println("startAbs : "+startAbs);
					//				System.out.println("startOrd : "+startOrd);
					returnTC1 = GridJ1(grid);
				}
				// v?rification que les 2 coordonn?es sont de la bonne taille de bateau
				returnedIsRightLengthHor = isRightLengthHor (startAbs, endAbs, isRightLengthHor,size);
				returnedIsRightLengthVer = isRightLengthVer (startOrd, endOrd, isRightLengthVer,size);
				//				System.out.println("returnedIsRightLengthHor : "+returnedIsRightLengthHor);
				//				System.out.println("returnedIsRightLengthVer : "+returnedIsRightLengthVer);
				if (returnedIsRightLengthHor==false && returnedIsRightLengthVer==false) {
					System.err.println("vous n'avez pas respect? la taille de votre b?teau !\n");
					grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
					grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
					//				System.out.println("startAbs : "+startAbs);
					//				System.out.println("startOrd : "+startOrd);
					if (returnedIsHorizontal==true || returnedIsVertical==true) {
						returnTC1 = GridJ1(grid);
					}			
				}
			}
			// v?rification que position du bateau choisie ne croise pas un autre bateau
			if (startAbs == endAbs) {
				for (int c = startOrd+1; c <= endOrd-1; c++) {
					if (grid[startAbs][c] != empty) {
						lineOccupied = true;
						reLoop = true;
						System.err.println("l'une des cases a d?j? ?t? s?lectionn?e !\n");
						grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
						grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
						//						System.out.println("startAbs : "+startAbs);
						//						System.out.println("startOrd : "+startOrd);
						returnTC1 = GridJ1(grid);			
					}
				}
			}
			else if (startOrd == endOrd) {
				for (int r = startAbs+1; r <= endAbs-1; r++) {
					if (grid[r][startOrd] != empty) {
						lineOccupied = true;	
						reLoop = true;
						System.err.println("l'une des cases a d?j? ?t? s?lectionn?e !\n");
						grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
						grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
						//						System.out.println("startAbs : "+startAbs);
						//						System.out.println("startOrd : "+startOrd);
						returnTC1 = GridJ1(grid);			
					}
				}
			}
			//			else {
			//				lineOccupied = false;
			//			}
			if (startAbs == endAbs && lineOccupied == false) {
				for (int c = startOrd; c <= endOrd; c++) {
					grid[startAbs][c] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					//					shipSize++;
					if (c == endOrd) {
						returnTC1 = GridJ1(grid);			
						System.out.println("\nvous venez de placer votre "+boat+" !");
					}
				}
				for (int c = endOrd; c <= startOrd; c++) {
					grid[startAbs][c] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					//					shipSize++;
					if (c == startOrd) {
						returnTC1 = GridJ1(grid);			
						System.out.println("\nvous venez de placer votre "+boat+" !");
					}
				}
			}
			else if (startOrd == endOrd && lineOccupied == false) {
				for (int r = startAbs; r <= endAbs; r++) {
					grid[r][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					//					shipSize++;
					if (r == endAbs) {
						returnTC1 = GridJ1(grid);			
						System.out.println("\nvous venez de placer votre "+boat+" !");
					}
				}
				for (int r = endAbs; r <= startAbs; r++) {
					grid[r][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					//					shipSize++;
					if (r == startAbs) {
						returnTC1 = GridJ1(grid);			
						System.out.println("\nvous venez de placer votre "+boat+" !");
					}
				}
			}
		}
		return grid;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction d?termination position bateaux IA ---------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String[][] BoatPlaceIA(
			String[][] grid,
			String boat,
			int refBoat,
			int size, 
			String IABoat, 
			char IABoatAbs, 
			char IABoatAbs2, 
			char IABoatOrd) 
	{
		// d?claration des variables
		boolean rightStartAbscissa = false;
		boolean rightStartOrdinate = false;
		boolean rightEndAbscissa = false;
		boolean rightEndOrdinate = false;	
		boolean lineOccupied = false;
		boolean reLoop = true;
		boolean returnedIsHorizontal = false;
		boolean returnedIsVertical = false;
		boolean returnedIsRightLengthHor = false;
		boolean returnedIsRightLengthVer = false;
		// boucle tant que position du bateau pas bonne
		while (reLoop == true) {
			reLoop = false;
			lineOccupied = false;
			returnedIsHorizontal = false;
			returnedIsVertical = false;
			rightStartAbscissa = false;
			rightStartOrdinate = false;
			rightEndAbscissa = false;
			rightEndOrdinate = false;
			// boucle pour v?rifier si bateau pos? en vertical/horizontal et si bonne taille
			while ((!returnedIsHorizontal && !returnedIsVertical) || (!returnedIsRightLengthHor && !returnedIsRightLengthVer)) {
				returnedIsRightLengthHor = false;
				returnedIsRightLengthVer = false;
				returnedIsHorizontal = false;
				returnedIsVertical = false;
				rightStartAbscissa = false;
				rightStartOrdinate = false;
				rightEndAbscissa = false;
				rightEndOrdinate = false;
				// boucle pour choisir premi?re case du bateau
				while (!rightStartAbscissa || !rightStartOrdinate) {
					rightStartAbscissa = false;
					rightStartOrdinate = false;
					//interrogation du joueur sur case ? choisir
					Random random = new Random();
					int absIAStart = random.nextInt(((10-1)+1+1));
					int ordIAStart = random.nextInt(((10-1)+1+1));
					rightStartAbscissa = true;
					rightStartOrdinate = true;
					// d?termination de y (ordonn?e)
					if (rightStartAbscissa==true && rightStartOrdinate==true) {
						if (ordIAStart == 1) {startOrd = 10;}
						else if (ordIAStart == 2) {startOrd = 11;}
						else if (ordIAStart == 3) {startOrd = 12;}			
						else if (ordIAStart == 4) {startOrd = 13;}			
						else if (ordIAStart == 5) {startOrd = 14;}			
						else if (ordIAStart == 6) {startOrd = 15;}			
						else if (ordIAStart == 7) {startOrd = 16;}			
						else if (ordIAStart == 8) {startOrd = 17;}			
						else if (ordIAStart == 9) {startOrd = 18;}			
						else if (ordIAStart == 10) {startOrd = 19;}
						// d?termination de x (abscisse)
						if (absIAStart == 1) {startAbs = 0;}
						else if (absIAStart == 2) {startAbs = 1;}
						else if (absIAStart == 3) {startAbs = 2;}			
						else if (absIAStart == 4) {startAbs = 3;}			
						else if (absIAStart == 5) {startAbs = 4;}			
						else if (absIAStart == 6) {startAbs = 5;}			
						else if (absIAStart == 7) {startAbs = 6;}			
						else if (absIAStart == 8) {startAbs = 7;}			
						else if (absIAStart == 9) {startAbs = 8;}			
						else if (absIAStart == 10) {startAbs = 9;}
						if (
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
								(grid[startAbs][startOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
								) {
							rightStartAbscissa = false;
							rightStartOrdinate = false;
						}
						// renvoie de la grille au joueur 
						else {
							grid[startAbs][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
						}
					}
				}
				// boucle pour choisir derni?re case du bateau (meme logique que la premi?re)
				while (!rightEndAbscissa || !rightEndOrdinate) {
					rightEndAbscissa = false;
					rightEndOrdinate = false;
					Random random = new Random();
					int absIAEnd = random.nextInt(((10-1)+1+1));
					int ordIAEnd = random.nextInt(((10-1)+1+1));
					rightEndAbscissa = true;
					rightEndOrdinate = true;
					// d?termination de y (ordonn?e)
					if (rightEndAbscissa==true && rightEndOrdinate==true) {
						if (ordIAEnd == 1) {endOrd = 10;}
						else if (ordIAEnd == 2) {endOrd = 11;}
						else if (ordIAEnd == 3) {endOrd = 12;}			
						else if (ordIAEnd == 4) {endOrd = 13;}			
						else if (ordIAEnd == 5) {endOrd = 14;}			
						else if (ordIAEnd == 6) {endOrd = 15;}			
						else if (ordIAEnd == 7) {endOrd = 16;}			
						else if (ordIAEnd == 8) {endOrd = 17;}			
						else if (ordIAEnd == 9) {endOrd = 18;}			
						else if (ordIAEnd == 10) {endOrd = 19;}
						// d?termination de x (abscisse)
						if (absIAEnd == 1) {endAbs = 0;}
						else if (absIAEnd == 2) {endAbs = 1;}
						else if (absIAEnd == 3) {endAbs = 2;}			
						else if (absIAEnd == 4) {endAbs = 3;}			
						else if (absIAEnd == 5) {endAbs = 4;}			
						else if (absIAEnd == 6) {endAbs = 5;}			
						else if (absIAEnd == 7) {endAbs = 6;}			
						else if (absIAEnd == 8) {endAbs = 7;}			
						else if (absIAEnd == 9) {endAbs = 8;}			
						else if (absIAEnd == 10) {endAbs = 9;}
						if (
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
								(grid[endAbs][endOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
								) {
							rightEndAbscissa = false;
							rightEndOrdinate = false;
						}
					}
				}
				// v?rification que les 2 coordonn?es saisies sont bien sur la meme verticale/horizontale
				returnedIsHorizontal = isHorizontal (startAbs, endAbs, isHorizontalRight);
				returnedIsVertical = isVertical (startOrd, endOrd, isVerticalRight);
				if (returnedIsHorizontal==false && returnedIsVertical==false) {
					//					System.err.println("vous avez mal plac? votre b?teau !\n");
					grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
					grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
				}
				// v?rification que les 2 coordonn?es sont de la bonne taille de bateau
				returnedIsRightLengthHor = isRightLengthHor (startAbs, endAbs, isRightLengthHor,size);
				returnedIsRightLengthVer = isRightLengthVer (startOrd, endOrd, isRightLengthVer,size);
				if (returnedIsRightLengthHor==false && returnedIsRightLengthVer==false) {
					grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
				}
			}
			// v?rification que position du bateau choisie ne croise pas un autre bateau
			if (startAbs == endAbs) {
				for (int c = startOrd+1; c <= endOrd-1; c++) {
					if (grid[startAbs][c] != empty) {
						lineOccupied = true;
						reLoop = true;
						grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
						grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
					}
				}
			}
			else if (startOrd == endOrd) {
				for (int r = startAbs+1; r <= endAbs-1; r++) {
					if (grid[r][startOrd] != empty) {
						lineOccupied = true;	
						reLoop = true;
						grid[startAbs][startOrd] = ANSI_RESET+empty+ANSI_RESET;
						grid[endAbs][endOrd] = ANSI_RESET+empty+ANSI_RESET;
					}
				}
			}
			if (startAbs == endAbs && lineOccupied == false) {
				for (int c = startOrd; c <= endOrd; c++) {
					grid[startAbs][c] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					if (c == endOrd) {
					}
				}
				for (int c = endOrd; c <= startOrd; c++) {
					grid[startAbs][c] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					if (c == startOrd) {
					}
				}
			}
			else if (startOrd == endOrd && lineOccupied == false) {
				for (int r = startAbs; r <= endAbs; r++) {
					grid[r][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					if (r == endAbs) {
					}
				}
				for (int r = endAbs; r <= startAbs; r++) {
					grid[r][startOrd] = ANSI_WHITE_BACKGROUND+refBoat+ANSI_RESET;
					if (r == startAbs) {
					}
				}
			}
		}
		return grid;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonctions d?terminer case a cibler par joueur1 -----------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String [][] targetP1 (String[][]gridP1, String[][]gridIA) {

		// interroger joueur sur la case a cibler
		boolean rightTargetOrdinate = false;
		boolean rightTargetAbscissa = false;
		while (!rightTargetAbscissa || !rightTargetOrdinate) {
			rightTargetAbscissa = false;
			rightTargetOrdinate = false;
			temp3 = " ";
			System.out.println("\nchoisissez la case que vous voulez cibler : (exemple "+ORD_A+ABS_1+", "+ORD_B+ABS_2+", ...) : ");
			playerTarget = scanInput.nextLine();
			//			System.out.println("playerTarget : "+playerTarget);
			// conversion de la saisie en char
			try {
				p1TargetOrd = playerTarget.charAt(0);
				temp1 = Character.toString(p1TargetOrd);	
				p1TargetAbs = playerTarget.charAt(1);
				temp2 = Character.toString(p1TargetAbs);				
				p1TargetAbs2 = playerTarget.charAt(2); 
				temp3 = Character.toString(p1TargetAbs2);	}
			catch (StringIndexOutOfBoundsException e) {
			}
			// v?rifier que saisie est bien une des cases de la grille
			try {
				if	(
						!temp1.equalsIgnoreCase(ORD_A) && 
						!temp1.equalsIgnoreCase(ORD_B) && 
						!temp1.equalsIgnoreCase(ORD_C) && 
						!temp1.equalsIgnoreCase(ORD_D) && 
						!temp1.equalsIgnoreCase(ORD_E) && 
						!temp1.equalsIgnoreCase(ORD_F) && 
						!temp1.equalsIgnoreCase(ORD_G) && 
						!temp1.equalsIgnoreCase(ORD_H) && 
						!temp1.equalsIgnoreCase(ORD_I) && 
						!temp1.equalsIgnoreCase(ORD_J)) 
				{
					System.err.println("erreur dans la saisie de l'ordonn?e (A, B, ...)\n");
				}
				else {
					rightTargetOrdinate = true;
				}
				if (
						(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_2) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_3) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_4) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_5) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_6) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_7) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_8) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_9) || !temp3.equalsIgnoreCase(" ")) &&
						(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase("0")))
				{
					System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
				}
				else 
				{
					rightTargetAbscissa = true;
				}
			}
			catch (NullPointerException e){
				//					System.out.println("NullPointerException");
				System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
				//					e.printStackTrace();
			}
			// d?termination de y (ordonn?e)
			if (rightTargetAbscissa==true && rightTargetOrdinate==true) {
				System.out.println("case s?lectionn?e : "+playerTarget+"\n");
				if (temp1.equalsIgnoreCase(ORD_A)) {targetOrd = 10;}
				else if (temp1.equalsIgnoreCase(ORD_B)) {targetOrd = 11;}
				else if (temp1.equalsIgnoreCase(ORD_C)) {targetOrd = 12;}			
				else if (temp1.equalsIgnoreCase(ORD_D)) {targetOrd = 13;}			
				else if (temp1.equalsIgnoreCase(ORD_E)) {targetOrd = 14;}			
				else if (temp1.equalsIgnoreCase(ORD_F)) {targetOrd = 15;}			
				else if (temp1.equalsIgnoreCase(ORD_G)) {targetOrd = 16;}			
				else if (temp1.equalsIgnoreCase(ORD_H)) {targetOrd = 17;}			
				else if (temp1.equalsIgnoreCase(ORD_I)) {targetOrd = 18;}			
				else if (temp1.equalsIgnoreCase(ORD_J)) {targetOrd = 19;}
				// d?termination de x (abscisse)
				if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase(" ")) {targetAbs = 0;}
				else if (temp2.equalsIgnoreCase(ABS_2) && temp3.equalsIgnoreCase(" ")) {targetAbs = 1;}
				else if (temp2.equalsIgnoreCase(ABS_3) && temp3.equalsIgnoreCase(" ")) {targetAbs = 2;}			
				else if (temp2.equalsIgnoreCase(ABS_4) && temp3.equalsIgnoreCase(" ")) {targetAbs = 3;}			
				else if (temp2.equalsIgnoreCase(ABS_5) && temp3.equalsIgnoreCase(" ")) {targetAbs = 4;}			
				else if (temp2.equalsIgnoreCase(ABS_6) && temp3.equalsIgnoreCase(" ")) {targetAbs = 5;}			
				else if (temp2.equalsIgnoreCase(ABS_7) && temp3.equalsIgnoreCase(" ")) {targetAbs = 6;}			
				else if (temp2.equalsIgnoreCase(ABS_8) && temp3.equalsIgnoreCase(" ")) {targetAbs = 7;}			
				else if (temp2.equalsIgnoreCase(ABS_9) && temp3.equalsIgnoreCase(" ")) {targetAbs = 8;}			
				else if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase("0")) {targetAbs = 9;}
				//				System.out.println("targetOrd : "+targetOrd);
				//				System.out.println("targetAbs : "+targetAbs);

				// si case d?j? prise
				if (
						(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET)) ||
						(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_CYAN+FLOADED+ANSI_RESET)) 
						) {
					System.err.println("cette case a d?j? ?t? selectionn?e !\n");
					rightTargetAbscissa = false;
					rightTargetOrdinate = false;
				}
			}
		}
		//si dans l'eau
		if (
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_RESET+empty+ANSI_RESET)) ||
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(empty))
				)
		{
			System.out.println("dans l'eau !\n");
			gridIA[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
			gridP1[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
			// renvoie de la grille au joueur 
			returnTC2 = GridJ1(gridP1);	
			//			returnTC2 = GridIA(gridIA);			
		}
		// si bateau, dire si bateau coul? ou non en scannant tableau et plus de valeur 1 ou 2 ou ...
		else if (
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
				(gridIA[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
				){
			System.out.println("touch? !\n");
			gridIA[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
			gridP1[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
			// renvoie de la grille au joueur 
			returnTC2 = GridJ1(gridP1);	
			//			returnTC2 = GridIA(gridIA);			

			// scanner array pour voir si bateau coul? ou non
			if (returnedIsIAB1Dead==false) {
				returnedIsIAB1Dead = isBoatDead (gridIA, isIAB1Dead, BOAT1, REF_BOAT1, IA);}
			if (returnedIsIAB2Dead==false) {
				returnedIsIAB2Dead = isBoatDead (gridIA, isIAB2Dead, BOAT2, REF_BOAT2, IA);}
			if (returnedIsIAB3Dead==false) {
				returnedIsIAB3Dead = isBoatDead (gridIA, isIAB3Dead, BOAT3, REF_BOAT3, IA);}
			if (returnedIsIAB4Dead==false) {
				returnedIsIAB4Dead = isBoatDead (gridIA, isIAB4Dead, BOAT4, REF_BOAT4, IA);}
			if (returnedIsIAB5Dead==false) {
				returnedIsIAB5Dead = isBoatDead (gridIA, isIAB5Dead, BOAT5, REF_BOAT5, IA);}

		}
		else {
			System.out.println("une erreur s'est produite");
		}
		return gridP1;
	}	

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonctions d?terminer case a cibler par IA ----------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String [][] targetIA (String[][]gridIA, String[][]gridP1) {

		// interrogerIA sur la case a cibler
		boolean rightTargetOrdinateIA = false;
		boolean rightTargetAbscissaIA = false;
		while (!rightTargetAbscissaIA || !rightTargetOrdinateIA) {
			Random random = new Random();
			int absIATarget = random.nextInt((10-1)+1)+1;
			int ordIATarget = random.nextInt((10-1)+1)+1;
			rightTargetOrdinateIA = true;
			rightTargetAbscissaIA = true;
			// d?termination de y (ordonn?e
			if (rightTargetAbscissaIA==true && rightTargetOrdinateIA==true) {				if (ordIATarget == 1) {targetOrd = 0; y = ORD_A;}
				else if (ordIATarget == 2) {targetOrd = 1; y = ORD_B;}
				else if (ordIATarget == 3) {targetOrd = 2; y = ORD_C;}			
				else if (ordIATarget == 4) {targetOrd = 3; y = ORD_D;}			
				else if (ordIATarget == 5) {targetOrd = 4; y = ORD_E;}			
				else if (ordIATarget == 6) {targetOrd = 5; y = ORD_F;}			
				else if (ordIATarget == 7) {targetOrd = 6; y = ORD_G;}			
				else if (ordIATarget == 8) {targetOrd = 7; y = ORD_H;}			
				else if (ordIATarget == 9) {targetOrd = 8; y = ORD_I;}			
				else if (ordIATarget == 10) {targetOrd = 9; y = ORD_J;}
				// d?termination de x (abscisse)
				if (absIATarget == 1) {targetAbs = 0; x = ABS_1;}
				else if (absIATarget == 2) {targetAbs = 1; x = ABS_2;}
				else if (absIATarget == 3) {targetAbs = 2; x = ABS_3;}			
				else if (absIATarget == 4) {targetAbs = 3; x = ABS_4;}			
				else if (absIATarget == 5) {targetAbs = 4; x = ABS_5;}			
				else if (absIATarget == 6) {targetAbs = 5; x = ABS_6;}			
				else if (absIATarget == 7) {targetAbs = 6; x = ABS_7;}			
				else if (absIATarget == 8) {targetAbs = 7; x = ABS_8;}			
				else if (absIATarget == 9) {targetAbs = 8; x = ABS_9;}			
				else if (absIATarget == 10) {targetAbs = 9; x = ABS_10;}


				//				System.out.println("absIATarget : "+absIATarget);
				//				System.out.println("targetAbs : "+targetAbs);
				//				System.out.println("ordIATarget : "+ordIATarget);
				//				System.out.println("targetOrd : "+targetOrd);

				// si case d?j? prise
				if (
						(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET)) ||
						(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_CYAN+FLOADED+ANSI_RESET)) 
						) {					//
					//					System.err.println("cette case a d?j? ?t? selectionn?e !\n");
					rightTargetAbscissaIA = false;
					rightTargetOrdinateIA = false;
				}
			}
		}
		System.out.println("IA vient de jouer : "+y+x+"\n");
		//si dans l'eau
		if (
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_RESET+empty+ANSI_RESET) ||
						(gridP1[targetAbs][targetOrd].equalsIgnoreCase(empty)) 
						))
		{
			System.out.println("dans l'eau !\n");
			gridP1[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
			gridIA[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
			//					System.out.println("x : "+startAbs+", y : "+startOrd);
			// renvoie du choix de IA
			returnTC2 = GridJ1(gridP1);	
			//			returnTC2 = GridIA(gridIA);			
		}
		// si bateau, dire si bateau coul? ou non en scannant tableau et plus de valeur 1 ou 2 ou ...
		else if (
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
				(gridP1[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
				){
			System.out.println("touch? !\n");
			gridP1[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
			gridIA[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
			//					System.out.println("x : "+startAbs+", y : "+startOrd);
			// renvoie de la grille au joueur 
			returnTC2 = GridJ1(gridP1);	
			//			returnTC2 = GridIA(gridIA);			

			// scanner array pour voir si bateau coul? ou non
			if (returnedIsP1B1Dead==false) {
				returnedIsP1B1Dead = isBoatDead (gridP1, isP1B1Dead, BOAT1, REF_BOAT1,PLAYER1);}
			if (returnedIsP1B2Dead==false) {
				returnedIsP1B2Dead = isBoatDead (gridP1, isP1B2Dead, BOAT2, REF_BOAT2,PLAYER1);}
			if (returnedIsP1B3Dead==false) {
				returnedIsP1B3Dead = isBoatDead (gridP1, isP1B3Dead, BOAT3, REF_BOAT3,PLAYER1);}
			if (returnedIsP1B4Dead==false) {
				returnedIsP1B4Dead = isBoatDead (gridP1, isP1B4Dead, BOAT4, REF_BOAT4,PLAYER1);}
			if (returnedIsP1B5Dead==false) {
				returnedIsP1B5Dead = isBoatDead (gridP1, isP1B5Dead, BOAT5, REF_BOAT5,PLAYER1);}

		}
		else {
			//			System.out.println("une erreur s'est produite");
		}
		return gridIA;
	}	


	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonctions boolean si bateau sur ligne ou colonne ----------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static boolean isHorizontal (int startAbs, int endAbs, boolean isHorizontal) {
		if (startAbs==endAbs) {
			isHorizontal = true;
		}
		else {
			isHorizontal = false;
		}
		return isHorizontal;
	}



	public static boolean isVertical (int startOrd, int endOrd, boolean isVertical) {
		if (startOrd==endOrd) {
			isVertical = true;
		}
		else {
			isVertical = false;
		}
		return isVertical;
	}


	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonctions boolean si bateau sur ligne ou colonne ----------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static boolean isRightLengthHor (int startOrd, int endOrd, boolean isRightLengthOrd, int size) {
		if ((endOrd-startOrd==size-1) || endOrd-startOrd==-size+1) {
			isRightLengthOrd = true;
		}
		else {
			isRightLengthOrd = false;
		}
		return isRightLengthOrd;
	}


	public static boolean isRightLengthVer (int startAbs, int endAbs, boolean isRightLengthAbs, int size) {
		if ((endAbs-startAbs==size-1) || endAbs-startAbs==-size+1) {
			isRightLengthAbs = true;
		}
		else {
			isRightLengthAbs = false;
		}
		return isRightLengthAbs;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonctions boolean si bateau coul? ou non -----------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static boolean isBoatDead (String[][] grid, boolean isBoatDead, String nameBoat, int REF_BOAT, String player) {

		for(int i=0; i<grid.length; i++) { //loop through the array of arrays
			for(int j=0; j<grid[i].length; j++) { //loop through the sub-array array[i]
				if(grid[i][j].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT+ANSI_RESET)) {
					isBoatDead = false;
					break; //optimization not required
				}
				else {
					isBoatDead = true;
				}
			}
			if(isBoatDead == false) { //optimization not required
				break;
			}
		}
		if (isBoatDead == true) {
			System.out.println("\nle "+nameBoat+" de "+player+" est coul? ! \n");
		}
		//		System.out.println("le bateau "+refBoat+" est il debout ? " + isBoatALive ); //print the result
		return isBoatDead;
	}

	//---------------------------------------------------------------------------------------------------------	


	/*		System.out.println("\nvous devez maintenant d?terminer ou se trouvent vos 5 b?teaux de guerre sur cette grille.");

	for (int CASE1=0; CASE1<SIZE5; CASE1++) {
		System.out.println("position du "+BOAT1+" (taille de "+SIZE5+" cases) : ");
		boolean rightAbscissa = false;
		boolean rightOrdinate = false;
		while (!rightAbscissa || !rightOrdinate) {
			rightAbscissa = false;
			rightOrdinate = false;
			temp3 = " ";
			System.out.println("position de la case "+(CASE1+1)+" sur "+SIZE5+" : (exemple "+ORD_A+ABS_1+", "+ORD_B+ABS_2+", ...) : ");
			player1Boat1 = scanInput.nextLine();
			System.out.println(player1Boat1);
			p1b1ord = player1Boat1.charAt(0);
			temp1 = Character.toString(p1b1ord);
			p1b1abs = player1Boat1.charAt(1);
			temp2 = Character.toString(p1b1abs);
			try {
				p1b1abs2 = player1Boat1.charAt(2); 
				temp3 = Character.toString(p1b1abs2);}
			catch (StringIndexOutOfBoundsException e) {
				System.out.println("StringIndexOutOfBoundsException");
				e.printStackTrace();
			}
			if	(
					!temp1.equalsIgnoreCase(ORD_A) && 
					!temp1.equalsIgnoreCase(ORD_B) && 
					!temp1.equalsIgnoreCase(ORD_C) && 
					!temp1.equalsIgnoreCase(ORD_D) && 
					!temp1.equalsIgnoreCase(ORD_E) && 
					!temp1.equalsIgnoreCase(ORD_F) && 
					!temp1.equalsIgnoreCase(ORD_G) && 
					!temp1.equalsIgnoreCase(ORD_H) && 
					!temp1.equalsIgnoreCase(ORD_I) && 
					!temp1.equalsIgnoreCase(ORD_J)) 
			{
				System.err.println("erreur dans la saisie de l'ordonn?e (A, B, ...)");
			}
			else {
				rightOrdinate = true;
				//					System.out.println("rightOrdinate : "+rightOrdinate);
			}
			if (
					(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_2) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_3) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_4) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_5) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_6) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_7) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_8) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_9) || !temp3.equalsIgnoreCase(" ")) &&
					(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase("0")))
			{
				System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)");
			}
			else 
			{
				rightAbscissa = true;
				//					System.out.println("rightAbscissa : "+rightAbscissa);
			}
			// d?termination de y (ordonn?e)
			if (rightAbscissa==true && rightOrdinate==true) {
				System.out.println("case s?lectionn?e : "+player1Boat1);
				if (temp1.equalsIgnoreCase(ORD_A)) {
					y = 0;
				}
				else if (temp1.equalsIgnoreCase(ORD_B)) {
					y = 1;
				}
				else if (temp1.equalsIgnoreCase(ORD_C)) {
					y = 2;
				}			
				else if (temp1.equalsIgnoreCase(ORD_D)) {
					y = 3;
				}			
				else if (temp1.equalsIgnoreCase(ORD_E)) {
					y = 4;
				}			
				else if (temp1.equalsIgnoreCase(ORD_F)) {
					y = 5;
				}			
				else if (temp1.equalsIgnoreCase(ORD_G)) {
					y = 6;
				}			
				else if (temp1.equalsIgnoreCase(ORD_H)) {
					y = 7;
				}			
				else if (temp1.equalsIgnoreCase(ORD_I)) {
					y = 8;
				}			
				else if (temp1.equalsIgnoreCase(ORD_J)) {
					y = 9;
				}
				// d?termination de x (abscisse)
				if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase(" ")) {
					x = 0;
				}
				else if (temp2.equalsIgnoreCase(ABS_2) && temp3.equalsIgnoreCase(" ")) {
					x = 1;
				}
				else if (temp2.equalsIgnoreCase(ABS_3) && temp3.equalsIgnoreCase(" ")) {
					x = 2;
				}			
				else if (temp2.equalsIgnoreCase(ABS_4) && temp3.equalsIgnoreCase(" ")) {
					x = 3;
				}			
				else if (temp2.equalsIgnoreCase(ABS_5) && temp3.equalsIgnoreCase(" ")) {
					x = 4;
				}			
				else if (temp2.equalsIgnoreCase(ABS_6) && temp3.equalsIgnoreCase(" ")) {
					x = 5;
				}			
				else if (temp2.equalsIgnoreCase(ABS_7) && temp3.equalsIgnoreCase(" ")) {
					x = 6;
				}			
				else if (temp2.equalsIgnoreCase(ABS_8) && temp3.equalsIgnoreCase(" ")) {
					x = 7;
				}			
				else if (temp2.equalsIgnoreCase(ABS_9) && temp3.equalsIgnoreCase(" ")) {
					x = 8;
				}			
				else if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase("0")) {
					x = 9;
				}
				emptyGrid[x][y] = ANSI_WHITE_BACKGROUND+BOAT+ANSI_RESET;
				System.out.println("x : "+x+", y : "+y);
				tc1 = emptyGrid(emptyGrid);			
			}
		}
	}
	System.out.println("\nvous venez de placer votre "+BOAT1+" !");

	 */

	//---------------------------------------------------------------------------------------------------------	




	/*							
				// interroger joueur sur la case a cibler
				boolean rightTargetOrdinate = false;
				boolean rightTargetAbscissa = false;
				while (!rightTargetAbscissa || !rightTargetOrdinate) {
					rightTargetAbscissa = false;
					rightTargetOrdinate = false;
					temp3 = " ";
					System.out.println("\nchoisissez la case que vous voulez cibler : (exemple "+ORD_A+ABS_1+", "+ORD_B+ABS_2+", ...) : ");
					playerTarget = scanInput.nextLine();
					// conversion de la saisie en char
					try {
						p1TargetOrd = playerTarget.charAt(0);
						temp1 = Character.toString(p1TargetOrd);	
						p1TargetAbs = playerTarget.charAt(1);
						temp2 = Character.toString(p1TargetAbs);				
						p1TargetAbs2 = playerTarget.charAt(2); 
						temp3 = Character.toString(p1TargetAbs2);	}
					catch (StringIndexOutOfBoundsException e) {
					}
					// v?rifier que saisie est bien une des cases de la grille
					try {
						if	(
								!temp1.equalsIgnoreCase(ORD_A) && 
								!temp1.equalsIgnoreCase(ORD_B) && 
								!temp1.equalsIgnoreCase(ORD_C) && 
								!temp1.equalsIgnoreCase(ORD_D) && 
								!temp1.equalsIgnoreCase(ORD_E) && 
								!temp1.equalsIgnoreCase(ORD_F) && 
								!temp1.equalsIgnoreCase(ORD_G) && 
								!temp1.equalsIgnoreCase(ORD_H) && 
								!temp1.equalsIgnoreCase(ORD_I) && 
								!temp1.equalsIgnoreCase(ORD_J)) 
						{
							System.err.println("erreur dans la saisie de l'ordonn?e (A, B, ...)\n");
						}
						else {
							rightTargetOrdinate = true;
						}
						if (
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_2) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_3) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_4) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_5) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_6) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_7) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_8) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_9) || !temp3.equalsIgnoreCase(" ")) &&
								(!temp2.equalsIgnoreCase(ABS_1) || !temp3.equalsIgnoreCase("0")))
						{
							System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						}
						else 
						{
							rightTargetAbscissa = true;
						}
					}
					catch (NullPointerException e){
						//					System.out.println("NullPointerException");
						System.err.println("erreur dans la saisie de l'abscisse (1, 2, ...)\n");
						//					e.printStackTrace();
					}
					// d?termination de y (ordonn?e)
					if (rightTargetAbscissa==true && rightTargetOrdinate==true) {
						System.out.println("case s?lectionn?e : "+playerTarget+"\n");
						if (temp1.equalsIgnoreCase(ORD_A)) {targetOrd = 10;}
						else if (temp1.equalsIgnoreCase(ORD_B)) {targetOrd = 11;}
						else if (temp1.equalsIgnoreCase(ORD_C)) {targetOrd = 12;}			
						else if (temp1.equalsIgnoreCase(ORD_D)) {targetOrd = 13;}			
						else if (temp1.equalsIgnoreCase(ORD_E)) {targetOrd = 14;}			
						else if (temp1.equalsIgnoreCase(ORD_F)) {targetOrd = 15;}			
						else if (temp1.equalsIgnoreCase(ORD_G)) {targetOrd = 16;}			
						else if (temp1.equalsIgnoreCase(ORD_H)) {targetOrd = 17;}			
						else if (temp1.equalsIgnoreCase(ORD_I)) {targetOrd = 18;}			
						else if (temp1.equalsIgnoreCase(ORD_J)) {targetOrd = 19;}
						// d?termination de x (abscisse)
						if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase(" ")) {targetAbs = 0;}
						else if (temp2.equalsIgnoreCase(ABS_2) && temp3.equalsIgnoreCase(" ")) {targetAbs = 1;}
						else if (temp2.equalsIgnoreCase(ABS_3) && temp3.equalsIgnoreCase(" ")) {targetAbs = 2;}			
						else if (temp2.equalsIgnoreCase(ABS_4) && temp3.equalsIgnoreCase(" ")) {targetAbs = 3;}			
						else if (temp2.equalsIgnoreCase(ABS_5) && temp3.equalsIgnoreCase(" ")) {targetAbs = 4;}			
						else if (temp2.equalsIgnoreCase(ABS_6) && temp3.equalsIgnoreCase(" ")) {targetAbs = 5;}			
						else if (temp2.equalsIgnoreCase(ABS_7) && temp3.equalsIgnoreCase(" ")) {targetAbs = 6;}			
						else if (temp2.equalsIgnoreCase(ABS_8) && temp3.equalsIgnoreCase(" ")) {targetAbs = 7;}			
						else if (temp2.equalsIgnoreCase(ABS_9) && temp3.equalsIgnoreCase(" ")) {targetAbs = 8;}			
						else if (temp2.equalsIgnoreCase(ABS_1) && temp3.equalsIgnoreCase("0")) {targetAbs = 9;}
						//					System.out.println("targetOrd : "+targetOrd);
						//					System.out.println("targetAbs : "+targetAbs);

						// si case d?j? prise
						if (
								(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET)) ||
								(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_CYAN+FLOADED+ANSI_RESET)) 
								) {
							System.err.println("cette case a d?j? ?t? selectionn?e !\n");
							rightTargetAbscissa = false;
							rightTargetOrdinate = false;
						}
					}
				}
				//si dans l'eau
				if (
						IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_RESET+empty+ANSI_RESET))
				{
					System.out.println("dans l'eau !\n");
					IAb5[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
					p1b5[targetAbs][targetOrd] = ANSI_CYAN+FLOADED+ANSI_RESET;
					//					System.out.println("x : "+startAbs+", y : "+startOrd);
					// renvoie de la grille au joueur 
					returnTC2 = GridJ1(p1b5);	
					returnTC2 = GridIA(IAb5);			
				}
				// si bateau, dire si bateau coul? ou non en scannant tableau et plus de valeur 1 ou 2 ou ...
				else if (
						(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT1+ANSI_RESET)) ||
						(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT2+ANSI_RESET)) ||
						(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT3+ANSI_RESET)) ||
						(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT4+ANSI_RESET)) ||
						(IAb5[targetAbs][targetOrd].equalsIgnoreCase(ANSI_WHITE_BACKGROUND+REF_BOAT5+ANSI_RESET)) 
						){
					System.out.println("touch? !\n");
					IAb5[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
					p1b5[targetAbs][targetOrd] = ANSI_WHITE_BACKGROUND+ANSI_RED+TOUCHED+ANSI_RESET;
					//					System.out.println("x : "+startAbs+", y : "+startOrd);
					// renvoie de la grille au joueur 
					returnTC2 = GridJ1(p1b5);	
					returnTC2 = GridIA(IAb5);			

					// scanner array pour voir si bateau coul? ou non
					if (returnedIsP1B1Dead==false) {
						returnedIsP1B1Dead = isBoatDead (IAb5, isP1B1Dead, BOAT1, REF_BOAT1, IA);}
					if (returnedIsP1B2Dead==false) {
						returnedIsP1B2Dead = isBoatDead (IAb5, isP1B2Dead, BOAT2, REF_BOAT2, IA);}
					if (returnedIsP1B3Dead==false) {
						returnedIsP1B3Dead = isBoatDead (IAb5, isP1B3Dead, BOAT3, REF_BOAT3, IA);}
					if (returnedIsP1B4Dead==false) {
						returnedIsP1B4Dead = isBoatDead (IAb5, isP1B4Dead, BOAT4, REF_BOAT4, IA);}
					if (returnedIsP1B5Dead==false) {
						returnedIsP1B5Dead = isBoatDead (IAb5, isP1B5Dead, BOAT5, REF_BOAT5, IA);}

				}
				else {
					System.out.println("erreur ni eau ni bateau");
				}
				firstPlayer=1;
			}	 		*/		 













}
