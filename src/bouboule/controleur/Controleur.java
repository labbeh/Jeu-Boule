package bouboule.controleur;
/**
 * Controleur MVC
 * */

import java.util.Set;

import bouboule.model.IA;
import bouboule.model.lesBoules.Boule;
import bouboule.model.lesBoules.Ennemi;
import bouboule.model.plateau.Plateau;
import bouboule.vue.Fenetre;

public class Controleur {
	/**
	 * Instance du plateau de jeu
	 * */
	private Plateau plateau;
	
	/**
	 * Accès à la vue
	 * */
	private Fenetre vue;
	
	/**
	 * Direction de la bille du joueur
	 * */
	private char dir;
	
	
	/**
	 * Instance d'une IA qui joue toute seule
	 * */
	private IA ia;
	
	/**
	 * Score de la partie en cours
	 * */
	private int score;
	
	
	public Controleur(Fenetre vue) {
		plateau = new Plateau(640, 480, true);
		this.vue = vue;
		dir = 'h';
		
		//test();
		
		init();
	}
	
	/**
	 * Cette méthode (dont l'appel doit être décommenté dans le constructeur) permet d'initialiser
	 * une situation de départ en dure afin d'effectuer des tests
	 * */
	public void test() {
		ia = new IA(this);
		Thread t = new Thread(ia);
		t.start();
	}
	
	void init() {
		Thread mvt = new Thread(new ThreadMouvement());
		mvt.start();
	}
	
	/**
	 * Permet de lancer un déplacement de la bouboule du joueur
	 * @param dir direction de la boule
	 * 'g' 'd' 'h' 'b' pour gauche droite haut ou bas
	 * */
	public void deplacer(char dir) {
		this.dir = dir;
	}
	
	
	public Boule getGoal() {return plateau.getGoal();}
	public Boule getJoueur() {return plateau.getJoueur();}
	public Set<Ennemi> getEnnemis(){return plateau.getEnnemis();}
	
	
	public char getDir() {
		return dir;
	}

	public int largeur() {
		return plateau.largeur;
	}
	
	public int hauteur() {
		return plateau.hauteur;
	}
	
	private void incScore() {
		score++;
		vue.setScore(score);
	}
	
	/**
	 * Classe interne exécutant un thread faisant avancer la bille
	 * du joueur en permanance
	 * */
	private class ThreadMouvement implements Runnable{
		/**
		 * Passe à faux quand le jeu est fini
		 * */
		private boolean jeuEnCours = true;
		
		/**
		 * Temporisation pour l'accélération
		 * */
		private long tempo = 10;

		
		public void run() {
			while(jeuEnCours) {
				try {
					Thread.sleep(tempo);
				}
				catch(InterruptedException evt) {
					evt.printStackTrace();
				}
				this.deplacer(dir);
				
			}
		}
		
		private void deplacer(char dir) {
			switch(dir) {
				case 'h': plateau.haut();
						  break;
						  
				case 'b': plateau.bas();
						  break;
						  
				case 'd': plateau.droite();
						  break;
						  
				case 'g': plateau.gauche();
			}
			
			vue.majIHM();
			
			if(plateau.getJoueur().memePosition(plateau.getGoal())) {
				plateau.nvEnnemi();
				plateau.bougerGoal();
				accelerer();
				incScore();
			}
			
			for(Ennemi e: plateau.getEnnemis())
				if(plateau.getJoueur().memePosition(e))
					finJeu();
		}
		

		/**
		 * Diminue la temporisation du thread qui déplace la boule joueur en permanence
		 * afin d'accélérer sa vitesse de déplacement
		 * */
		public void accelerer() {
			if(tempo >= 5)
				tempo -= 1;
			//System.out.println(tempo);
		}
		
		/**
		 * Met fin au jeu
		 * */
		private void finJeu() {
			jeuEnCours = false;
			if(ia != null)
				ia.arret();
		}
		
	}
}
