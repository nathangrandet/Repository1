package grandet.airbnb.reservations;

import grandet.airbnb.logements.Logement;
import grandet.airbnb.outils.Utile;

import java.util.Date;

public abstract class Sejour implements SejourInterface {

    private final Date dateArrivee;
    private final int nbNuits;
    private final Logement logement;
    private final int nbVoyageurs;
    protected int tarif;

    /**
     * Constructeur qui permet de créer un nouveau séjour
     * @param dateArriveeSejour la date d'arrivée
     * @param nbNuitsSejour le nombre de nuits
     * @param logementSejour le logement
     * @param nbVoyageursSejour le nombre de voyageurs
     */
    public Sejour(Date dateArriveeSejour, int nbNuitsSejour, Logement logementSejour, int nbVoyageursSejour) {
        this.dateArrivee = dateArriveeSejour;
        this.nbNuits = nbNuitsSejour;
        this.logement = logementSejour;
        this.nbVoyageurs = nbVoyageursSejour;
    }

    public int getNbNuits() {return nbNuits;}
    @Override
    public boolean verificationDateArrivee() {
        Date dateDuJour = new Date();
        return dateArrivee.after(dateDuJour);
    }
    @Override
    public boolean verificationNombreDeVoyageurs() {
        return (nbVoyageurs <= logement.getNbVoyageursMax());
    }
    /**
     * récupère la date d'arrivée
     * @return retourne la date d'arrivée
     */
    public Date getDateArrivee(){
        return dateArrivee;
    }
    public int getTarif() {
        return tarif;
    }
    public int getNuits() { return nbNuits;}
    public int getNbVoyageurs(){return nbVoyageurs;}

    public Logement getLogement() {
        return logement;
    }

    public abstract void miseAJourDuTarif();
    public void afficher(){
        logement.afficher();
        System.out.println("La date d'arrivée est le "
                + Utile.dateToString(dateArrivee)
                + " pour " + nbNuits + " nuits.");
    }
}
