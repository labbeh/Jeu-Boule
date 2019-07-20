package bouboule.vue.score;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Cette classe permet de créer un panel pour l'affichage d'une ligne de meilleurs scores
 * @author labbeh
 * @version 1.0
 * */

public class LigneScore extends JPanel{
	
	/**
	 * Constructeur par défaut
	 * @param position numéro de classement dans les meilleurs scores
	 * @param nom du joueur classé
	 * @param nbPts nombre de points
	 * */
	public LigneScore(int position, String nom, int nbPts) {
		super();
		
		setLayout(new BorderLayout());
		
	}

}
