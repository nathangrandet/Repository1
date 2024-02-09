package grandet.airbnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne{
    private int delaiDeReponse;

    /**
     *
     * @param prenomPers
     * @param nomPers
     * @param agePers
     * @param delaiDeReponseHote délai de réponse
     */
    public Hote(String prenomPers, String nomPers, int agePers, int delaiDeReponseHote) {
        super(prenomPers, nomPers, agePers);
        delaiDeReponse = delaiDeReponseHote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hote hote = (Hote) o;
        return delaiDeReponse == hote.delaiDeReponse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), delaiDeReponse);
    }

    @Override
    public void afficher() {
        super.afficher();

        if (delaiDeReponse == 1) {
            System.out.println(" qui s'engage à repondre dans l'heure.");
        } else {
            System.out.println(" qui s'engage à repondre dans les " + delaiDeReponse + " heures");
        }
    }
}
