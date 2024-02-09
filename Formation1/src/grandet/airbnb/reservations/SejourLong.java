package grandet.airbnb.reservations;

import grandet.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface{
    private int promotion;
    private static final int PROMOTION_EN_POURCENTAGE = 20;
    /**
     * Constructeur qui permet de créer un nouveau séjour
     *
     * @param dateArriveeSejour la date d'arrivée
     * @param nbNuitsSejour     le nombre de nuits
     * @param logementSejour    le logement
     * @param nbVoyageursSejour le nombre de voyageurs
     */
    SejourLong(Date dateArriveeSejour, int nbNuitsSejour, Logement logementSejour, int nbVoyageursSejour) {
        super(dateArriveeSejour, nbNuitsSejour, logementSejour, nbVoyageursSejour);
         int tarifInitial = nbNuitsSejour * logementSejour.getTarifParNuit();
        this.promotion = tarifInitial * PROMOTION_EN_POURCENTAGE / 100;
        tarif = tarifInitial - promotion;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return (6 <= getNuits()) && (getNuits() <= 31);
    }
    @Override
    public boolean beneficiePromotion() {
        return true;
    }
    @Override
    public void miseAJourDuTarif(){
        this.tarif = getLogement().getTarifParNuit() * getNuits();
    };

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour long est de " + tarif + "€ (" + promotion + "€ de promotion)." );
    }
}
