package fr.ibformation.javase.fichiers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LauncherExo1 {

	
/*		•
	Exercice 1 :
	Avec le dictionnaire.txt fourni, faites en
	sorte qu’on puisse afficher à un
	utilisateur le mot à la ligne 2000 du
	dictionnaire	
*/		
	

	
	public static void main(String[] args) {
		try (
			FileInputStream fichier = new FileInputStream("files/dictionnaire.txt"); // This will be automaticaly closed when the try / catch is finished with this syntax
			Scanner s = new Scanner(fichier); // This will be automaticaly closed when the try / catch is finished with this syntax
		) {
			int countWord = 0;
			// If my scanner have a next line
			while (s.hasNextLine() && countWord<2000) {
				countWord++;
				s.nextLine(); // Go to the next line
			}
			System.out.println(countWord);
			
			String word = s.nextLine();  
			System.out.println(word);
			
		} catch (IOException e) {
			System.out.println("[DemoFile] numberOfLineIntoFile : An error from count the number of words into file !");
			System.out.println(e);
		
		}
		
/*		
 -----------------------------------------------------------------------------------------------------------
 ------------------------ Correction -----------------------------------------------------------------------
 -----------------------------------------------------------------------------------------------------------
*/
 /*
		String wordChoosed = selectWordIntoDictionnary(2000);
		
		System.out.println(wordChoosed);
	}
	
	
	public static String selectWordIntoDictionnary(int lineChoosed) {
		try (
			FileInputStream fichier = new FileInputStream("files/dictionnaire.txt"); // This will be automaticaly closed when the try / catch is finished with this syntax
			Scanner s = new Scanner(fichier); // This will be automaticaly closed when the try / catch is finished with this syntax
		) {
			for (int i = 0; i < lineChoosed; i++) {
				s.nextLine(); // Browse file to the line before the lineChoosed
			}
			
			return s.nextLine().toUpperCase(); // Return word String with uppercase letters
		} catch (IOException e) {
			System.out.println("[DemoFile] numberOfLineIntoFile : An error from count the number of words into file !");
			System.out.println(e);
		}
		return null;
*/		
		
	}
}
