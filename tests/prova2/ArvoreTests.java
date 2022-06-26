package prova2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArvoreTests {

    @Test
    public void deveObterCaminhoArvoreVazia() {
        Arvore<Integer> arvore = new Arvore<>();

        assertNull(arvore.caminho(99));
    }

    @Test
    public void deveObterCaminhoArvoreSemElementoInformado() {
        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        n1.inserirFilho(n2);
        n1.inserirFilho(n3);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        assertNull(arvore.caminho(99));
    }

    // Incompleto
    @Test
    public void deveObterCaminhoAteElemento() {
        NoArvore<Integer> n10 = new NoArvore<>(10);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n1 = new NoArvore<>(1);

        n9.inserirFilho(n10);

        n7.inserirFilho(n8);
        n7.inserirFilho(n9);

        n3.inserirFilho(n4);

        n2.inserirFilho(n3);
        n2.inserirFilho(n5);

        n1.inserirFilho(n2);
        n1.inserirFilho(n6);
        n1.inserirFilho(n7);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        assertEquals("1;2;5", arvore.caminho(5));
    }

    @Test
    public void deveObterGrauDaArvore1() {
        NoArvore<Integer> n10 = new NoArvore<>(10);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n1 = new NoArvore<>(1);

        n9.inserirFilho(n10);

        n7.inserirFilho(n8);
        n7.inserirFilho(n9);

        n3.inserirFilho(n4);

        n2.inserirFilho(n3);
        n2.inserirFilho(n5);

        n1.inserirFilho(n2);
        n1.inserirFilho(n6);
        n1.inserirFilho(n7);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        assertEquals(3, arvore.getGrau());
    }

    @Test
    public void deveObterGrauDaArvore2() {
        NoArvore<Integer> n11 = new NoArvore<>(11);
        NoArvore<Integer> n12 = new NoArvore<>(12);
        NoArvore<Integer> n10 = new NoArvore<>(10);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n1 = new NoArvore<>(1);

        n9.inserirFilho(n10);

        n7.inserirFilho(n8);
        n7.inserirFilho(n9);

        n3.inserirFilho(n4);

        n2.inserirFilho(n3);
        n2.inserirFilho(n5);
        n2.inserirFilho(n11);
        n2.inserirFilho(n12);

        n1.inserirFilho(n2);
        n1.inserirFilho(n6);
        n1.inserirFilho(n7);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        assertEquals(4, arvore.getGrau());
    }

    @Test
    public void deveObterGrauDaArvoreApenasRaiz() {
        NoArvore<Integer> n1 = new NoArvore<>(1);
        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        assertEquals(0, arvore.getGrau());
    }

    @Test
    public void deveObterGrauDaArvoreVazia() {
        Arvore<Integer> arvore = new Arvore<>();

        assertEquals(-1, arvore.getGrau());
    }
} 