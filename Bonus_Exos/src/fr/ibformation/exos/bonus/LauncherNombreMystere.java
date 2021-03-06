package fr.ibformation.exos.bonus;

import java.util.Random;
import java.util.Scanner;

public class LauncherNombreMystere {

	public static void main(String[] args) {
		/* ?Jeu du nombre myst?re :
							Le syst?me choisit un nombre al?atoire entre 1 et 100 (il est possible de le fixer
							dans un premier temps). Le joueur doit trouver le nombre myst?re en 7 coups
							maximum ! A chaque tentative, le syst?me indique si le nombre myst?re est plus
							grand ou plus petit. A la fin du jeu, le syst?me indique le nombre de coup en cas de
							victoire, ou un message de d?faite le cas ?ch?ant		*/
		// ?tape 1 : d?claration des bool?ennes pour relancer ou non le game
		boolean retry=true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenue dans le jeu du nombre myst?re ! \n\n Un nombre va ?tre choisi al?atoirement entre 0 et 100 et vous allez avoir 7 coups maximum pour le trouver. \n A chaque tentative, il vous sera indiqu? si le nombre myst?re est plus grand ou plus petit. \n A la fin du jeu, le syst?me indiquera le nombre de coups en cas de victoire, ou un message de d?faite le cas ?ch?ant. \n Bonne chance ? vous !\n");
		do {
			// ?tape 2 : d?claration des variables
			int inputNumber;
			int iteration;
			boolean isNumberFound = false;
			int maxInterval = 100;
			// ?tape 3 : attribution des valeurs aux variables (random)
			//	int mysteryNumber = (int)(Math.random()*100);
			int mysteryNumber = generateMysteryNumber(maxInterval);
			//int mysteryNumber = 57;	//code quand valeur fixe

			// ?tape 3 : boucle FOR de 7 r?p?titions tant que pas trouv? le nombre
			for (iteration=0; !isNumberFound && iteration<7; iteration++) {
				// ?tape 4 : saisie de l'imput par l'utilisateur
				System.out.println("saisissez un nombre entre 0 et 100 : ");
				inputNumber = scanner.nextInt();
				System.out.println("vous venez de saisir le nombre : "+inputNumber);
				// ?tape 5 : IF pour nombre pas trouv?, erreur
				if (inputNumber <0 || inputNumber>100) {
					System.out.println("erreur de saisie (le nombre doit ?tre compris entre 0 et 100)");	
					iteration--;
				}
				// ?tape 6 : IF pour nombre pas trouv?, plus petit ou plus grand
				else if (inputNumber <mysteryNumber) {
					System.out.println("le nombre myst?re est plus grand");		
				}
				else if (inputNumber >mysteryNumber) {
					System.out.println("le nombre myst?re est plus petit");		
				}
				// ?tape 7 : IF pour nombre trouv?
				else if (inputNumber ==mysteryNumber) {
					System.out.println("vous avez trouv? le nombre myst?re en "+(iteration++)+ " coup(s)!");
					isNumberFound = true;
				}
				// ?tape 8 : prise en compte d'une erreur
				else  {
					System.out.println("une erreur s'est produite");
					iteration--;
				}
			}
			// ?tape 10 : relancer le jeu ou non apr?s 7 erreurs
			if (isNumberFound==false) {
				System.out.println("vous n'avez pas trouv? le nombre myst?re apr?s 7 tentatives, vous aurez plus de chances la prochaine fois !");
			}
			System.out.println("voulez vous rejouer ? (true/false)");
			retry = scanner.nextBoolean();
			if (retry == true) {
				System.out.println("bienvenue dans une nouvelle partie du nombre myst?re !\n");
			}
			else {
				System.out.println("A bient?t pour une nouvelle partie !");
				scanner.close();
			}
		}
		while (retry);
	}



	//---------------------------------------------------------------------------------------------------------
	// --------------------- fonction random ------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------	

	public static int generateMysteryNumber (int max) {
		Random r = new Random();
		int mysteryNumber = r.nextInt((max-0)+1)+0;
		System.out.println(mysteryNumber);
		return mysteryNumber;
	}

	//---------------------------------------------------------------------------------------------------------	



}



