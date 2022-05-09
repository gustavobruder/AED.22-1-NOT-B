package prova1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaEncadeadaTests {
    @Test
    public void deveObterUltimoIndiceDaLista() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();

        lista.inserir("L");
        lista.inserir("M");
        lista.inserir("A");
        lista.inserir("B");
        lista.inserir("M");
        lista.inserir("N");
        lista.inserir("O");
        lista.inserir("P");
        lista.inserir("P");

        int indice1 = lista.ultimoIndiceDe("M");
        assertEquals(indice1, 4);

        int indice2 = lista.ultimoIndiceDe("P");
        assertEquals(indice2, 8);

        int indice3 = lista.ultimoIndiceDe("K");
        assertEquals(indice3, -1);

        int indice4 = lista.ultimoIndiceDe("L");
        assertEquals(indice4, 0);
    }

    @Test
    public void deveIntercalarListaMaiorComMenor() {
        ListaEncadeada<String> lista1 = new ListaEncadeada<String>();
        ListaEncadeada<String> lista2 = new ListaEncadeada<String>();

        lista1.inserir("A");
        lista1.inserir("B");
        lista1.inserir("C");
        lista1.inserir("C");
        lista1.inserir("L");

        lista2.inserir("D");
        lista2.inserir("E");
        lista2.inserir("F");

        ListaEncadeada<String> listaIntercalada = lista1.intercalar(lista2);
        assertEquals(listaIntercalada.getTamanho(), 8);
        assertEquals(listaIntercalada.exibir(), "[A, D, B, E, C, F, C, L, ]");
    }

    @Test
    public void deveIntercalarListaMenorComMaior() {
        ListaEncadeada<String> lista1 = new ListaEncadeada<String>();
        ListaEncadeada<String> lista2 = new ListaEncadeada<String>();

        lista2.inserir("A");
        lista2.inserir("B");
        lista2.inserir("C");
        lista2.inserir("C");
        lista2.inserir("L");

        lista1.inserir("D");
        lista1.inserir("E");
        lista1.inserir("F");

        ListaEncadeada<String> listaIntercalada = lista1.intercalar(lista2);
        assertEquals(listaIntercalada.getTamanho(), 8);
        assertEquals(listaIntercalada.exibir(), "[D, A, E, B, F, C, C, L, ]");
    }
} 