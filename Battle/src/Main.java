import domaine.Unite;
import domaine.Bataille;
import domaine.Armee;
import dao.Bdd;

public class Main {
    public static void main(String[] args) {
    	int result;
    	Unite att, def;
    	boolean j1att = true;
    	
		Armee a1 = Bdd.ArmeeType1();
		System.out.println(a1);
		System.out.println(a1.cout_armee());

		Armee a2 = Bdd.ArmeeType2();
		System.out.println(a2);
		System.out.println(a2.cout_armee());
		
		att = a1.prochaine();
		def = a2.prochaine();
		
		while (att != null && def != null)
		{
			System.out.println("Attaquant : " + att);
			System.out.println("Défenseur : " + def);
			
			result = Bataille.Combat(att, def);
			
			if (result > 0)
				System.out.println("L'attaquant gagne la manche");			
			if (result < 0)
				System.out.println("Le défenseur gagne la manche");			
			if (result == 0)
				System.out.println("Manche nulle");			

			System.out.println("-----------------------------------");			
			
			if (j1att)
			{
				def = a1.prochaine();
				att = a2.prochaine();
				j1att = false;				
			} else {
				att = a1.prochaine();
				def = a2.prochaine();
				j1att = true;				
			
			}
		}
		
		if (a1.prochaine() != null)
		{
			System.out.println("Le joueur 1 remporte la partie !");			
		} else if (a2.prochaine() != null)
		{
			System.out.println("Le joueur 2 remporte la partie !");			
		} else {
			System.out.println("Match nul");			
		}

	}

}