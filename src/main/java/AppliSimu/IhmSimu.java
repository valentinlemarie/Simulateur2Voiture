package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import DomaineVoiture.Voiture;

public class IhmSimu extends JFrame {

    public static final int TailleFenetreEnPixels = 500;

    private int xPixelVoiture;
    private int yPixelVoiture;


    private int xObstacle;

    private int yObstacle;

    private int largeurObstacle;

    private int hauteurObstacle;

    JPanel panel;

    Voiture voiture;

    public IhmSimu(Voiture voiture) {
        super();
        this.setTitle("Simulateur de Voiture");
        this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
        this.voiture = voiture;
        dessinerBoutons();
        this.xPixelVoiture = 0;
        this.yPixelVoiture = 0;
        this.add(panel);
        this.setVisible(true);

    }

    @Override
    public void paint(Graphics contexteGraphique) {
        super.paint(contexteGraphique);
        dessinerVoiture(this.xPixelVoiture, this.yPixelVoiture, contexteGraphique);
        dessinerObstacle(contexteGraphique);
        dessinerRoute(contexteGraphique);
    }

    private void dessinerObstacle(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(xObstacle, yObstacle, largeurObstacle,
                hauteurObstacle);
    }

    public void dessinerRoute(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect(40, 20, 20, 1000);
    }

    public void dessinerVoiture(int xPixelVoiture, int yPixelVoiture, Graphics graphics) {
        graphics.fillOval(xPixelVoiture, yPixelVoiture, 15, 15);
    }

    public void setXPixelVoiture(int xPixelVoiture) {
        this.xPixelVoiture = xPixelVoiture;
    }
/*
    public void coordonneesObstacle(Obstacle obstacle) {

        TransformationMetreEnPixel transfo = new TransformationMetreEnPixel();

        this.xObstacle = transfo.transformerXMetresPixels(obstacle.getCoordXEnMetres());
        this.yObstacle = transfo.transformerXMetresPixels(obstacle.getY());
        this.largeurObstacle = transfo.transformerXMetresPixels(obstacle
                .getLargeur());
        this.hauteurObstacle = transfo.transformerXMetresPixels(obstacle
                .getHauteur());

    }

    public void coordonneesRoute(Route route) {

        TransformationMetreEnPixel transfo = new TransformationMetreEnPixel();

        this.xObstacle = transfo.transformerXMetresPixels(route.getX());
        this.yObstacle = transfo.transformerXMetresPixels(route.getY());
        this.largeurObstacle = transfo.transformerXMetresPixels(route
                .getLargeur());
        this.hauteurObstacle = transfo.transformerXMetresPixels(route
                .getHauteur());

    }
*/
    public void dessinerBoutons() {
        JButton boutonAccelerer = new JButton("+");
        JButton boutonFreiner = new JButton("-");
        JButton boutonTournerAgauche = new JButton("<-");
        JButton boutonTournerAdroite = new JButton("->");
        panel = new JPanel();
        panel.add(boutonAccelerer);
        panel.add(boutonFreiner);
        panel.add(boutonTournerAgauche);
        panel.add(boutonTournerAdroite);

        boutonAccelerer.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent arg0) {
                voiture.accelerer();
            }
        });

        boutonFreiner.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent arg0) {
                voiture.freiner();
            }
        });

        boutonTournerAgauche.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                voiture.tournerAgauche();
            }
        });

        boutonTournerAdroite.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent arg0) {
                voiture.tournerADroite();
            }
        });

    }

    public void setYPixelVoiture(int yPixelVoiture) {
        this.yPixelVoiture = yPixelVoiture;

    }

}