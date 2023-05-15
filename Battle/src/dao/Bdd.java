package dao;

import domaine.Unite;
import domaine.Bataille;
import domaine.Armee;

public class Bdd {
	public static Armee ArmeeType1() {
		Armee a = new Armee();
		a.ajouter(new Unite("Cavaliers", 3, 1, 5));
		a.ajouter(new Unite("Fantassin 1", 2, 2, 7));
		a.ajouter(new Unite("Fantassin 2", 1, 2, 3));
		a.ajouter(new Unite("Boucliers", 1, 3, 10), 0);
		a.ajouter(new Unite("Fantassin 3", 2, 2, 3));
		a.ajouter(new Unite("Fantassin 4", 2, 2, 4));
		
		return a;	
	}

	public static Armee ArmeeType2() {
		Armee a = new Armee();
		for (int i = 1 ; i < 21 ; i ++)
			a.ajouter(new Unite("Escarmouche " + i, 1, 1, 3));
		
		return a;	
	}



}