package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppliSimulateurVoiture {

    public static final int DUREE_UNE_SECONDE_EN_MILLISECONDES = 1000;

    public static void main(String[] args) {
		final Voiture voiture = new Voiture(100, 100, 0);
		IhmSimu ihmSimu = new IhmSimu(voiture);

		VueVoiture cercle = new VueVoiture(voiture, ihmSimu);
		//final Obstacle obstacle = new Obstacle(500, 600, 100, 100);
		//ihmSimu.coordonneesObstacle(obstacle);

		//DetectionCollision detectionCollision = new DetectionCollision(voiture, obstacle);

		final double dureeTimerEnSeconde = DUREE_UNE_SECONDE_EN_MILLISECONDES / 1000.0;
		Timer timerAvancer = new Timer(DUREE_UNE_SECONDE_EN_MILLISECONDES,
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent arg0) {
                        voiture.miseAJourPosition();

                    }

                });

		timerAvancer.start();

		while (true) {
		}


    }
}