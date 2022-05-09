package lineares.filas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaVetorTests {

    @Test
    public void deveInserirElementosNaFila() {
        Fila<Integer> fila = new FilaVetor<Integer>(10);

        assertTrue(fila.estaVazia());

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void deveLiberarTodosOsElementosDaFila() {
        Fila<Integer> fila = new FilaVetor<Integer>(10);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertFalse(fila.estaVazia());

        fila.liberar();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void deveRetirarElementosDaFila() {
        Fila<Integer> fila = new FilaVetor<Integer>(10);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        int n1 = fila.retirar();
        int n2 = fila.retirar();
        int n3 = fila.retirar();

        assertEquals(n1, 10);
        assertEquals(n2, 20);
        assertEquals(n3, 30);

        assertTrue(fila.estaVazia());
    }

    @Test
    public void deveObterElementosDaFila() {
        Fila<Integer> fila = new FilaVetor<Integer>(10);

        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        int n1 = fila.peek();
        int n2 = fila.peek();
        int n3 = fila.retirar();
        int n4 = fila.peek();

        assertEquals(n1, 10);
        assertEquals(n2, 10);
        assertEquals(n3, 10);
        assertEquals(n4, 20);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void deveConcatenarDuasFilas() {
        FilaVetor<Integer> fila1 = new FilaVetor<Integer>(4);
        FilaVetor<Integer> fila2 = new FilaVetor<Integer>(4);

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);
        fila1.retirar();
        fila1.retirar();
        fila1.inserir(14);
        fila1.inserir(15);

        fila2.inserir(21);
        fila2.inserir(22);
        fila2.inserir(23);
        fila2.retirar();
        fila2.retirar();
        fila2.retirar();
        fila2.inserir(24);

        FilaVetor<Integer> fila3 = fila1.concatenar(fila2);

        int tamanhoFilas = fila1.getTamanho() + fila2.getTamanho();
        assertEquals(fila3.getTamanho(), tamanhoFilas);
        assertFalse(fila3.estaVazia());
    }

    @Test
    public void deveRealizarToStringCustomizado() {
        FilaVetor<Integer> fila1 = new FilaVetor<Integer>(4);

        fila1.inserir(11);
        fila1.inserir(12);
        fila1.inserir(13);
        fila1.retirar();
        fila1.retirar();
        fila1.inserir(14);
        fila1.inserir(15);

        String msg = fila1.toString();

        assertEquals(msg, "[ 13, 14, 15, ]");
    }
}