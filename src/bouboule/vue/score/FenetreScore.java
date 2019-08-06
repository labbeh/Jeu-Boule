package bouboule.vue.score;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreScore extends JFrame{

	public FenetreScore() {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel zoneScores = new JPanel();
		zoneScores.setLayout(new GridLayout(10, 1));
		
		for(int i=0; i<10; i++)
			zoneScores.add(new LigneScore(1, "labbeh", 1000));
		
		JPanel zoneBoutons = new JPanel();
		zoneBoutons.add(new JButton("Ok"));
		zoneBoutons.add(new JButton("Nettoyer"));
		
		add(zoneScores, BorderLayout.CENTER);
		add(zoneBoutons, BorderLayout.PAGE_END);
		
		pack();
		//setVisible(true);
	}
	
	public static void main(String[] args) {
		new FenetreScore().setVisible(true);
	}

}
