package arvores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreBinariaTests {

    @Test
    public void deveObterElementosPelaDireitaDaArvore() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        assertEquals(arvore.pertence(6), no6);
    }

    @Test
    public void deveObterElementosPelaEsquerdaDaArvore() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        assertEquals(arvore.pertence(4), no4);
    }

    @Test
    public void deveObterElementosPelaDireitaEEsquerdaDaArvore() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        assertEquals(arvore.pertence(7), no7);
    }

    @Test
    public void deveSobreescreverToString() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        assertEquals(arvore.toString(), "<1<2<4<><>><5<><>>><3<><6<7<><>><>>>>");
    }

    @Test
    public void deveValidarArvoreVazia() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, no4, no5);
        NoArvoreBinaria<Integer> no7 = new NoArvoreBinaria<>(7);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6, no7, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, null, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore1 = new ArvoreBinaria<>();
        arvore1.setRaiz(no1);

        ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<>();

        assertFalse(arvore1.vazia());
        assertTrue(arvore2.vazia());
    }
}