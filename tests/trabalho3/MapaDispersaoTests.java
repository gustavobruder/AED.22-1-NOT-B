package trabalho3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class MapaDispersaoTests {

    @Test
    public void deveInserir() {
        Veiculo veiculo = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(3);

        assertEquals(0, mapa.quantosElementos());

        boolean conseguiuInserir = mapa.inserir(veiculo.getPlaca(), veiculo);
        assertTrue(conseguiuInserir);

        assertEquals(1, mapa.quantosElementos());
    }

    @Test
    public void naoDeveInserirChaveDuplicada() {
        Veiculo v1 = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v2 = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(3);

        assertEquals(0, mapa.quantosElementos());

        boolean conseguiuInserir1 = mapa.inserir(v1.getPlaca(), v1);
        assertTrue(conseguiuInserir1);
        boolean conseguiuInserir2 = mapa.inserir(v2.getPlaca(), v2);
        assertFalse(conseguiuInserir2);

        assertEquals(1, mapa.quantosElementos());
    }

    @Test
    public void deveRemover() {
        Veiculo veiculo = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(2000);

        assertEquals(0, mapa.quantosElementos());

        mapa.inserir(veiculo.getPlaca(), veiculo);

        assertEquals(1, mapa.quantosElementos());

        Veiculo veiculoRemovido = mapa.remover(veiculo.getPlaca());
        assertEquals(veiculo.getPlaca(), veiculoRemovido.getPlaca());
        assertEquals(veiculo.getModelo(), veiculoRemovido.getModelo());
        assertEquals(veiculo.getAno(), veiculoRemovido.getAno());
        assertEquals(veiculo.getProprietario(), veiculoRemovido.getProprietario());
        assertEquals(veiculo, veiculoRemovido);

        assertEquals(0, mapa.quantosElementos());
    }

    @Test
    public void naoDeveRemoverSeNaoEncontrar() {
        Veiculo veiculo = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(2000);

        assertEquals(0, mapa.quantosElementos());

        mapa.inserir(veiculo.getPlaca(), veiculo);

        assertEquals(1, mapa.quantosElementos());

        Veiculo veiculoRemovido = mapa.remover("PLACA-FALHA");
        assertNull(veiculoRemovido);

        assertEquals(1, mapa.quantosElementos());
    }

    @Test
    public void deveBuscarComSucesso() {
        Veiculo veiculo = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");

        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(2000);
        mapa.inserir(veiculo.getPlaca(), veiculo);

        Veiculo veiculoRemovido = mapa.buscar(veiculo.getPlaca());
        assertEquals(veiculo.getPlaca(), veiculoRemovido.getPlaca());
        assertEquals(veiculo.getModelo(), veiculoRemovido.getModelo());
        assertEquals(veiculo.getAno(), veiculoRemovido.getAno());
        assertEquals(veiculo.getProprietario(), veiculoRemovido.getProprietario());
        assertEquals(veiculo, veiculoRemovido);
    }

    @Test
    public void deveBuscarSemSucesso() {
        Veiculo veiculo = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");

        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(2000);
        mapa.inserir(veiculo.getPlaca(), veiculo);

        Veiculo veiculoRemovido = mapa.buscar("AAA-1122");
        assertNull(veiculoRemovido);
        assertEquals(1, mapa.quantosElementos());
    }

    @Test
    public void deveContarQuantidadeElementos() {
        Veiculo v1 = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v2 = new Veiculo("AAA-0123", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v3 = new Veiculo("AAA-4567", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v4 = new Veiculo("AAA-4567", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v5 = new Veiculo("AAA-7890", "Dodge Charger R/T", 1970, "Dominic Toretto");
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao<>(3);

        assertEquals(0, mapa.quantosElementos());

        boolean conseguiuInserir1 = mapa.inserir(v1.getPlaca(), v1);
        assertTrue(conseguiuInserir1);
        boolean conseguiuInserir2 = mapa.inserir(v2.getPlaca(), v2);
        assertFalse(conseguiuInserir2);
        boolean conseguiuInserir3 = mapa.inserir(v3.getPlaca(), v3);
        assertTrue(conseguiuInserir3);
        boolean conseguiuInserir4 = mapa.inserir(v4.getPlaca(), v4);
        assertFalse(conseguiuInserir4);
        boolean conseguiuInserir5 = mapa.inserir(v5.getPlaca(), v5);
        assertTrue(conseguiuInserir5);

        assertEquals(3, mapa.quantosElementos());
    }

    @Test
    public void testeIgualAoVisualgo() {
        MapaDispersao<Integer, Integer> mapa = new MapaDispersao<>(11);

        mapa.inserir(11, 11);
        mapa.inserir(1, 1);
        mapa.inserir(24, 24);
        mapa.inserir(14, 14);
        mapa.inserir(27, 27);
        mapa.inserir(28, 28);
        mapa.inserir(18, 18);
        mapa.inserir(8, 8);
        mapa.inserir(21, 21);
        mapa.inserir(13, 13);
        mapa.inserir(7, 7);
        mapa.inserir(10, 10);
        mapa.inserir(35, 35);

        assertEquals(13, mapa.quantosElementos());
    }

    @Test
    public void deveTratarCasosDeException() {
        MapaDispersao<Integer, Integer> mapa1 = new MapaDispersao<>(0);

        Exception e = null;
        try {
            mapa1.inserir(1, 1);
        } catch(Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        e = null;

        try {
            mapa1.remover(1);
        } catch(Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        e = null;

        try {
            mapa1.buscar(1);
        } catch(Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        e = null;

        mapa1.quantosElementos();

        try {
            MapaDispersao<Integer, Integer> mapa2 = new MapaDispersao<>(-1);
        } catch(Exception ex) {
            e = ex;
        }
        assertNotNull(e);
    }
}