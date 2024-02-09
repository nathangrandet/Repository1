package grandet.airbnb.logements;

import grandet.airbnb.utilisateurs.Hote;

public class Appartement extends Logement{
    private int numeroEtage;
    private int superficieBalcon;

    public Appartement(String name, Hote hoteLogement, int tarifParNuitLogement, String adresseLogement, int superficieLogement, int nbVoyageursMaxLogement, int numeroEtageLogement, int superficieBalconLogement) {
        super(name, hoteLogement, tarifParNuitLogement, adresseLogement, superficieLogement, nbVoyageursMaxLogement);
        numeroEtage = numeroEtageLogement;
        superficieBalcon = superficieBalconLogement;
    }

    public int getSuperficieBalcon() {return superficieBalcon;}
    @Override
    public int getSuperficieTotal() {
        return getSuperficie() + superficieBalcon;
    }
    @Override
    public void afficher() {
        getHote().afficher();

        System.out.print("Le logement est un appartement situé " + getAdresse());

        if (numeroEtage == 0) {
            System.out.println(" au rez de chaussée.");
        } else if (numeroEtage == 1) {
            System.out.println(" au 1er étage.");
        } else {
            System.out.println(" au " + numeroEtage + "ème étage.");
        }

        System.out.println("Superficie : " + getSuperficie() + " m²");

        if (superficieBalcon > 0) {
            System.out.println("Balcon : Oui (" + superficieBalcon + "m²)");
        } else {
            System.out.println("Balcon : Non");
        }
    }
}
