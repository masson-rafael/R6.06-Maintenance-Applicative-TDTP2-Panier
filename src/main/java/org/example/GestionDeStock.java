package org.example;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class GestionDeStock implements Observer {
    private String gestionStock;

    public GestionDeStock(String pGestionStock) {
        this.gestionStock = pGestionStock;
    }
    public String traite(String contenu) {

        return ("G.DES.STOCKS:" + contenu.toString().toUpperCase());
    }

    @Override
    public void update(Observable pSujet, Object pObject) {
        traite((String)(pObject).toString());
    }
}
