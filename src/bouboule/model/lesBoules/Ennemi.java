package bouboule.model.lesBoules;

import java.awt.Color;

import bouboule.model.plateau.Plateau;

/**
 * Cette classe représente une boule ennemi
 * */
public class Ennemi extends Boule {

	public Ennemi(Plateau plateau, double posX, double posY) {
		super(plateau, posX, posY);
	}

	public Ennemi(Plateau plateau, double[] pos) {
		super(plateau, pos);
	}

	@Override
	public String getType() {
		return "Ennemi";
	}

	@Override
	public Color getCoul() {
		return Color.RED;
	}

}
