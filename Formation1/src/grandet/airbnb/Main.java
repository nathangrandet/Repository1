package grandet.airbnb;


import grandet.airbnb.logements.Appartement;
import grandet.airbnb.logements.Logement;
import grandet.airbnb.logements.Maison;
import grandet.airbnb.outils.MaDate;
import grandet.airbnb.outils.Search;
import grandet.airbnb.reservations.*;
import grandet.airbnb.utilisateurs.Hote;
import grandet.airbnb.utilisateurs.Voyageur;
import grandet.airbnb.outils.AirBnBData;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Voyageur voyageurPersonne = new Voyageur("Maxime", "Albert", 29);

        Hote hote1 = new Hote("Peter", "Bardu", 28, 12);

        Maison maisonLogement = new Maison("maison1", hote1, 50, "292 rue Colbert, 37000 Tours", 140, 4, 500, true);
        Appartement appartementLogement = new Appartement("appartement1", hote1, 50, "46 rue des Canonniers, 59800 Lille", 72, 4, 1, 12);

        MaDate voyageDate = new MaDate(11, 02, 2023);

        int nbNuits = 8;

        Sejour sejour1 = SejourFactory.createSejour(nbNuits, voyageDate, maisonLogement);

        if (!sejour1.verificationNombreDeVoyageurs()) {
            System.out.print("Revoir le nombre de voyageurs, qui ne doit pas excéder ");
            System.out.print(sejour1.getLogement().getNbVoyageursMax());
            System.out.println(" voyageurs");
        } else {
            try {
                Reservation reservationSejour = new Reservation(voyageurPersonne, sejour1);
                reservationSejour.afficher();
            } catch (Exception e) {
                System.out.println("Revoir les paramètres" + e.getMessage());
            }
        }

        try {
            int prixNuit = prixDUneNuit(sejour1.getTarif(), nbNuits);
            System.out.println("Le prix d'une nuit est de " + prixNuit + " euros.");
        } catch (ArithmeticException e) {
            System.out.println("Le nombre de nuits ne peut être égal à 0");
        }

        AirBnBData donnee = AirBnBData.getInstance();

        for (int i = 0; i < donnee.getListeLogements().size(); i++) {
            Logement logement = donnee.getListeLogements().get(i);
            logement.afficher();
            System.out.println("------------------------------------------------------------------");
        }
        for (int i = 0; i < donnee.getListeHotes().size() ; i++) {
            Hote hote = donnee.getListeHotes().get(i);
            int test = donnee.getListeHotes().indexOf(hote);
            System.out.println(test);
            hote.afficher();
            System.out.println("------------------------------------------------------------------");
        }

        Search search = new Search.searchBuilder(2).getTarifMinParNuit(30).getPossedePiscine(true).build();
        ArrayList<Logement> resultatDeMaRecherche = search.result();

        for (int i = 0; i < resultatDeMaRecherche.size(); i++) {
            resultatDeMaRecherche.get(i).afficher();
            System.out.println("------------------------------------");
        }
    }

    public static int prixDUneNuit(int prix, int nombreDeNuit) {
        int resultat = prix / nombreDeNuit;
        return resultat;
    }


}
