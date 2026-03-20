package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GestionDeStockTest {

    @Test
    void devrait_retourner_gestion_des_stocks_message_quand_traite() {
        // Given
        GestionDeStock stock = new GestionDeStock("StockTest");
        String message = "MessageTest";

        // When
        String result = stock.traite(message);
        
        // Then
        assertThat(result)
                .isEqualTo("G.DES.STOCKS:MESSAGETEST");
    }
}

