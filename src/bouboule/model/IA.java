package bouboule.model;

import java.awt.Color;
import java.util.Set;

import bouboule.controleur.Controleur;
import bouboule.model.lesBoules.Boule;
import bouboule.model.lesBoules.BouleJoueur;
import bouboule.model.lesBoules.Ennemi;
import bouboule.model.plateau.Plateau;

public class IA implements Runnable{
	/**
	 * Instance du controleur
	 * */
	private Controleur ctrl;
	
	/**
	 * La bille du joueur
	 * */
	private BouleJoueur boule;
	
	/**
	 * Vrai tant que l'ia doit être exécutée
	 * */
	private boolean enCours = true;

	public IA(Controleur ctrl) {
		this.ctrl = ctrl;
		
		boule = (BouleJoueur) ctrl.getJoueur();
	}
	
	public void arret() {
		enCours = false;
	}
	
	
	public void run() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(enCours) {
			double x = ctrl.getGoal().getX();
			double y = ctrl.getGoal().getY();
			
			if(x < boule.getX()) {
				System.out.println("gauche");
				ctrl.deplacer('g');
				while(boule.getX() > x && enCours && ctrl.getDir() == 'g') {
					try 						   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
					
					/*Set<Ennemi> ennemis = ctrl.getEnnemis();
					
					for(Ennemi e: ennemis) {
						BouleEclaireur ec = new BouleEclaireur(null, boule.getX()+1, boule.getY()+1);
						if(boule.memePosition(ec))
							ctrl.deplacer('h');

					}*/
				}
			}
			else if(x > boule.getX()) {
				System.out.println("droite");
				ctrl.deplacer('d');
				while(boule.getX() < x && enCours && ctrl.getDir() == 'd') {
					try							   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			
			if(y < boule.getY()) {
				System.out.println("haut");
				ctrl.deplacer('h');
				while(boule.getY() > y && enCours && ctrl.getDir() == 'h') {
					try 						   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			else if(y > boule.getY()) {
				System.out.println("bas");
				ctrl.deplacer('b');
				while(boule.getY() < y && enCours && ctrl.getDir() == 'b') {
					try 						   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			/*try 						   {Thread.sleep(20)   ;}
			catch (InterruptedException e) {e.printStackTrace();}*/

		}
		
		System.out.println("FIN IA");
	}
	
	private class BouleEclaireur extends Boule{

		public BouleEclaireur(Plateau plateau, double posX, double posY) {
			super(plateau, posX, posY);
		}

		@Override
		public String getType() {
			return "eclaireur";
		}

		@Override
		public Color getCoul() {
			return null;
		}
		
		
		
	}

}
