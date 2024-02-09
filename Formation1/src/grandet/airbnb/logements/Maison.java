package grandet.airbnb.logements;

import grandet.airbnb.utilisateurs.Hote;

public class Maison extends Logement{
    private int superficieJardin;
    private boolean possedePiscine;

    public Maison(String name, Hote hoteLogement, int tarifParNuitLogement, String adresseLogement, int superficieLogement,
                  int nbVoyageursMaxLogement, int superficieJardinLogement, boolean possedePiscineLogement) {
        super(name, hoteLogement, tarifParNuitLogement, adresseLogement, superficieLogement, nbVoyageursMaxLogement);
        superficieJardin = superficieJardinLogement;
        possedePiscine = possedePiscineLogement;
    }

    @Override
    public int getSuperficieTotal() {
        return getSuperficie() + superficieJardin;
    }

    public boolean hasPiscine() {return possedePiscine;}
    @Override
    public void afficher() {
        getHote().afficher();

        System.out.println("Le logement est une maison située " + getAdresse());
        System.out.println("Superficie : " + getSuperficie() + "m²");

        if (superficieJardin > 0) {
            System.out.println("Superficie Jardin : " + superficieJardin + "m²");
        } else {
            System.out.println("Jardin : Non");
        }

        if (possedePiscine) {
            System.out.println("Piscine : Oui");
        } else {
            System.out.println("Piscine : Non");
        }
    }
}
