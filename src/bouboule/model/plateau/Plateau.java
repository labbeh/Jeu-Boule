package bouboule.model.plateau;

import java.util.HashSet;
import java.util.Set;

import bouboule.model.lesBoules.*;

/**
 * Cette classe représente le plateau de jeu
 * Le plateau contient toutes les instances des boules présentes dans le jeu
 * et permet d'avoir des actions sur ces boules
 * @author labbeh
 * @version 1.0
 * */
public class Plateau {
	/**
	 * Largeur du plateau
	 * */
	public final int largeur;
	
	/**
	 * Hauteur du plateau
	 * */
	public final int hauteur;
	
	/**
	 * Permet de choisir di le plateau est torique ou non
	 * */
	private boolean torique;
	
	/**
	 * Instance de la boule joueur
	 * */
	private BouleJoueur joueur;
	
	/**
	 * Instance du goal
	 * */
	private Goal goal;
	
	/**
	 * Ensemble des boules ennemis
	 * */
	private Set<Ennemi> ennemis;
	
	/**
	 * Constructeur par défaut
	 * @param largeur largeur du plateau (x)
	 * @param hauteur hauteur du plateau (y)
	 * */
	public Plateau(int largeur, int hauteur, boolean torique) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.torique = torique;
		
		joueur  = new BouleJoueur(this, largeur/2, hauteur/2); // à modifier
		ennemis = new HashSet<>();
		goal 	= new Goal(this, positionAleatoire());
	}
	
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public BouleJoueur getJoueur() {
		return joueur;
	}

	public Goal getGoal() {
		return goal;
	}

	public Set<Ennemi> getEnnemis() {
		return ennemis;
	}
	
	public boolean estTorique() {
		return torique;
	}
	
	/**
	 * Insère une nouvel ennemi à une position aléatoire
	 * sur le plateau
	 * */
	public void nvEnnemi() {
		ennemis.add(new Ennemi(this, positionAleatoire()));
	}
	
	public void haut() {
		joueur.haut();
	}
	
	public void bas() {
		joueur.bas();
	}
	
	public void gauche() {
		joueur.gauche();
	}
	
	public void droite() {
		joueur.droite();
	}
	
	/**
	 * Change le goal de position à une nouvelle position aléatoire
	 * */
	public void bougerGoal() {
		double[] nvlPos = positionAleatoire();
		
		double x = nvlPos[0];
		double y = nvlPos[1];
		
		goal.deplacer(x, y);
	}

	/**
	 * Retourne une position aléatoire comprise dans les bornes du plateau
	 * @return [0] position aléatoire axe X
	 * [1] position aléatoire axe y
	 * */
	private double[] positionAleatoire() {
		final int NB_AXE = 2;
		double[] pos = new double[NB_AXE];
		
		pos[0] = (int)(Math.random() * largeur);
		pos[1] = (int)(Math.random() * hauteur);
		
		return pos;
	}
}
