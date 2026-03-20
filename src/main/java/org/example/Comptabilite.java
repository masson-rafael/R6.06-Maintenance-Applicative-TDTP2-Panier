package org.example;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Comptabilite implements Observer {
    private String comptabilite;

    public Comptabilite(String pComptabilite) {
        this.comptabilite = pComptabilite;
    }
    public String traite(String contenu) {
        return ("comptabilité:" + contenu.toString().toLowerCase());
    }

    @Override
    public void update(Observable pSujet, Object pObject) {
        traite((String)(pObject).toString());
    }
}
