package peter.airbnb.reservations;

import peter.airbnb.logements.Chalet;
import peter.airbnb.logements.Logement;
import peter.airbnb.utils.Utile;

import java.util.Date;

public abstract class Sejour implements SejourInterface {

    private Date dateDArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;
    protected int tarif;

    public Sejour(Date dateDArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateDArrivee = dateDArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;

        this.miseAJourTarif();
    }

    public abstract void miseAJourTarif();

    @Override
    public boolean verificationDateArrivee() {
        Date dateActuelle = new Date();

        if (dateDArrivee.after(dateActuelle)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean verificationNombreDeVoyageurs() {
        return nbVoyageurs >= 1 && nbVoyageurs <= logement.getNbVoyageursMax();
    }

    @Override
    public void afficher() {
        logement.afficher();
        System.out.println("Date d'arrivée : " + dateDArrivee);
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public Logement getLogement() {
        return logement;
    }
}
