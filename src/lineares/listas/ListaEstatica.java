package lineares.listas;

public class ListaEstatica<T> implements Lista<T> {
    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = (T[]) new Object[10];
        this.tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (this.tamanho == this.info.length) {
            this.redimensionar();
        }
        this.info[this.tamanho] = valor;
        this.tamanho++;
    }

    private void redimensionar() {
        T[] novo = (T[]) new Object[this.tamanho + 10];
        for (int i = 0; i < this.info.length; i++) {
            novo[i] = this.info[i];
        }
        this.info = novo;
    }

    @Override
    public String exibir() {
        String str = "[";
        for (int i = 0; i < this.tamanho; i++) {
            str += this.info[i] + ", ";
        }
        return str + "]";
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void retirar(T valor) {
        int index = buscar(valor);
        if (index != -1) {
            for (int i = index; i < this.tamanho - 1; i++) {
                this.info[i] = this.info[i + 1];
            }
            this.tamanho--;
        }
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public Lista<T> copiar() {
        Lista<T> copia = new ListaEstatica<>();

        for (int i = 0; i < this.tamanho; i++) {
            copia.inserir(this.info[i]);
        }

        return copia;
    }

    @Override
    public void concatenar(Lista<T> outra){
        for (int i = 0; i < outra.getTamanho(); i++){
            this.inserir(outra.pegar(i));
        }
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public Lista<T> dividir()
    {
        Lista<T> outraParte = new ListaEstatica<>();
        int metade = this.tamanho / 2;

        for (int i = metade; i < this.tamanho; i++){
            outraParte.inserir(this.info[i]);
        }

        this.tamanho = metade;
        return outraParte;
    }


    @Override
    public T pegar(int posicao) {
        return this.info[posicao];
    }
}