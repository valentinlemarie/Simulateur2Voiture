package AppliSimu;

import java.util.Observable;
import java.util.Observer;

import AppliSimu.IhmSimu;
import DomaineVoiture.Voiture;


public class VueVoiture implements Observer {

    private Voiture voiture;
    private IhmSimu ihmSimu;

    public VueVoiture() {
        this.voiture = null;
        this.ihmSimu = null;
    }

    public VueVoiture(Voiture voiture) {
        this.voiture = voiture;
        this.voiture.addObserver(this);
    }

    public VueVoiture(Voiture voiture, IhmSimu ihmSimu) {
        this.voiture = voiture;
        this.voiture.addObserver(this);
        this.ihmSimu = ihmSimu;
    }


    public void update(Observable observable, Object arg1) {
        TransformationMetreEnPixel transfo = new TransformationMetreEnPixel();
        int xMetreVoiture = this.voiture.getCoordXEnMetres();
        int yMetreVoiture = this.voiture.getCoordYEnMetres();
        int xPixelVoiture = transfo.transformerXMetresPixels(xMetreVoiture);
        int yPixelVoiture = transfo.transformerYMetresPixels(yMetreVoiture);
        ihmSimu.setXPixelVoiture(xPixelVoiture);
        ihmSimu.setYPixelVoiture(yPixelVoiture);
        ihmSimu.repaint();

    }

}