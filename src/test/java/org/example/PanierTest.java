package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PanierTest {

    private GestionDeStock stock;
    private Comptabilite compta;
    private Panier panier;

    @BeforeEach
    public void setUp() {
        // Given
        stock = mock(GestionDeStock.class);
        compta = mock(Comptabilite.class);
        panier = new Panier(stock, compta);
    }

    @Test
    void devrait_notifier_les_observateurs_compta_et_stock_au_declenchement_de_la_commande() {
        // Given
        Panier.DeclenchementCommande sujet = panier.new DeclenchementCommande();

        // When
        sujet.addObserver(compta);
        sujet.addObserver(stock);
        sujet.setChanged();
        sujet.notifyObservers(panier.getContenu());

        // Then
        verify(compta, times(1)).update(any(Observable.class), eq("Contenu du panier"));
        verify(stock, times(1)).update(any(Observable.class), eq("Contenu du panier"));
    }

    @Test
    void devrait_retourner_le_contenu_du_panier_quand_getContenu() {
         // Given

         // When
         String result = panier.getContenu();

         // Then
         assertThat(result).isEqualTo("Contenu du panier");
    }
}



