package trabalho4;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class HeapSort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public void sort(T[] vetor) {
        int tamanhoVetor = vetor.length;

        // Cria o heap (reorganiza o vetor)
        for (int i = tamanhoVetor / 2 - 1; i >= 0; i--) {
            heapify(vetor, tamanhoVetor, i);
        }

        // Um por um extrai o elemento do heap
        for (int i = tamanhoVetor - 1; i > 0; i--) {

            // Move a raiz atual para o fim
            T temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            // Chama maximo 'heapify' no heap reduzido
            heapify(vetor, i, 0);
        }
    }

    // Para executar o 'heapify' na sub-arvore da raiz
    void heapify(T[] vetor, int tamanhoHeap, int index) {
        // Inicializar maior como raiz
        int maior = index;
        int esquerda = 2 * index + 1;
        int direita = 2 * index + 2;

        // Se 'esquerda' for maior que a raiz
        if (esquerda < tamanhoHeap && vetor[esquerda].compareTo(vetor[maior]) > 0) {
            maior = esquerda;
        }

        // Se 'direita' for maior que a raiz
        if (direita < tamanhoHeap && vetor[direita].compareTo(vetor[maior]) > 0) {
            maior = direita;
        }

        // Se 'maior' nao for raiz
        if (maior != index) {
            T temp = vetor[index];
            vetor[index] = vetor[maior];
            vetor[maior] = temp;

            // Recursivamente executa 'heapify' na sub-arvore afetada
            heapify(vetor, tamanhoHeap, maior);
        }
    }
}