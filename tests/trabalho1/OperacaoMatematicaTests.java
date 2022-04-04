package trabalho1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperacaoMatematicaTests {

    @Test
    public void deveCalcularAdicao() {
        OperacaoMatematica operacao = new Adicao();

        double resultado1 = operacao.calcular(2, 3);
        assertEquals(resultado1, 5);

        double resultado2 = operacao.calcular(17.8, 23.3);
        assertEquals(resultado2, 41.1);

        double resultado3 = operacao.calcular(-8, -3);
        assertEquals(resultado3, -11);
    }

    @Test
    public void deveCalcularSubtracao() {
        OperacaoMatematica operacao = new Subtracao();

        double resultado1 = operacao.calcular(2, 3);
        assertEquals(resultado1, -1);

        double resultado2 = operacao.calcular(17.8, 23.3);
        assertEquals(resultado2, -5.5);

        double resultado3 = operacao.calcular(39, -8);
        assertEquals(resultado3, 47);
    }

    @Test
    public void deveCalcularMultiplicacao() {
        OperacaoMatematica operacao = new Multiplicacao();

        double resultado1 = operacao.calcular(2, 3);
        assertEquals(resultado1, 6);

        double resultado2 = operacao.calcular(8.8, 3.3);
        assertEquals(resultado2, 29.04);

        double resultado3 = operacao.calcular(14.7, 3);
        assertEquals(resultado3, 44.1, 0.01);
    }

    @Test
    public void deveCalcularDivisao() {
        OperacaoMatematica operacao = new Divisao();

        double resultado1 = operacao.calcular(6, 3);
        assertEquals(resultado1, 2);

        double resultado2 = operacao.calcular(15, 2);
        assertEquals(resultado2, 7.5);

        double resultado3 = operacao.calcular(82.9, 5);
        assertEquals(resultado3, 16.58, 0.01);
    }
}