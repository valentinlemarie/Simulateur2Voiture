package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	public static int largeurDomaineEnMetres;

	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int x, int y, int vitesse) {
		this.x = x;
		this.y = y;
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
			x += vitesseMetreSeconde;
		else if (directionEnDegres == 180)
			x -= vitesseMetreSeconde;

		if (x > 1000)
			x = 1000;
		else if (x < 0)
			x = 0;
	}

	private void miseAJourPositionY() {
		if (directionEnDegres == 90)
			y += vitesseMetreSeconde;
		else if (directionEnDegres == 270)
			y -= vitesseMetreSeconde;

		if (y > 500)
			y = 500;
		else if (y < -500)
			y = -500;
	}

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getCoordXEnMetres() {
		return x;
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


	public void tournerDroite() {
		directionEnDegres +=90 ;
		directionEnDegres = (directionEnDegres) % 360;
	}

	public int getCoordYEnMetres() {
		return y;
	}

	public void tournerGauche() {
		directionEnDegres +=270 ;
		directionEnDegres = (directionEnDegres) % 360;
	}

	public void freiner()
	{
		if (vitesseMetreSeconde >0)
			vitesseMetreSeconde -= 10;
	}




}