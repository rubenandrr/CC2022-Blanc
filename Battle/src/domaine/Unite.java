package domaine;

import java.util.Random;
import java.security.InvalidParameterException;

/**
 * Classe représentant une unité de combat
 */
public class Unite {
	/**
  	 * Nombre de dés d'attaque (entre 1 et 3)
	 */
    private final int des_attaque;
	/**
  	 * Nombre de dés de défense (entre 1 et 3)
	 */
    private final int des_defense;
	/**
  	 * Nombre de points de vie restants (entre 0 et 10)
	 */
    private int points_vie;
	/**
  	 * Nom de l'unité
	 */
	private final String nom;

	/**
  	 * Générateur de nombre aléatoires
	 */
	private final Random rng;

	/**
	 * Constructeur de la classe - instancie une unité
	 * @param _nom Nom de l'unité
	 * @param _att Nombre de dés d'attaque (1 - 3)
	 * @param _def Nombre de dés de défense (1 - 3)
	 * @param _pv Nombre de point de vie initiaux (1 - 10)
	 * @throws InvalidParameterException si les valeurs des paramètres sont hors limites
	 */    
    public Unite(String _nom, int _att, int _def, int _pv) {
    	if (_att < 1 || _att > 3)
    		throw new InvalidParameterException("Le nombre de dés d'attaque doit être entre 1 et 3");
    	if (_def < 1 || _def > 3)
    		throw new InvalidParameterException("Le nombre de dés de défense doit être entre 1 et 3");
    	if (_pv < 1 || _pv > 10)
    		throw new InvalidParameterException("Le nombre de points de vie doit être entre 1 et 10");
    
        this.des_attaque = _att;
        this.des_defense = _def;
        this.points_vie = _pv;
        this.nom = _nom;

        this.rng = new Random();
    }

	/**
	 * Calcule le coût de création d'une unité
	 * @return coût de création (3 - 40)
	 */    
	public int cout_creation()
	{
		int total = 0;
		
		switch (this.des_attaque) {
			case 1: total += 1;
					break;
			case 2: total += 5;
					break;
			case 3: total += 15;
					break;
		}
		switch (this.des_defense) {
			case 1: total += 1;
					break;
			case 2: total += 5;
					break;
			case 3: total += 15;
					break;
		}

		switch (this.points_vie) {
			case 1: total += 1;
					break;
			case 2: total += 2;
					break;
			case 3: total += 3;
					break;
			case 4: total += 5;
					break;
			case 5: total += 8;
					break;
			case 6: total += 13;
					break;
			case 7: total += 21;
					break;
			case 8: total += 34;
					break;
			case 9: total += 55;
					break;
			case 10: total += 89;
					break;
		}

		return total;
	}

	/**
	 * Lance les dés d'attaque
	 * @return score total (1 - 18)
	 */    
    public int attaque() 
    { 
    	int att_score = 0;
    	
    	for (int i = 0 ; i < this.des_attaque ; i ++)
    		att_score += this.rng.nextInt(6) + 1;

    	return att_score;
    }

	/**
	 * Lance les dés de défense
	 * @return score total (1 - 18)
	 */    
    public int defense() 
    { 
    	int def_score = 0;
    	
    	for (int i = 0 ; i < this.des_defense ; i ++)
    		def_score += this.rng.nextInt(6) + 1;

    	return def_score;
    }

	/**
	 * Enregistre une perte de points de vie
	 * @param _pv Nombre de points de vie perdus
	 */    
	public void perdre_pv(int _pv)
	{
		this.points_vie -= _pv;

		if (this.points_vie < 0)
			this.points_vie = 0;
	}
	
	/**
	 * Indique si une unité est encore vivante
	 * @return vrai ou faux
	 */    
	public boolean vivant()
	{
        return this.points_vie > 0;
    }
	
    @Override
    public String toString() {
        return this.nom + " (A:" + this.des_attaque + " / D:" + this.des_defense + ") - " + this.points_vie + " PV";
    }
}