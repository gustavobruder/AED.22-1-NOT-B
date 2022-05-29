package arvores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArvoreBSTTests {

    @Test
    public void deveBuscarElementosNaArvore() {
        ArvoreBST<String> arvoreBST = new ArvoreBST<>();
        arvoreBST.inserir("Joana");
        arvoreBST.inserir("Joao");
        arvoreBST.inserir("Carlos");
        arvoreBST.inserir("Zeca");
        arvoreBST.inserir("Ana");
        arvoreBST.inserir("Danilo");
        arvoreBST.inserir("Yuri");
        arvoreBST.inserir("José");
        arvoreBST.inserir("Patricia");
        arvoreBST.inserir("Maria");

        assertNull(arvoreBST.buscar("Pedro"));
        assertEquals("Danilo", arvoreBST.buscar("Danilo").getInfo());
        assertEquals("Maria", arvoreBST.buscar("Maria").getInfo());
    }

    @Test
    public void deveSobreescreverToString() {
        ArvoreBST<String> arvoreBST = new ArvoreBST<>();
        arvoreBST.inserir("Joana");
        arvoreBST.inserir("Joao");
        arvoreBST.inserir("Carlos");
        arvoreBST.inserir("Zeca");
        arvoreBST.inserir("Ana");
        arvoreBST.inserir("Danilo");
        arvoreBST.inserir("Yuri");
        arvoreBST.inserir("José");
        arvoreBST.inserir("Patricia");
        arvoreBST.inserir("Maria");

        String expectedToString = "<Joana<Carlos<Ana<><>><Danilo<><>>><Joao<><Zeca<Yuri<José<><Patricia<Maria<><>><>>><>><>>>>";
        assertEquals(expectedToString, arvoreBST.toString());
    }

    @Test
    public void deveValidarArvoreVazia() {
        ArvoreBST<String> arvoreBST1 = new ArvoreBST<>();
        arvoreBST1.inserir("Joana");

        ArvoreBST<String> arvoreBST2 = new ArvoreBST<>();

        assertFalse(arvoreBST1.vazia());
        assertTrue(arvoreBST2.vazia());
    }

    @Test
    public void deveRetirarElementosDaArvore() {
        ArvoreBST<String> arvoreBST = new ArvoreBST<>();
        assertTrue(arvoreBST.vazia());

        arvoreBST.inserir("Joana");
        arvoreBST.inserir("Joao");
        arvoreBST.inserir("Carlos");
        arvoreBST.inserir("Zeca");
        assertFalse(arvoreBST.vazia());

        arvoreBST.retirar("Joana");
        arvoreBST.retirar("Joao");
        arvoreBST.retirar("Carlos");
        arvoreBST.retirar("Zeca");
        assertTrue(arvoreBST.vazia());

        String expectedToString = "<>";
        assertEquals(expectedToString, arvoreBST.toString());
    }
} 