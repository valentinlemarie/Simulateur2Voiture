package AppliSimu;

import DomaineVoiture.Voiture;


public class TransformationMetreEnPixel  {




    public int transformerXMetresPixels(int coordonneeXEnMetre) {

        int ratioDomaineFenetre = Voiture.largeurDomaineEnMetres / IhmSimu.TailleFenetreEnPixels;
        int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

        return coordonneeXEnPixels;
    }

    public int transformerYMetresPixels(int coordonneeYEnMetre) {
        int ratioDomaineFenetre = Voiture.largeurDomaineEnMetres / IhmSimu.TailleFenetreEnPixels;
        int coordonneeYEnPixels = IhmSimu.TailleFenetreEnPixels - (coordonneeYEnMetre / ratioDomaineFenetre);

        return coordonneeYEnPixels ;
    }



}