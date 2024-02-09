package grandet.airbnb.outils;

import grandet.airbnb.logements.Logement;
import grandet.airbnb.logements.Maison;
import grandet.airbnb.logements.Appartement;
import grandet.airbnb.outils.AirBnBData;

import java.util.ArrayList;

public class Search {
    private static final int OUI = 1;
    private static final int NON = 2 ;
    private static final int PEU_IMPORTE = 3;
    private final int nbVoyageurs; // Attribut obligatoire
    private final int tarifMinParNuit; // attribut optionnel
    private final int tarifMaxParNuit; // attribut optionnel
    private final int possedePiscine; // attribut optionnel
    private final int possedeJardin; // attribut optionnel
    private final int possedeBalcon; // attribut optionnel

    /**
     *
     * @param builder
     */
    private Search (searchBuilder builder) {  this.nbVoyageurs = builder.nbVoyageurs;
                                        this.tarifMinParNuit = builder.tarifMinParNuit;
                                        this.tarifMaxParNuit = builder.tarifMaxParNuit;
                                        this.possedePiscine = builder.possedePiscine;
                                        this.possedeJardin = builder.possedeJardin;
                                        this.possedeBalcon = builder.possedeBalcon;
    }
    public ArrayList<Logement> result() {

        ArrayList<Logement> result = new ArrayList<>();

        for (Logement logement : AirBnBData.getInstance().getListeLogements()) {

            // Test nombre de voyageur
            if (logement.getNbVoyageursMax() < nbVoyageurs)
                continue;

            // Test du tarif par nuit
            if (logement.getTarifParNuit() < tarifMinParNuit || logement.getTarifParNuit() > tarifMaxParNuit)
                continue;

            // Test pour la piscine
            if (possedePiscine == OUI) {
                // Oui pour la piscine du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de piscine, on ne la prend pas
                    if (!maison.hasPiscine())
                        continue;
                } else
                    continue;

            } else if (possedePiscine == NON) {
                // Non pour la piscine
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a une piscine, on ne la prend pas
                    if (maison.hasPiscine())
                        continue;
                }
            }

            // Test pour le balcon
            if (possedeBalcon == OUI) {
                // Oui pour le balcon, c'est forcément un appartement
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement n'a pas de balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeBalcon == NON) {
                // Non pour le balcon
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement a pas un balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() != 0)
                        continue;
                }

            }

            result.add(logement);
        }

        return result;
    }
    public static class searchBuilder {

        private final int nbVoyageurs;
        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private int possedePiscine;
        private int possedeJardin;
        private int possedeBalcon;
        public searchBuilder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
            tarifMinParNuit = 0;
            tarifMaxParNuit = Integer.MAX_VALUE;
            possedePiscine = PEU_IMPORTE;
            possedeBalcon = PEU_IMPORTE;
            possedeJardin = PEU_IMPORTE;
        }
        public searchBuilder getTarifMinParNuit(int tarifMinParNuit) {
            this.tarifMinParNuit = tarifMinParNuit;
            return this;
        }
        public searchBuilder getTarixMaxParNuit(int tarifMaxParNuit) {
            this.tarifMaxParNuit = tarifMaxParNuit;
            return this;
        }

        public searchBuilder getPossedePiscine(boolean possedePiscine) {
            this.possedePiscine = possedePiscine ? OUI : NON;
            return this;
        }
        public searchBuilder getPossedeJardin(boolean possedeJardin) {
            this.possedeJardin = possedeJardin ? OUI : NON;
            return this;
        }
        public searchBuilder getPossedeBalcon(boolean possedeBalcon) {
            this.possedeBalcon = possedeBalcon ? OUI : NON;
            return this;
        }
        public Search build() {
            return new Search(this);
        }

    }
}
