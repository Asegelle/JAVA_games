package fr.ibformation.exos.bonus.bataille.navale.bo;

public class Boats {



	// d�claration des variables
	public String [][] boatGrid = new String [10][10];
	public String Boat1place;
	public String Boat2place;
	public String Boat3place;
	public String Boat4place;
	public String Boat5place;


	// constucteurs
	public Boats (String [][]boatGridParam) {
		boatGrid = boatGridParam;
	}
/*	public Boats (String Boat1placeParam) {
		Boat1place = Boat1placeParam;
	}
	public Boats (String Boat2placeParam) {
		Boat2place = Boat2placeParam;
	}
	public Boats (String Boat3placeParam) {
		Boat3place = Boat3placeParam;
	}
	public Boats (String Boat4placeParam) {
		Boat4place = Boat4placeParam;
	}
	public Boats (String Boat5placeParam) {
		Boat5place = Boat5placeParam;
	}
*/


	//m�thodes
	public String[][] gridBoat () {
		return boatGrid;
	}

	public String placeBoat () {
		return Boat2place;
	}
}
