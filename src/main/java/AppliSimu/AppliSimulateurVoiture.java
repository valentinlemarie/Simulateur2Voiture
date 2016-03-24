package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppliSimulateurVoiture {

    public static final int dureeUneSecondeEnMilliSecondes = 1000;

    public static void main(String[] args) {
		final Voiture voiture = new Voiture(100, 10, 200);
		IhmSimu ihmSimu = new IhmSimu(voiture);

		VueVoiture cercle = new VueVoiture(voiture, ihmSimu);
		//final Obstacle obstacle = new Obstacle(500, 600, 100, 100);
		//ihmSimu.coordonneesObstacle(obstacle);

		//DetectionCollision detectionCollision = new DetectionCollision(voiture, obstacle);

		final double dureeTimerEnSeconde = dureeUneSecondeEnMilliSecondes / 1000.0;
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes,
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent arg0) {
                        voiture.avancerEnFonctionDeLaVitesseEtAngle(dureeTimerEnSeconde);

                    }

                });

		timerAvancer.start();

		while (true) {
		}


    }
}