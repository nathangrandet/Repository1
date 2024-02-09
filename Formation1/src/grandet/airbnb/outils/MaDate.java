package grandet.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaDate extends Date{
    /**
     *
     * @param jour entre 1 et 31
     * @param mois entre 1 et 12
     * @param annee ie : 2024
     */
    public  MaDate (int jour, int mois, int annee) {
        super(annee - 1900, mois - 1, jour);
    }

    public MaDate() {
        super();
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = simpleDateFormat.format(this);
        return strDate;
    }
}
