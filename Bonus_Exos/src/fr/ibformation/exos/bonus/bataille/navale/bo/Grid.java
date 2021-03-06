package fr.ibformation.exos.bonus.bataille.navale.bo;

public class Grid {

	// déclaration des variables
	public static final String 
	ORD_1 = "1", 
	ORD_2 = "2", 
	ORD_3 = "3",
	ORD_4 = "4", 
	ORD_5 = "5", 
	ORD_6 = "6",
	ORD_7 = "7", 
	ORD_8 = "8", 
	ORD_9 = "9",
	ORD_10 = "10";

	public static final String
	ABS_A = "A",
	ABS_B = "B",
	ABS_C = "C",
	ABS_D = "D",
	ABS_E = "E",
	ABS_F = "F",
	ABS_G = "G",
	ABS_H = "H",
	ABS_I = "I",
	ABS_J = "J";

	public static final String
	BOAT = "O",
	TOUCHED = "X",
	FLOADED = "*",
	PLAYER1 = "J1",
	PLAYER2 = "J2";

	public String[][] Grid;
	public String [] abs;
	public String [] ord;
	
/*	public String empty = " ";
	public String[][] emptyGrid = new String[][]{ 
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
*/
	
	// constructeurs
	public Grid (String[][] Grid, String []ord, String[] abs) {
		this.Grid=Grid;
		this.abs=abs;
		this.ord=ord;
	}
	
	
	
