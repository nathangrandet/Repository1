package grandet.airbnb.logements;

import grandet.airbnb.utilisateurs.Hote;
import grandet.airbnb.utilisateurs.Personne;

public abstract class Logement {
    private String name;
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

    /**
     * Constructeur permettant de renseigner un logement
     * @param hoteLogement l'hote du logement
     * @param tarifParNuitLogement le tarif par nuit
     * @param adresseLogement l'adresse
     * @param superficieLogement la superficie
     * @param nbVoyageursMaxLogement le nombre de voyageurs
     */
    public Logement(String name, Hote hoteLogement, int tarifParNuitLogement, String adresseLogement, int superficieLogement, int nbVoyageursMaxLogement) {
        this.name = name;
        hote = hoteLogement;
        tarifParNuit = tarifParNuitLogement;
        adresse = adresseLogement;
        superficie = superficieLogement;
        nbVoyageursMax = nbVoyageursMaxLogement;
    }

    /**
     * Accesseurs qui rendent disponible les attributs du Logement
     */
    public Hote getHote() { return hote; }
    public String getAdresse() {return adresse; }
    public int getTarifParNuit(){return tarifParNuit;}
    public int getSuperficie() {return superficie; }
    public int getNbVoyageursMax() {return nbVoyageursMax; }
    public abstract int getSuperficieTotal();

    /**
     * Methode qui permet d'afficher l'adresse et la superficie du logement.
     */
    public abstract void afficher();
}
