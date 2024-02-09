package grandet.airbnb.reservations;

import grandet.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

    /**
     * Constructeur qui permet de créer un nouveau séjour
     *
     * @param dateArriveeSejour la date d'arrivée
     * @param nbNuitsSejour     le nombre de nuits
     * @param logementSejour    le logement
     * @param nbVoyageursSejour le nombre de voyageurs
     */
    SejourCourt(Date dateArriveeSejour, int nbNuitsSejour, Logement logementSejour, int nbVoyageursSejour) {
        super(dateArriveeSejour, nbNuitsSejour, logementSejour, nbVoyageursSejour);

    }
    @Override
    public boolean verificationNombreDeNuits() {
        return (1 <= getNuits()) && (getNuits() <= 5);
    }
    @Override
    public void miseAJourDuTarif(){
        this.tarif = getLogement().getTarifParNuit() * getNuits();
    };
    @Override
    public boolean beneficiePromotion() {
        return false;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour court est de " + tarif + "€.");
    }
}
