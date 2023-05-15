package domaine;
import java.util.ArrayList;

/**
 * Classe représentant une armée
 */
public class Armee {
	/**
  	 * Liste ordonnée d'unités
	 */
    private final ArrayList<Unite> liste_unites;

	/**
	 * Constructeur de la classe - instancie une armée vide
	 */    
    public Armee() {
        this.liste_unites = new ArrayList<Unite>();
    }

	/**
	 * Calcule le coût total de l'armée
	 * @return Somme des coûts des unités
	 */    
	public int cout_armee()
	{
		int total = 0;

		for (Unite u: liste_unites) {
			total += u.cout_creation();
		}
		
		return total;
	}

	/**
	 * Sélection de la prochaine unité encore en vie
	 * @return Unité ou null si aucune armée en vie
	 */    
    public Unite prochaine() 
    { 
		for (Unite u: liste_unites) {
			if (u.vivant())
				return u;
		}
		
		return null;
    }

	/**
	 * Ajout d'une unité à l'armée
	 * @param _u unité à ajouter
	 */    
    public void ajouter(Unite _u) 
    { 
    	liste_unites.add(_u);
    }

	/**
	 * Ajout d'une unité à l'armée à une place prédéfinie
	 * @param _u unité à ajouter
	 * @param _pos position où insérer l'unité
	 * @throws IndexOutOfBoundsException si la position est invalide
	 */    
    public void ajouter(Unite _u, int _pos) throws IndexOutOfBoundsException
    { 
    	liste_unites.add(_pos, _u);
    }


    @Override
    public String toString() {
    	String retStr = "Armée ";
    	
		for (Unite u: liste_unites) {
			retStr += "\n   " + u;
		}
		
		return retStr;
    }
}