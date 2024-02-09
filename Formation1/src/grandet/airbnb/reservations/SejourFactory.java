package grandet.airbnb.reservations;

import grandet.airbnb.logements.Maison;
import grandet.airbnb.outils.MaDate;

public class SejourFactory {

    public static Sejour createSejour(int nbNuits, MaDate voyageDate, Maison maisonLogement) {
        Sejour sejour;
        if (nbNuits <= 6) {
            sejour = new SejourCourt(voyageDate, nbNuits, maisonLogement, 4);

        } else {
            sejour = new SejourLong(voyageDate, nbNuits, maisonLogement, 3);
        }
        return sejour;
    }


}
