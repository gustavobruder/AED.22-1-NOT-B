package lineares.filas;

public class FilaVetor<T> implements Fila<T> {
    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    public int getInicio() {
        return this.inicio;
    }

    public T[] getInfo() {
        return this.info;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public int getLimite() {
        return this.limite;
    }

    @Override
    public void inserir(T valor) {
        if (this.tamanho == this.limite) {
            throw new RuntimeException("Fila está cheia");
        }

        int posicaoInserir = (this.inicio + this.tamanho) % this.limite;
        this.info[posicaoInserir] = valor;
        this.tamanho++;
    }

    @Override
    public T retirar() {
        T valor = this.peek();
        this.inicio = (this.inicio + 1) % this.limite;
        this.tamanho--;
        this.info[this.inicio] = null;
        return valor;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new RuntimeException("Fila está vazia");
        }
        return this.info[this.inicio];
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public String toString() {
        String msg = "";

        int posicao = this.inicio;
        for (int idx = 0; idx < this.tamanho; ++idx)
        {
            msg += this.info[posicao] + ", ";
            posicao = (posicao + 1) % this.limite;
        }

        return msg;
    }

    public FilaVetor<T> concatenar(FilaVetor<T> fila2) {
        FilaVetor<T> fila3 = new FilaVetor<>(getLimite() + fila2.getLimite());

        for (int idx = 0; idx < getTamanho(); idx++)
            fila3.inserir(this.info[(idx + getInicio()) % getLimite()]);

        for (int idx = 0; idx < fila2.getTamanho(); idx++)
            fila3.inserir(fila2.getInfo()[(idx + fila2.getInicio()) % fila2.getLimite()]);

        return fila3;
    }
}