	// méthodes de classe
	public String[][] graphGrid(
			String [][]g) {
		
		System.out.println(" Grille Joueur                                  |   Grille Ennemi                                ");
		System.out.println("     "+abs[0]+"   "+abs[1]+"   "+abs[2]+"   "+abs[3]+"   "+abs[4]+"   "+abs[5]+"   "+abs[6]+"   "+abs[7]+"   "+abs[8]+"   "+abs[9]+"      |       "+abs[0]+"   "+abs[1]+"   "+abs[2]+"   "+abs[3]+"   "+abs[4]+"   "+abs[5]+"   "+abs[6]+"   "+abs[7]+"   "+abs[8]+"   "+abs[9]+"   ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[0]+" | "+g[0][0]+" | "+g[0][1]+" | "+g[0][2]+" | "+g[0][3]+" | "+g[0][4]+" | "+g[0][5]+" | "+g[0][6]+" | "+g[0][7]+" | "+g[0][8]+" | "+g[0][9]+" |    |   "+ORD_1+" | "+g[0][10]+" | "+g[0][11]+" | "+g[0][12]+" | "+g[0][13]+" | "+g[0][14]+" | "+g[0][15]+" | "+g[0][16]+" | "+g[0][17]+" | "+g[0][18]+" | "+g[0][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[1]+" | "+g[1][0]+" | "+g[1][1]+" | "+g[1][2]+" | "+g[1][3]+" | "+g[1][4]+" | "+g[1][5]+" | "+g[1][6]+" | "+g[1][7]+" | "+g[1][8]+" | "+g[1][9]+" |    |   "+ORD_2+" | "+g[1][10]+" | "+g[1][11]+" | "+g[1][12]+" | "+g[1][13]+" | "+g[1][14]+" | "+g[1][15]+" | "+g[1][16]+" | "+g[1][17]+" | "+g[1][18]+" | "+g[1][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[2]+" | "+g[2][0]+" | "+g[2][1]+" | "+g[2][2]+" | "+g[2][3]+" | "+g[2][4]+" | "+g[2][5]+" | "+g[2][6]+" | "+g[2][7]+" | "+g[2][8]+" | "+g[2][9]+" |    |   "+ORD_3+" | "+g[2][10]+" | "+g[2][11]+" | "+g[2][12]+" | "+g[2][13]+" | "+g[2][14]+" | "+g[2][15]+" | "+g[2][16]+" | "+g[2][17]+" | "+g[2][18]+" | "+g[2][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[3]+" | "+g[3][0]+" | "+g[3][1]+" | "+g[3][2]+" | "+g[3][3]+" | "+g[3][4]+" | "+g[3][5]+" | "+g[3][6]+" | "+g[3][7]+" | "+g[3][8]+" | "+g[3][9]+" |    |   "+ORD_4+" | "+g[3][10]+" | "+g[3][11]+" | "+g[3][12]+" | "+g[3][13]+" | "+g[3][14]+" | "+g[3][15]+" | "+g[3][16]+" | "+g[3][17]+" | "+g[3][18]+" | "+g[3][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[4]+" | "+g[4][0]+" | "+g[4][1]+" | "+g[4][2]+" | "+g[4][3]+" | "+g[4][4]+" | "+g[4][5]+" | "+g[4][6]+" | "+g[4][7]+" | "+g[4][8]+" | "+g[4][9]+" |    |   "+ORD_5+" | "+g[4][10]+" | "+g[4][11]+" | "+g[4][12]+" | "+g[4][13]+" | "+g[4][14]+" | "+g[4][15]+" | "+g[4][16]+" | "+g[4][17]+" | "+g[4][18]+" | "+g[4][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[5]+" | "+g[5][0]+" | "+g[5][1]+" | "+g[5][2]+" | "+g[5][3]+" | "+g[5][4]+" | "+g[5][5]+" | "+g[5][6]+" | "+g[5][7]+" | "+g[5][8]+" | "+g[5][9]+" |    |   "+ORD_6+" | "+g[5][10]+" | "+g[5][11]+" | "+g[5][12]+" | "+g[5][13]+" | "+g[5][14]+" | "+g[5][15]+" | "+g[5][16]+" | "+g[5][17]+" | "+g[5][18]+" | "+g[5][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[6]+" | "+g[6][0]+" | "+g[6][1]+" | "+g[6][2]+" | "+g[6][3]+" | "+g[6][4]+" | "+g[6][5]+" | "+g[6][6]+" | "+g[6][7]+" | "+g[6][8]+" | "+g[6][9]+" |    |   "+ORD_7+" | "+g[6][10]+" | "+g[6][11]+" | "+g[6][12]+" | "+g[6][13]+" | "+g[6][14]+" | "+g[6][15]+" | "+g[6][16]+" | "+g[6][17]+" | "+g[6][18]+" | "+g[6][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[7]+" | "+g[7][0]+" | "+g[7][1]+" | "+g[7][2]+" | "+g[7][3]+" | "+g[7][4]+" | "+g[7][5]+" | "+g[7][6]+" | "+g[7][7]+" | "+g[7][8]+" | "+g[7][9]+" |    |   "+ORD_8+" | "+g[7][10]+" | "+g[7][11]+" | "+g[7][12]+" | "+g[7][13]+" | "+g[7][14]+" | "+g[7][15]+" | "+g[7][16]+" | "+g[7][17]+" | "+g[7][18]+" | "+g[7][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(" "+ord[8]+" | "+g[8][0]+" | "+g[8][1]+" | "+g[8][2]+" | "+g[8][3]+" | "+g[8][4]+" | "+g[8][5]+" | "+g[8][6]+" | "+g[8][7]+" | "+g[8][8]+" | "+g[8][9]+" |    |   "+ORD_9+" | "+g[8][10]+" | "+g[8][11]+" | "+g[8][12]+" | "+g[8][13]+" | "+g[8][14]+" | "+g[8][15]+" | "+g[8][16]+" | "+g[8][17]+" | "+g[8][18]+" | "+g[8][19]+" | ");
		System.out.println("    --- --- --- --- --- --- --- --- --- ---     |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println(""+ord[9]+" | "+g[9][0]+" | "+g[9][1]+" | "+g[9][2]+" | "+g[9][3]+" | "+g[9][4]+" | "+g[9][5]+" | "+g[9][6]+" | "+g[9][7]+" | "+g[9][8]+" | "+g[9][9]+" |    |  "+ORD_10+" | "+g[9][10]+" | "+g[9][11]+" | "+g[9][12]+" | "+g[9][13]+" | "+g[9][14]+" | "+g[9][15]+" | "+g[9][16]+" | "+g[9][17]+" | "+g[9][18]+" | "+g[9][19]+" | ");
		System.out.println("   --- --- --- --- --- --- --- --- --- ---      |      --- --- --- --- --- --- --- --- --- ---  ");
		System.out.println("\t\t\t Bateau : "+BOAT+"\t Dans l'eau : "+FLOADED+"      touché : "+TOUCHED);
		
		return g; 
	}
	
	
	
}
