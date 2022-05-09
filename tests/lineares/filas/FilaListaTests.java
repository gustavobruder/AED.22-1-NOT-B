package lineares.filas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaListaTests {
    @Test
    public void deveInserirNaFilaLista() {
        FilaLista<Integer> fila1 = new FilaLista<Integer>();

        assertTrue(fila1.estaVazia());

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);

        assertFalse(fila1.estaVazia());
    }

    @Test
    public void deveRemoverDaFilaLista() {
        FilaLista<Integer> fila1 = new FilaLista<Integer>();

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);

        assertFalse(fila1.estaVazia());

        int n1 = fila1.retirar();
        int n2 = fila1.retirar();
        int n3 = fila1.retirar();

        assertEquals(n1, 11);
        assertEquals(n2, 12);
        assertEquals(n3, 13);

        assertTrue(fila1.estaVazia());
    }

    @Test
    public void deveLimparFilaLista() {
        FilaLista<Integer> fila1 = new FilaLista<Integer>();

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);

        assertFalse(fila1.estaVazia());

        fila1.liberar();

        assertTrue(fila1.estaVazia());
    }

    @Test
    public void deveObterElementosDaFilaLista() {
        FilaLista<Integer> fila1 = new FilaLista<Integer>();

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);

        assertFalse(fila1.estaVazia());

        int n1 = fila1.peek();
        int n2 = fila1.peek();
        int n3 = fila1.retirar();
        int n4 = fila1.peek();

        assertEquals(n1, 11);
        assertEquals(n2, 11);
        assertEquals(n3, 11);
        assertEquals(n4, 12);

        assertFalse(fila1.estaVazia());
    }
}