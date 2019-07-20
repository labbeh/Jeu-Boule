package bouboule.vue.score;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class FenetreScore extends JFrame{

	public FenetreScore() {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(10, 1));
		
		for(int i=0; i<10; i++)
			add(new LigneScore(1, "labbeh", 1000));
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FenetreScore();
	}

}
