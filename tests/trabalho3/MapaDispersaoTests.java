package trabalho3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}