package bouboule.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import bouboule.controleur.Controleur;
import bouboule.model.lesBoules.Ennemi;

/**
 * Cette classe permet de représenter les bouboules sur la fenêtre
 * @author labbeh
 * */
public class PlateauGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7412819775818070570L;

	/**
	 * Diamètre des bouboules
	 * */
	private final int DIAMETRE;
	
	/**
	 * Instance du controleur
	 * */
	private Controleur ctrl;
	
	
	public PlateauGUI(Controleur ctrl) {
		super();
		
		this.ctrl = ctrl;
		addKeyListener(new EcouteurClavier());
		setFocusable(true);
		setPreferredSize(new Dimension(ctrl.largeur() +ctrl.getJoueur().getDiametre(), ctrl.hauteur() +ctrl.getJoueur().getDiametre()));
		//setBackground(Color.BLACK);
		
		DIAMETRE = ctrl.getJoueur().getDiametre();
	}
	
	/**
	 * Défini synschrinsée pour éviter que le thread qui fait avancer la boule jouer appel en même temps
	 * qu'un autre thread
	 * */
	@Override
	protected synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// les ennemis
		for(Ennemi e: ctrl.getEnnemis()) {
			g.setColor(e.getCoul());
			g.fillOval((int)e.getX(), (int)e.getY(), DIAMETRE, DIAMETRE);
		}
		
		// le goal
		g.setColor(ctrl.getGoal().getCoul());
		g.fillOval((int)ctrl.getGoal().getX(), (int)ctrl.getGoal().getY(), DIAMETRE, DIAMETRE);
		
		// le joueur
		g.setColor(ctrl.getJoueur().getCoul());
		g.fillOval((int)ctrl.getJoueur().getX(), (int)ctrl.getJoueur().getY(), DIAMETRE, DIAMETRE);
	}
	
	/**
	 * Classe interne pour la gestion du clavier
	 * */
	private class EcouteurClavier implements KeyListener{

		@Override
		public void keyTyped(KeyEvent evt) {
			
		}

		@Override
		public void keyPressed(KeyEvent evt) {
			if 	   (evt.getKeyCode() == KeyEvent.VK_UP	 ) ctrl.deplacer('h');
			else if(evt.getKeyCode() == KeyEvent.VK_DOWN ) ctrl.deplacer('b');
			else if(evt.getKeyCode() == KeyEvent.VK_LEFT ) ctrl.deplacer('g');
			else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) ctrl.deplacer('d');
		}

		@Override
		public void keyReleased(KeyEvent evt) {
			
		}
		
	}

}
