package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ComptabiliteTest {

    @Test
    void devrait_retourner_comptabilite_message_quand_traite() {
        // Given
        Comptabilite compta = new Comptabilite("ComptaTest");
        String message = "MessageTest";
        
        // When
        String result = compta.traite(message);
        
        // Then
        assertThat(result)
            .isEqualTo("comptabilité:messagetest");
    }
}

