package fr.ibformation.exos.bonus;

import java.util.Random;
import java.util.Scanner;

public class LauncherMastermind {


	//	public static Scanner scanners = new Scanner (System.in);


	public static final String COLOR_V= "v", 
			COLOR_J="j",
			COLOR_B="b", 
			COLOR_R="r", 
			COLOR_N="n";


	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction random selection of guessNumbers ----------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static String Random () {
		Random r = new Random();
		int numberIA = r.nextInt((4-0)+1)+0;
		String color = "";
		if (numberIA==0) {
			color = "v";
		}
		else if (numberIA==1) {
			color = "j";
		}
		else if (numberIA==2) {
			color = "b";
		}
		else if (numberIA==3) {
			color = "r";
		}
		else if (numberIA==4) {
			color = "n";
		}
		else 	{			
			System.out.println("erreur de saisie de l'ordinateur");
		}
		return color;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction errors ------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	public static void Errors(String input, String colorV, String colorJ, String colorB, String colorR, String colorN) {
		if (!input.equals(colorV) && !input.equals(colorJ) && !input.equals(colorB) && !input.equals(colorR) && !input.equals(colorN)){
			System.out.println("vous avez fait une erreur dans votre saisie");
		}
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction selection of inputNumbers ----------------------------------------
	//---------------------------------------------------------------------------------------------------------		

	public static String inputSymbols (String colorV, String colorJ, String colorB, String colorR, String colorN) {
		Scanner scannerInput = new Scanner (System.in);
		String input = scannerInput.nextLine();
		do  {
			if (
					!input.equals(colorV) && 
					!input.equals(colorJ) && 
					!input.equals(colorB) && 
					!input.equals(colorR) && 
					!input.equals(colorN)){
				System.out.println("vous avez fait une erreur dans votre saisie");
			}
		}
		while (
				!input.equals(colorV) && 
				!input.equals(colorJ) && 
				!input.equals(colorB) && 
				!input.equals(colorR) && 
				!input.equals(colorN));
		return input;
	}

	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction counters of points ------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------

	// --------------------- comparaison 1er symbole ----------------------------------------------------------

	public static int[] Counters0(
			String inputColors0Returned, 
			String color0Returned,
			String color1Returned,
			String color2Returned,
			String color3Returned) {

		int[]colorCount = new int[] {0,0,0,0,0,0,0,0};

		if (inputColors0Returned.equals(color0Returned)) {
			colorCount[4] = colorCount[4] +1;
			colorCount[0]=0;
		}
		else if (
				(inputColors0Returned.equals(color1Returned) && colorCount[1]==0) && colorCount[5]==0) {
			colorCount[1] = colorCount[1] +1;
		}
		else if (
				(inputColors0Returned.equals(color2Returned) && colorCount[2]==0) && colorCount[6]==0) {
			colorCount[2] = colorCount[2] +1;
		}
		else if (
				(inputColors0Returned.equals(color3Returned) && colorCount[3]==0) && colorCount[7]==0) {
			colorCount[3] = colorCount[3] +1;
		}
		/*	else {
			colorCount[0]=0;
			colorCount[1]=0;
			colorCount[2]=0;
			colorCount[3]=0;
		}*/
		System.out.println("1colorCount[0] : " +colorCount[0]);
		System.out.println("1colorCount[1] : " +colorCount[1]);
		System.out.println("1colorCount[2] : " +colorCount[2]);
		System.out.println("1colorCount[3] : " +colorCount[3]);
		System.out.println("1colorCount[4]place+color : " +colorCount[4]);
		System.out.println("1colorCount[5]place+color : " +colorCount[5]);
		System.out.println("1colorCount[6]place+color : " +colorCount[6]);
		System.out.println("1colorCount[7]place+color : " +colorCount[7]);

		return colorCount;
	}

	// --------------------- comparaison 2eme symbole ----------------------------------------------------------

	public static int[] Counters1 (
			String inputColors1Returned, 
			String color0Returned,
			String color1Returned,
			String color2Returned,
			String color3Returned, int[]Counters) {

		if (inputColors1Returned.equals(color1Returned)) {
			Counters[5] = Counters[5] +1;
			Counters[1]=0;
		}
		else if (
				(inputColors1Returned.equals(color0Returned) && Counters[0]==0) && Counters[4]==0) {
			Counters[0] = Counters[0] +1;
		}
		else if (
				(inputColors1Returned.equals(color2Returned) && Counters[2]==0) && Counters[6]==0) {
			Counters[2] = Counters[2] +1;
		}
		else if (
				(inputColors1Returned.equals(color3Returned) && Counters[3]==0) && Counters[7]==0) {
			Counters[3] = Counters[3] +1;
		}
		/*	else {
			Counters[0]=0;
			Counters[1]=0;
			Counters[2]=0;
			Counters[3]=0;
		}*/
		System.out.println("2Counters[0] : " +Counters[0]);
		System.out.println("2Counters[1] : " +Counters[1]);
		System.out.println("2Counters[2] : " +Counters[2]);
		System.out.println("2Counters[3] : " +Counters[3]);
		System.out.println("2Counters[4]place+color : " +Counters[4]);
		System.out.println("2Counters[5]place+color : " +Counters[5]);
		System.out.println("2Counters[6]place+color : " +Counters[6]);
		System.out.println("2Counters[7]place+color : " +Counters[7]);

		return Counters;
	}

	// --------------------- comparaison 3eme symbole ----------------------------------------------------------

	public static int[] Counters2 (
			String inputColors2Returned, 
			String color0Returned,
			String color1Returned,
			String color2Returned,
			String color3Returned, int[]Counters1) {

		if (inputColors2Returned.equals(color2Returned)) {
			Counters1[6] = Counters1[6] +1;
			Counters1[2]=0;
		}
		else if (inputColors2Returned.equals(color0Returned) && Counters1[0]==0 && Counters1[4]==0) {
			Counters1[0] = Counters1[0] +1;
		}
		else if (inputColors2Returned.equals(color1Returned) && Counters1[1]==0 && Counters1[5]==0) {
			Counters1[1] = Counters1[1] +1;
		}
		else if (inputColors2Returned.equals(color3Returned) && Counters1[3]==0 && Counters1[7]==0) {
			Counters1[3] = Counters1[3] +1;
		}
		/*		else {
			Counters1[0]=0;
			Counters1[1]=0;
			Counters1[2]=0;
			Counters1[3]=0;
		}	*/
		System.out.println("3Counters[0] : " +Counters1[0]);
		System.out.println("3Counters[1] : " +Counters1[1]);
		System.out.println("3Counters[2] : " +Counters1[2]);
		System.out.println("3Counters[3] : " +Counters1[3]);
		System.out.println("3Counters[4]place+color : " +Counters1[4]);
		System.out.println("3Counters[5]place+color : " +Counters1[5]);
		System.out.println("3Counters[6]place+color : " +Counters1[6]);
		System.out.println("3Counters[7]place+color : " +Counters1[7]);

		return Counters1;
	}

	// --------------------- comparaison 4eme symbole ----------------------------------------------------------

	public static int[] Counters3 (
			String inputColors3Returned, 
			String color0Returned,
			String color1Returned,
			String color2Returned,
			String color3Returned, int[]Counters2) {

		if (inputColors3Returned.equals(color3Returned)) {
			Counters2[7] = Counters2[7] +1;
			Counters2[3]=0;
		}
		else if (inputColors3Returned.equals(color0Returned) && Counters2[0]==0 && Counters2[4]==0) {
			Counters2[0] = Counters2[0] +1;
		}
		else if (inputColors3Returned.equals(color1Returned) && Counters2[1]==0 && Counters2[5]==0) {
			Counters2[1] = Counters2[1] +1;
		}
		else if (inputColors3Returned.equals(color2Returned) && Counters2[2]==0 && Counters2[6]==0) {
			Counters2[2] = Counters2[2] +1;
		}
		/*	else {
			Counters2[0]=0;
			Counters2[1]=0;
			Counters2[2]=0;
			Counters2[3]=0;
		}	*/
		System.out.println("4Counters[0] : " +Counters2[0]);
		System.out.println("4Counters[1] : " +Counters2[1]);
		System.out.println("4Counters[2] : " +Counters2[2]);
		System.out.println("4Counters[3] : " +Counters2[3]);
		System.out.println("4Counters[4]place+color : " +Counters2[4]);
		System.out.println("4Counters[5]place+color : " +Counters2[5]);
		System.out.println("4Counters[6]place+color : " +Counters2[6]);
		System.out.println("4Counters[7]place+color : " +Counters2[7]);

		return Counters2;
	}

	//---------------------------------------------------------------------------------------------------------


	public static void main(String[] args) {
		/* ?Mastermind
				?Mastermind (avec tableau ou avec la classe String)
				Coder un jeu de mastermind standard ou le but est de d?couvrir une combinaison secr?te de 4 symboles	*/


		// annonce des r?gles
		System.out.println("Bienvenue dans le jeu de Mastermind ! \n\n Le but est de deviner, par d?ductions successives, la couleur et la position de 4 symboles cach?s et d?termin?s par l'ordinateur, parmis 5 couleurs possibles que sont Vert/Jaune/Bleu/Rouge/Noir.  Si l'un des symboles correspond par sa position et sa couleur ? un symbole cach?, ou si l'un des pions correspond uniquement par sa couleur, l'ordinateur vous l'indiquera. S'il n'y a aucune correspondance, il ne marque rien. Si vous arrivez, au bout de 15 coups oun moins, ? placer les 4 symboles qui correspondent exactement par la couleur et la position ? ceux du code de l'ordinateur, vous avez gagn? ! \n");
		// d?claration des variables que sont les 4 couleurs ? deviner, et les 4 couleurs d?finis par l'utilisateur
		// attribution des variables
		boolean retry = true;
		Scanner scanners = new Scanner (System.in);
		// boucle pour relancer le jeu
		do {
			boolean isCombFound = false;
			int iteration =0;
			int rightPlaceAndColor = 0;	
			int onlyRightColor = 0;

			// random selection des 4 variables par l'IA
			String color0Returned = Random ();
			String color1Returned = Random ();
			String color2Returned = Random ();
			String color3Returned = Random ();
			//	String color0Returned = "v";String color1Returned = "r";String color2Returned = "v";String color3Returned = "r";
			System.out.println("saisie de l'ordinateur : [ "+color0Returned+" , "+color1Returned+" , "+color2Returned+" , "+color3Returned+" ] ");	

			// boucle tant que l'user n'a pas les 4 bonnes couleurs
			// limiter la boucle ? 15 tours
			// interroger utilisateur sur les variables
			System.out.println("saisissez votre combinaison de couleurs une par une (Vert = v; Bleu = b; jaune = j; rouge = r; noir = n) : ");
			for (iteration=0;  !isCombFound && iteration<15; iteration++) {
				rightPlaceAndColor = 0;
				System.out.println("Votre saisie : [ ");
				String inputColors0Returned = inputSymbols (COLOR_V,COLOR_J,COLOR_B,COLOR_R, COLOR_N);
				System.out.println("Votre saisie : [ "+
						inputColors0Returned+" , ");

				String inputColors1Returned = inputSymbols (COLOR_V,COLOR_J,COLOR_B,COLOR_R, COLOR_N);
				System.out.println("Votre saisie : [ "+
						inputColors0Returned+" , "+inputColors1Returned+" , ");

				String inputColors2Returned = inputSymbols (COLOR_V,COLOR_J,COLOR_B,COLOR_R, COLOR_N);
				System.out.println("Votre saisie : [ "+
						inputColors0Returned+" , "+inputColors1Returned+" , "+
						inputColors2Returned+" , ");

				String inputColors3Returned = inputSymbols (COLOR_V,COLOR_J,COLOR_B,COLOR_R, COLOR_N);
				System.out.println("Votre saisie : [ "+
						inputColors0Returned+" , "+inputColors1Returned+" , "+
						inputColors2Returned+" , "+inputColors3Returned+" ]");

				// comparaison de la combinaison de l'utilisateur et de l'ordinateur
				int [] Counters = Counters0 (inputColors0Returned,color0Returned,color1Returned,color2Returned,color3Returned);
				/*  System.out.println(Counters[0]);System.out.println(Counters[1]);System.out.println(Counters[2]);
					System.out.println(Counters[3]);System.out.println(Counters[4]);*/
				int [] Counters1 = Counters1 (inputColors1Returned,color0Returned,color1Returned,color2Returned,color3Returned,Counters);
				/*	System.out.println(Counters1[0]);System.out.println(Counters1[1]);System.out.println(Counters1[2]);
					System.out.println(Counters1[3]);System.out.println(Counters1[4]);*/
				int [] Counters2 = Counters2 (inputColors2Returned,color0Returned,color1Returned,color2Returned,color3Returned,Counters1);
				/*	System.out.println(Counters2[0]);System.out.println(Counters2[1]);System.out.println(Counters2[2]);
					System.out.println(Counters2[3]);System.out.println(Counters2[4]);*/
				int [] Counters3 = Counters3 (inputColors3Returned,color0Returned,color1Returned,color2Returned,color3Returned,Counters2);
				/*	System.out.println(Counters3[0]);System.out.println(Counters3[1]);System.out.println(Counters3[2]);
					System.out.println(Counters3[3]);System.out.println(Counters3[4]);*/

				onlyRightColor = (Counters3[0]+Counters3[1]+Counters3[2]+Counters3[3]);
				rightPlaceAndColor = (Counters3[4]+Counters3[5]+Counters3[6]+Counters3[7]);
				System.out.println("\nnombre de pions avec une couleur et une position correctes\t : "+ rightPlaceAndColor);
				System.out.println("nombre de pions avec uniquement une couleur correcte\t\t : "+ onlyRightColor+"\n");

				if (rightPlaceAndColor==4) {
					isCombFound=true;
				}
			}
			// si mauvais retour dans la boucle
			// si ok, fin de boucle
			// informer l'utilisateur qu'il a gagn? avec le r?sultat
			if (rightPlaceAndColor==4) {
				System.out.println("F?licitation ! vous avez trouv? le bonne combinaison en "+(iteration)+" coup(s).");
			}
			else if (rightPlaceAndColor<4) {
				System.out.println("Vous n'avez pas trouv? le bonne combinaison, vous avez perdu !");
			}
			else {
				System.out.println("une erreur s'est produite");
			}
			// boucle pour relancer ou non le programme
			System.out.println("\nvoulez vous rejouer ? (true/false)");
			retry = scanners.nextBoolean();
			if (retry == true) {
				System.out.println("bienvenue dans une nouvelle partie de Mastermind ! \n");
			}
			else if (retry == false){
				System.out.println("A bient?t pour une nouvelle partie !");
				scanners.close();
				retry=false;
			}
		}
		while (retry);
	}
}







/*
onlyRightColor = 0;
boolean color0Found = false; 
boolean color1Found = false; 
boolean color2Found = false; 
boolean color3Found = false;
 */

/*
// comparaison 1er symbole
if (inputColors0Returned.equals(color0Returned)) {
	rightPlaceAndColor = rightPlaceAndColor +1;
	colorCount0=0;
	color0Found=true;
	System.out.println("1er : rightPlaceAndColor: "+rightPlaceAndColor);
}
else if (inputColors0Returned.equals(color1Returned) && colorCount1==0 && color1Found==false) {
	colorCount1 = colorCount1 +1;
	System.out.println("1er : colorCount1: "+colorCount1);
}
else if (inputColors0Returned.equals(color2Returned) && colorCount2==0 && color2Found==false) {
	colorCount2 = colorCount2 +1;
	System.out.println("1er : colorCount2: "+colorCount2);
}
else if (inputColors0Returned.equals(color3Returned) && colorCount3==0 && color3Found==false) {
	colorCount3 = colorCount3 +1;
	System.out.println("1er : colorCount3: "+colorCount3);
}
System.out.println("1 : colorCount0 : "+colorCount0);
System.out.println("1 : colorCount1 : "+colorCount1);
System.out.println("1 : colorCount2 : "+colorCount2);
System.out.println("1 : colorCount3 : "+colorCount3);
System.out.println("1 : rightPlaceAndColor : "+rightPlaceAndColor);

// comparaison 2?me symbole
if (inputColors1Returned.equals(color1Returned)) {
	rightPlaceAndColor = rightPlaceAndColor +1;
	colorCount1=0;
	color1Found=true;
	System.out.println("2eme ,: rightPlaceAndColor: "+rightPlaceAndColor);
}
else if (inputColors1Returned.equals(color0Returned) && colorCount0==0 && color0Found==false) {
	colorCount0 = colorCount0 +1;
	System.out.println("2eme : colorCount0: "+colorCount0);
}
else if (inputColors1Returned.equals(color2Returned) && colorCount2==0 && color2Found==false) {
	colorCount2 = colorCount2 +1;
	System.out.println("2eme : colorCount2: "+colorCount2);
}
else if (inputColors1Returned.equals(color3Returned) && colorCount3==0 && color3Found==false) {
	colorCount3 = colorCount3 +1;
	System.out.println("2eme : colorCount3: "+colorCount3);
}	
System.out.println("2 : colorCount0 : "+colorCount0);
System.out.println("2 : colorCount1 : "+colorCount1);
System.out.println("2 : colorCount2 : "+colorCount2);
System.out.println("2 : colorCount3 : "+colorCount3);
System.out.println("2 : rightPlaceAndColor : "+rightPlaceAndColor);

// comparaison 3?me symbole
if (inputColors2Returned.equals(color2Returned)) {
	rightPlaceAndColor = rightPlaceAndColor +1;
	color2Found=true;
	colorCount2=0;
	System.out.println("3eme : rightPlaceAndColor: "+rightPlaceAndColor);
}
else if (inputColors2Returned.equals(color0Returned) && colorCount0==0 && color0Found==false) {
	colorCount0 = colorCount0 +1;
	System.out.println("3eme : colorCount0: "+colorCount0);
}
else if (inputColors2Returned.equals(color1Returned) && colorCount1==0 && color1Found==false) {
	colorCount1 = colorCount1 +1;
	System.out.println("3eme : colorCount1: "+colorCount1);
}
else if (inputColors2Returned.equals(color3Returned) && colorCount3==0 && color3Found==false) {
	colorCount3 = colorCount3 +1;
	System.out.println("3eme : colorCount3: "+colorCount3);
}	
System.out.println("3 : colorCount0 : "+colorCount0);
System.out.println("3 : colorCount1 : "+colorCount1);
System.out.println("3 : colorCount2 : "+colorCount2);
System.out.println("3 : colorCount3 : "+colorCount3);
System.out.println("3 : rightPlaceAndColor : "+rightPlaceAndColor);

// comparaison 4?me symbole
if (inputColors3Returned.equals(color3Returned)) {
	rightPlaceAndColor = rightPlaceAndColor +1;
	color3Found=true;
	colorCount3=0;
	System.out.println("4eme : rightPlaceAndColor: "+rightPlaceAndColor);
}
else if (inputColors3Returned.equals(color0Returned) && colorCount0==0 && color0Found==false) {
	colorCount0 = colorCount0 +1;
	System.out.println("4eme : colorCount0: "+colorCount0);
}
else if (inputColors3Returned.equals(color1Returned) && colorCount1==0 && color1Found==false) {
	colorCount1 = colorCount1 +1;
	System.out.println("3eme : colorCount1: "+colorCount1);
}
else if (inputColors3Returned.equals(color2Returned) && colorCount2==0 && color2Found==false) {
	colorCount2 = colorCount2 +1;
	System.out.println("3eme : colorCount2: "+colorCount2);
}	
System.out.println("4 : colorCount0 : "+colorCount0);
System.out.println("4 : colorCount1 : "+colorCount1);
System.out.println("4 : colorCount2 : "+colorCount2);
System.out.println("4 : colorCount3 : "+colorCount3);
System.out.println("4 : rightPlaceAndColor : "+rightPlaceAndColor);

onlyRightColor = (colorCount0+colorCount1+colorCount2+colorCount3);
System.out.println("\nnombre de pions avec une couleur et une position correctes\t : "+ rightPlaceAndColor);
System.out.println("nombre de pions avec uniquement une couleur correcte\t\t : "+ onlyRightColor+"\n");
 */