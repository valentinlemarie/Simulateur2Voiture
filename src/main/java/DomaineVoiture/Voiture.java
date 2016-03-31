package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	public static int largeurDomaineEnMetres = 1000;

	private int xEnMetres;
	private int yEnMetres;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int xEnMetres, int yEnMetres, int vitesse) {
		this.xEnMetres = xEnMetres;
		this.yEnMetres = yEnMetres;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
		miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres == 0)
			xEnMetres += vitesseMetreSeconde;
		else if (directionEnDegres == 180)
			xEnMetres -= vitesseMetreSeconde;

		if (xEnMetres > 1000)
			xEnMetres = 1000;
		else if (xEnMetres < 0)
			xEnMetres = 0;
	}

	private void miseAJourPositionY() {
		if (directionEnDegres == 90)
			yEnMetres += vitesseMetreSeconde;
		else if (directionEnDegres == 270)
			yEnMetres -= vitesseMetreSeconde;

		if (yEnMetres > 500)
			yEnMetres = 500;
		else if (yEnMetres < -500)
			yEnMetres = -500;
	}

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getCoordXEnMetres() {
		return xEnMetres;
	}

	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;
	}

	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;

	}

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = (directionEnDegres) % 360;

	}

	public Object getDirection() {
		return directionEnDegres;
	}


	public void tournerGauche() {
		directionEnDegres +=90 ;
		directionEnDegres = (directionEnDegres) % 360;
	}

	public int getCoordYEnMetres() {
		return yEnMetres;
	}

	public void tournerDroite() {
		directionEnDegres +=270 ;
		directionEnDegres = (directionEnDegres) % 360;
	}

	public void freiner()
	{
		if (vitesseMetreSeconde >0)
			vitesseMetreSeconde -= 10;
	}


	public void avancerEnFonctionDeLaVitesseEtAngle(double dureeTimerEnSeconde)
	{

	}
}