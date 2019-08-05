package bouboule.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bouboule.controleur.Controleur;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -401016360236048388L;

	/**
	 * Doit être à vrai pour que la fenêtre soit visible
	 * */
	private final boolean VISIBLE = true;
	
	/**
	 * Permet ou non de rendre la fenêtre redimensionnable
	 * */
	private final boolean RESIZABLE = true;
	
	/**
	 * Instance du controleur
	 * */
	private Controleur ctrl;
	
	/**
	 * Plateau d'affichage des bouboules du jeu
	 * */
	private PlateauGUI plateau;
	
	/**
	 * Panel ou le score et éventuellement d'autres infos sur la partie en cours sont affichées
	 * */
	private JLabel infos;
	
	public Fenetre() {
		this.ctrl = new Controleur(this);
		
		setTitle("Bouboule la boulle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plateau = new PlateauGUI(ctrl);
		infos = new JLabel("Score: 0");
		
		add(plateau);
		add(new JPanel().add(infos), BorderLayout.PAGE_END);
		pack();
		
		setResizable(RESIZABLE);
		setVisible(VISIBLE);
	}
	
	public void setScore(int score) {
		infos.setText("Score : " +score);
	}
	
	public void boiteDialogue(String msg) {
		
	}
	
	
	public static void main(String[] args) {
		new Fenetre();
	}


	public void majIHM() {
		plateau.repaint();
	}

}
