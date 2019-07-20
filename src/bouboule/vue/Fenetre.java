package bouboule.vue;

import javax.swing.JFrame;

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
	
	public Fenetre() {
		this.ctrl = new Controleur(this);
		
		setTitle("Bouboule la boulle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plateau = new PlateauGUI(ctrl);
		
		add(plateau);
		pack();
		
		setResizable(RESIZABLE);
		setVisible(VISIBLE);
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
