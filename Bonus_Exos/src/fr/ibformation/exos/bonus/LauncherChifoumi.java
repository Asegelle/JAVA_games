package fr.ibformation.exos.bonus;

import java.util.Random;
import java.util.Scanner;

public class LauncherChifoumi {

	public static final String COUP1="la Pierre",
			COUP2="la Feuille",
			COUP3="les Ciseaux",
			GAGNE=" gagne(nt) contre ",
			PERD=" perd(ent) contre ";



	public static void main(String[] args) {
		/* ?Chifoumi
				Le jeu de Chifoumi s'appelle aussi Caillou Ciseaux Papier. Le joueur va choisir soit
				un caillou, soit des ciseaux, soit un papier ? l'aide d'un menu. Le joueur affronte le
				syst?me. On donne un nombre de points ? atteindre au d?but du programme (3 ou
				5 par exemple) et le premier joueur qui a atteint ce nombre de points a gagn?.	*/
		// ?tape : d?claration des variables pierre, feuille, ciseau
		// ?tape : attribution d'une valeur aux variables
		boolean retry = true;
		Scanner scanner = new Scanner (System.in);
		int iniHumanCounter =0;
		int iniComputerCounter=0;
		boolean valueReturned = false;
		System.out.println("Bienvenue dans le jeu du Chifoumi ! \n\n Le jeu de Chifoumi s'appelle ?galement Pierre / Feuille / Ciseau. \n Vous allez devoir choisir entre Pierre / Feuille / Ciseau ? l'aide d'un menu. \n Puis vous affronterez l'ordinateur, et le premier d'entre vous qui remporte 5 manches a gagn?. !");
		do {
			// ?tape : questionner l'utilisateur sur son choix entre pierre feuille ciseau
			do  {
				System.out.println("\n choisissez l'un des 3 choix et tapez le chiffre associ? : \n Pierre\t : 1 \n Feuille : 2 \n Ciseau\t : 3" );
				int input = scanner.nextInt();
				ChoicePFC(input, "vous avez");
				// ?tape : random pour selectionner un pierre feuille ciseau par le systeme
				Random r = new Random();
				int numberIA = r.nextInt((3-1)+1)+1;
				ChoicePFC(numberIA, "l'ordinateur a");

				// comparaison utilisateur / systeme
				if ((numberIA==input) || (numberIA==input) || (numberIA==input)) {
					// affichage du r?sultat
					System.out.println("?galit? !");
					// attribution d'un point ? celui qui gagne - ou pas de point si ?gal
					// affichage du score apr?s chaque tour
					Counters(iniHumanCounter, iniComputerCounter);
				}
				else if (numberIA==1 && input==2) {
					System.out.println(COUP1+PERD+COUP2+" !");
					iniHumanCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);

				}
				else if (numberIA==1 && input==3) {
					System.out.println(COUP1+GAGNE+COUP3+" !");
					iniComputerCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);

				}
				else if (numberIA==2 && input==1) {
					System.out.println(COUP2+GAGNE+COUP1+" !");	
					iniComputerCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);

				}
				else if (numberIA==2 && input==3) {
					System.out.println(COUP2+PERD+COUP3+" !");
					iniHumanCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);

				}
				else if (numberIA==3 && input==1) {
					System.out.println(COUP3+PERD+COUP1+" !");	
					iniHumanCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);

				}
				else if (numberIA==3 && input==2) {
					System.out.println(COUP3+GAGNE+COUP2+" !");
					iniComputerCounter++;
					valueReturned = EndLoop(iniHumanCounter, iniComputerCounter);
				}
				else
					System.out.println("une erreur s'est produite");
			}
			// r?p?tition jusqu'a ce que utilisateur ou systeme ait 3 ou 5 points
			while (!valueReturned);
			if (iniComputerCounter<iniHumanCounter) {
				// affichage du nom du gagnant/perdant
				System.out.println("\n vous avez gagn? la partie !");
			}
			else if (iniComputerCounter>iniHumanCounter) {
				System.out.println("\n vous avez perdu la partie !");
			}
			else
				System.out.println("une erreur s'est produite");

			System.out.println("\n voulez vous rejouer ? (true/false)");
			retry = scanner.nextBoolean();
			if (retry == true) {
				System.out.println("bienvenue dans une nouvelle partie de Chifoumi !");
			}
			else if (retry == false){
				scanner.close();
				System.out.println("A bient?t pour une nouvelle partie !");
				retry=false;}
		}
		while (retry);
	}



	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction ChoicePFC pour choix Pierre/feuille/ciseaux -----------------------------
	//---------------------------------------------------------------------------------------------------------
	public static void ChoicePFC(int input, String player) {
		if (input<1 || input>3) {
			System.out.println("erreur de saisie (le chiffre doit ?tre compris entre 1 et 3)");
		}
		else if (input==1) {
			System.out.println(player+" choisi : "+COUP1);	
		}
		else if (input==2) {
			System.out.println(player+" choisi : "+COUP2);
		}
		else if (input==3) {
			System.out.println(player+" choisi : "+COUP3);
		}
		else
			System.out.println(player+" erreur de saisie");

	}	
	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction Counters pour afficher r?sultats ----------------------------------------
	//---------------------------------------------------------------------------------------------------------
	public static void Counters(int player1, int player2) {
		System.out.println("points :\n joueur : "+player1+" ; ordinateur : "+player2);
	}
	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction EndLoop pour sortir de la boucle (implique Fonction Counters) -----------
	//---------------------------------------------------------------------------------------------------------
	public static boolean EndLoop(int player1, int player2) {
		Counters(player1,player2);
		boolean isVictory= false;
		if (player1==5 || player1==5) {
			isVictory = true;
		}
		return isVictory;
	}
	//---------------------------------------------------------------------------------------------------------


}












