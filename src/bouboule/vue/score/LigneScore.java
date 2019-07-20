package bouboule.vue.score;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
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
		
		setLayout(/*new BorderLayout()*/ new GridLayout());
		
		add(new JLabel(position+"")/*, BorderLayout.WEST*/);
		add(new JLabel(nom)/*, BorderLayout.CENTER*/);
		add(new JLabel(nbPts+"")/*, BorderLayout.EAST*/);
		
	}

}
