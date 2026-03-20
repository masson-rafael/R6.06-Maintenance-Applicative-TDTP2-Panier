package org.example;

import java.util.ArrayList;
import java.util.Observable;

public class Panier {
    private GestionDeStock stock;
    private Comptabilite compta;
    private String contenu;
    private DeclenchementCommande sujet = new DeclenchementCommande();

    public Panier (GestionDeStock pStock, Comptabilite pCompta) {
        this.stock = pStock;
        this.compta = pCompta;
        this.contenu = new String ("Contenu du panier");
    }

    public String getContenu() {
        return this.contenu;
    };

    public void declencherCommande() {
        this.sujet.notifyObservers(this.contenu);
    }

    public class DeclenchementCommande extends Observable {
        public void notifyObservers() {
            super.addObserver(stock);
            super.addObserver(compta);
            this.setChanged();
            super.notifyObservers();
        }

        public void notifyObservers(Object pObject) {
            super.addObserver(stock);
            super.addObserver(compta);
            this.setChanged();
            System.out.println("Sujet observé notifié: " + pObject);
            super.notifyObservers(pObject);
        }

        public void setChanged() {
            super.setChanged();
        }
    }
}
