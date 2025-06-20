package ilearn.thread;

import ilearn.solucoes.Calculos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoTest {

    Calculos calculo;

    @Test
    void testMediana() {

        calculo = new Calculos(2, 1, 19, 8, 2, 9);

        System.out.println(calculo.numerosOrdenados());

        double valor = calculo.numerosOrdenados().get(0);

        assertEquals(1.0, valor);

        double mediana = calculo.mediana();
        System.out.println(mediana);
        assertEquals(2.0, mediana);

    }

    @Test
    public void testMedia() {
        calculo = new Calculos(19, 20, 5, 6, 9, 10);

        double media = calculo.media();
        System.out.println(media);
        assertEquals(11.5, media);

    }

    @Test
    public void testSoma() {
        calculo = new Calculos(90, 90, 2, 80, 4, 7);
        System.out.println(calculo.soma());
        assertEquals(273.0, calculo.soma());
    }

}
