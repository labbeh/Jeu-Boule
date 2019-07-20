package bouboule.model;

import bouboule.controleur.Controleur;

/**
 * Cette classe gère le jeu et ses règles
 * */
public class Jeu {
	/**
	 * Instance du controleur
	 * */
	private Controleur ctrl;
	
	/**
	 * Passe à faux lorsque le jeu s'arrête
	 * A ce moment, la boucle du thread qui fait avancer la boule du joueur
	 * s'arrête
	 * */
	private boolean enCours;

	public Jeu(Controleur ctrl) {
		this.ctrl = ctrl;
		
		enCours = true;
	}

}
