package AppliSimu;

import DomaineVoiture.Voiture;


public class TransformationMetreEnPixel  {




    public int transformerXMetresPixels(int coordonneeXEnMetre) {

        int ratioDomaineFenetre = Voiture.largeurDomaineEnMetres / IhmSimu.TAILLE_FENETRE_EN_PIXELS;
        int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

        return coordonneeXEnPixels;
    }

    public int transformerYMetresPixels(int coordonneeYEnMetre) {
        int ratioDomaineFenetre = Voiture.largeurDomaineEnMetres / IhmSimu.TAILLE_FENETRE_EN_PIXELS;
        int coordonneeYEnPixels = IhmSimu.TAILLE_FENETRE_EN_PIXELS - (coordonneeYEnMetre / ratioDomaineFenetre);

        return coordonneeYEnPixels ;
    }



}