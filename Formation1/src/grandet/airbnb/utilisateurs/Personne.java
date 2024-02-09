package grandet.airbnb.utilisateurs;

import java.util.Objects;

public class Personne {
    public String prenom;
    public String nom;
    public int age;

    /**
     * Constructeur permettant de renseigner une nouvelle personne
     * @param prenomPers le prenom
     * @param nomPers le nom
     * @param agePers l'âge
     */
    public Personne(String prenomPers, String nomPers, int agePers){
        prenom = prenomPers;
        nom = nomPers;
        age = agePers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return age == personne.age && Objects.equals(prenom, personne.prenom) && Objects.equals(nom, personne.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, age);
    }

    /**
     * Methode qui permet d'afficher le prenom le nom et l'age sous forme de phrase
     * (i.e. Nathan Grandet (27 ans)
     */
    public void afficher(){
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }
}
