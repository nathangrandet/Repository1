package grandet.airbnb.reservations;
import grandet.airbnb.outils.MaDate;
import grandet.airbnb.utilisateurs.Personne;
import grandet.airbnb.logements.Logement;
import grandet.airbnb.outils.Utile;
import grandet.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
   private int identifiant;
   private final SejourInterface sejour;
   private final Voyageur voyageur;
   private final boolean estValidee;
   private final MaDate datedeReservation;

   /**
    * Constructeur qui permet de créer une nouvelle réservation
    * @param voyageurResa l'identité du voyageur
    * @param sejourResa les caractéristiques du séjour
    */
   public Reservation(Voyageur voyageurResa, SejourInterface sejourResa) throws Exception {
      voyageur = voyageurResa;
      sejour = sejourResa;
      identifiant += 1;
      estValidee = true;
      datedeReservation = new MaDate();

      if (!sejour.verificationNombreDeVoyageurs()) {
         Exception exception = new Exception("Erreur - nombre de voyageurs");
         throw exception;
      }

      if (!sejour.verificationNombreDeNuits()) {
         Exception exception = new Exception("Erreur - nombre de nuits");
         throw exception;
      }

      if (!sejour.verificationDateArrivee()) {
         Exception exception = new Exception("Erreur - date incorrecte");
         throw exception;
      }
   }

   public void afficher(){
      System.out.println("Réservation n°" + identifiant);
      System.out.println("Date de réservation : " + datedeReservation);
      voyageur.afficher();
      System.out.print(" a fait une réservation chez ");
      sejour.afficher();

   }
}