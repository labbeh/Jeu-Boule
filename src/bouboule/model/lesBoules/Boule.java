package bouboule.model.lesBoules;

import java.awt.Color;

import bouboule.model.plateau.Plateau;

/**
 * Classe abstraite représentant une boule
 * Chaque type de boule devra hériter de cette classe
 * @author labbeh
 * */
public abstract class Boule {
	/**
	 * Instance du plateau sur lequel est la boule courante
	 * */
	protected Plateau plateau;
	
	/**
	 * Position x
	 * */
	protected double posX;
	
	/**
	 * Position y
	 * */
	protected double posY;
	
	/**
	 * Diamètre de la bouboule
	 * */
	protected int diametre;
	
	
	public Boule(Plateau plateau, double posX, double posY) {
		this.plateau = plateau;
		this.posX = posX;
		this.posY = posY;
		this.diametre = 25;
	}
	
	public Boule(Plateau plateau, double[] pos) {
		this(plateau, pos[0], pos[1]);
	}
	
	/**
	 * Permet de savoir quel à quel type de boule correspond l'instance en cours.
	 * Cette méthode doit être défini dans chaque classe de boule
	 * @return nom du type de boule
	 * */
	public abstract String getType();
	
	/**
	 * Permet d'associer une couleur AWT à une boule
	 * Retourne null si fonction non utile
	 * */
	public abstract Color getCoul();
	
	/**
	 * Retourne la position x
	 * @return position x
	 * */
	public double getX() {return posX;}
	
	/**
	 * Retourne la position y
	 * @return position y
	 * */
	public double getY() {return posY;}
	
	/**
	 * Retourne le diamètre de la boule
	 * @return diamètre de la boule en pixel
	 * */
	public int getDiametre() {return diametre;}
	
	/**
     * Méthode permettant de comparer la position avec un intervalle de marge
     * */
    public boolean memePosition(Boule b){
    	final int DISTANCE = 10;
    	
        if(posX == b.posX && posY == b.posY)
            return true;
        if((posX >= b.posX-DISTANCE && posX <= b.posX+DISTANCE) && (posY >= b.posY-DISTANCE && posY <= b.posY+DISTANCE))
            return true;

        return false;
    }
}
