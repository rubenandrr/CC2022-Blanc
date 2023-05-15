package domaine;

import java.util.Random;

/**
 * Classe utilitaire permettant de jouer un tour de jeu entre deux unités
 */
public class Bataille {
	/**
  	 * Générateur de nombres aléatoires pour le calcul des points de vie perdus
	 */
	static Random rng = new Random();
	
	/**
  	 * Constructeur privé pour simuler une classe statique
	 */
	private Bataille() { }

	/**
	 * Résout un tour de combat et retire les points de vie perdus par les unités
	 * @param attaquant Unité attaquante
	 * @param defenseur Unité défenseur
	 * @return nombre de pv perdus (positif si l'attaquant gagne, négatif si le défenseur gagne, 0 si match nul)
	 */    
   public static int Combat(Unite attaquant, Unite defenseur) {
    	int att_score = attaquant.attaque();
    	int def_score = defenseur.attaque();
    	int pv_perdus = 0;
    	
    	if (att_score > def_score)
    	{
			attaquant.perdre_pv(1);
    		
    		pv_perdus = rng.nextInt(3) + 1;
			defenseur.perdre_pv(pv_perdus);
	    	return pv_perdus;
		} 

    	if (att_score < def_score)
    	{
			defenseur.perdre_pv(1);
			
    		pv_perdus = rng.nextInt(3) + 1;
			attaquant.perdre_pv(pv_perdus);
	    	return -1 * pv_perdus;
		} 

		attaquant.perdre_pv(1);
		defenseur.perdre_pv(1);
		return 0;
    }
}