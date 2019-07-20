package bouboule.model.lesBoules;

import java.awt.Color;

import bouboule.model.plateau.Plateau;

/**
 * Représentation du but
 * Le joueur doit toucher cette boule pour marquer un point
 * */
public class Goal extends Boule {

	public Goal(Plateau plateau, double posX, double posY) {
		super(plateau, posX, posY);
		// TODO Auto-generated constructor stub
	}

	public Goal(Plateau plateau, double[] pos) {
		super(plateau, pos);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Déplace le goal à une nouvelle position
	 * @param x position x
	 * @param y position y
	 * */
	public void deplacer(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public String getType() {
		return "Goal";
	}

	@Override
	public Color getCoul() {
		return new Color(48, 130, 78);
	}

}
