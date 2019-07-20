package bouboule.model.lesBoules;

import java.awt.Color;

import bouboule.model.plateau.Plateau;

public class BouleJoueur extends Boule {

	public BouleJoueur(Plateau plateau, double posX, double posY) {
		super(plateau, posX, posY);
	}

	@Override
	public String getType() {
		return "joueur";
	}

	@Override
	public Color getCoul() {
		return Color.BLUE;
	}
	
	/**
	 * Déplace la boule de 1px vers le haut si possible
	 * */
	public void haut() {
		if(posY - 1 >= 0)
			posY--;
		else if(plateau.estTorique())
			posY = plateau.getHauteur();
	}
	
	/**
	 * Déplace la boule de 1px vers le bas si possible
	 * */
	public void bas() {
		if(posY + 1 <= plateau.getHauteur())
			posY++;
		else if(plateau.estTorique())
			posY = 0;
	}
	
	/**
	 * Déplace la boule de 1px vers la droite
	 * */
	public void droite() {
		if(posX + 1 <= plateau.getLargeur())
			posX++;
		else if(plateau.estTorique())
			posX = 0;
	}
	
	/**
	 * Déplace le boule de 1px vers la gauche
	 * */
	public void gauche() {
		if(posX - 1 >= 0)
			posX--;
		else if(plateau.estTorique())
			posX = plateau.getLargeur();
	}

}
