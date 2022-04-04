package lineares.pilhas;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        if (this.limite == this.tamanho) {
            throw new RuntimeException("Capacidade esgotada da pilha");
        }

        this.info[this.tamanho] = info;
        this.tamanho++;
    }

    @Override
    public T pop() {
        T valor = this.peek();
        this.tamanho--;
        this.info[tamanho] = null;
        return valor;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return this.info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[this.limite];
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String msg = "topo [";
        for (int i = this.tamanho -1; i >= 0; i--) {
            msg += this.info[i] + ", ";
        }
        return msg + "] base";
    }
}