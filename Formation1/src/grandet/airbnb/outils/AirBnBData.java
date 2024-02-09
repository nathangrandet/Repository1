package grandet.airbnb.outils;

import grandet.airbnb.utilisateurs.Hote;
import grandet.airbnb.logements.Logement;
import grandet.airbnb.outils.LogementsDomParser;
import grandet.airbnb.utilisateurs.Voyageur;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class AirBnBData {
    private static AirBnBData instance = new AirBnBData();
    private ArrayList<Hote> listHotes;
    private ArrayList<Logement> listLogements;

    private AirBnBData () {
        listHotes = new ArrayList<>();
        listLogements = new ArrayList <>();
        // TODO : parser avec le fichier XML
        try {
            LogementsDomParser.parse("ressources/logements.xml", listHotes, listLogements);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static AirBnBData getInstance() {
        return instance;
    }
    public ArrayList<Hote> getListeHotes() {
        return instance.listHotes;
    }

    public  ArrayList<Logement> getListeLogements() {
        return instance.listLogements;
    }
}
