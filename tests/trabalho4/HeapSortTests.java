package trabalho4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class HeapSortTests {

    /* Função utilitaria para converter em string um array de tamanho n */
    private <T> String printArray(T[] arr) {
        StringBuilder builder = new StringBuilder();

        for (T value : arr) {
            builder.append(value).append(" ");
        }

        return builder.toString().trim();
    }

    @Test
    public void deveOrdenarComIntegers1() {
        Integer[] arr = new Integer[] {12, 11, 13, 5, 6, 7};

        HeapSort<Integer> heapSort = new HeapSort<Integer>();
        heapSort.sort(arr);

        assertEquals("5 6 7 11 12 13", printArray(arr));
    }

    @Test
    public void deveOrdenarComIntegers2() {
        Integer[] arr = new Integer[] {13, 12, 11, 7, 6, 5};

        HeapSort<Integer> heapSort = new HeapSort<Integer>();
        heapSort.sort(arr);

        assertEquals("5 6 7 11 12 13", printArray(arr));
    }

    @Test
    public void deveOrdenarComIntegers3() {
        Integer[] arr = new Integer[] {11, 13, 12, 7, 5, 6};

        HeapSort<Integer> heapSort = new HeapSort<Integer>();
        heapSort.sort(arr);

        assertEquals("5 6 7 11 12 13", printArray(arr));
    }

    @Test
    public void deveOrdenarComVeiculos1() {
        Veiculo v1 = new Veiculo("AAA-1111", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v2 = new Veiculo("AAA-2222", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v3 = new Veiculo("AAA-3333", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v4 = new Veiculo("AAA-4444", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v5 = new Veiculo("AAA-5555", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo v6 = new Veiculo("AAA-6666", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo[] arr = new Veiculo[] { v1, v2, v3, v4, v5, v6, };

        HeapSort<Veiculo> heapSort = new HeapSort<Veiculo>();
        heapSort.sort(arr);

        String[] placas = Veiculo.FiltrarPlacas(arr);
        assertEquals("AAA-1111 AAA-2222 AAA-3333 AAA-4444 AAA-5555 AAA-6666", printArray(placas));
    }

    @Test
    public void deveOrdenarComVeiculos2() {
        Veiculo v1 = new Veiculo("AAA-1111", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v2 = new Veiculo("AAA-2222", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v3 = new Veiculo("AAA-3333", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v4 = new Veiculo("AAA-4444", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v5 = new Veiculo("AAA-5555", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo v6 = new Veiculo("AAA-6666", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo[] arr = new Veiculo[] { v6, v5, v4, v3, v2, v1, };

        HeapSort<Veiculo> heapSort = new HeapSort<Veiculo>();
        heapSort.sort(arr);

        String[] placas = Veiculo.FiltrarPlacas(arr);
        assertEquals("AAA-1111 AAA-2222 AAA-3333 AAA-4444 AAA-5555 AAA-6666", printArray(placas));
    }

    @Test
    public void deveOrdenarComVeiculos3() {
        Veiculo v1 = new Veiculo("AAA-1111", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v2 = new Veiculo("AAA-2222", "Hyundai Creta", 2017, "João da Silva");
        Veiculo v3 = new Veiculo("AAA-3333", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v4 = new Veiculo("AAA-4444", "Nissan Skyline R34", 2001, "Brian O'Conner");
        Veiculo v5 = new Veiculo("AAA-5555", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo v6 = new Veiculo("AAA-6666", "Dodge Charger R/T", 1970, "Dominic Toretto");
        Veiculo[] arr = new Veiculo[] { v4, v6, v2, v5, v1, v3, };

        HeapSort<Veiculo> heapSort = new HeapSort<Veiculo>();
        heapSort.sort(arr);

        String[] placas = Veiculo.FiltrarPlacas(arr);
        assertEquals("AAA-1111 AAA-2222 AAA-3333 AAA-4444 AAA-5555 AAA-6666", printArray(placas));
    }
}