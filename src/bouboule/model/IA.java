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
	
	@Override
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
				ctrl.deplacer('g');
				while(boule.getX() > x && enCours) {
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
				ctrl.deplacer('d');
				while(boule.getX() < x && enCours) {
					try							   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			
			if(y < boule.getY()) {
				ctrl.deplacer('h');
				while(boule.getY() > y && enCours) {
					try 						   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
			else if(y > boule.getY()) {
				ctrl.deplacer('b');
				while(boule.getY() < y && enCours) {
					try 						   {Thread.sleep(20)   ;}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}

		}
		
		System.out.println("FIN IA");
	}
	
	private class BouleEclaireur extends Boule{

		public BouleEclaireur(Plateau plateau, double posX, double posY) {
			super(plateau, posX, posY);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Color getCoul() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	}

}
