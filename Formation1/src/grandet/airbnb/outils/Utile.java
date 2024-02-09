package grandet.airbnb.outils;
import grandet.airbnb.reservations.Sejour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utile {

    /**
     *
     * @param date la date utilisée en entrée de la méthode
     * @return une chaine de caractères sous le format jj/mm/yyyy
     */
    public static String dateToString(Date date) {
        int annee = (date.getYear() +1900);
        int mois  = (date.getMonth() + 1);
        int jour = date.getDate();

        String anneeDate = "" + annee;

        String moisDate;
        if (mois < 10) {
            moisDate = "0" + mois;
        } else {
            moisDate = "" + mois;
        }

        String jourDate;
        if (jour < 10) {
            jourDate = "0" + jour;
        } else {
            jourDate = "" + jour;
        }

        return (jourDate + "/" + moisDate + "/" + anneeDate);
    }
    public static String dateToString2(Date date){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "" + simpleDateFormat;
    }
}
