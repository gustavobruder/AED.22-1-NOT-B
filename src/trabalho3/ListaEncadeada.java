package trabalho3;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class ListaEncadeada<K, T> implements Lista<K, T> {
    private NoLista<K, T> primeiro;
    private NoLista<K, T> ultimo;
    private int tamanho;

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazia() {
        return this.primeiro == null;
    }

    @Override
    public int buscar(K chave) {
        int posicao = 0;
        NoLista<K, T> p = this.primeiro;
        while (p != null) {
            if (p.getChave().equals(chave)) {
                return posicao;
            }
            p = p.getProximo();
            posicao++;
        }
        return -1;
    }

    @Override
    public void inserir(K chave, T valor) {
        NoLista<K, T> novo = new NoLista<>(chave, valor);
        if (this.estaVazia()) {
            this.primeiro = novo;
        } else {
            this.ultimo.setProximo(novo);
        }
        this.ultimo = novo;
        this.tamanho++;
    }

    @Override
    public void retirar(K chave) {
        NoLista<K, T> anterior = null;
        NoLista<K, T> p = this.primeiro;

        while (p != null && !p.getChave().equals(chave)) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
            this.tamanho--;
        }
        if (this.ultimo == p) {
            this.ultimo = anterior;
        }
    }

    @Override
    public T pegar(int posicao) {
        if (posicao < 0 || posicao >= this.getTamanho()) {
            throw new IndexOutOfBoundsException("Posicao = " + posicao + "; Tamanho = " + this.getTamanho());
        }

        int resultado = 0;
        NoLista<K, T> p = this.primeiro;

        while (p != null) {
            if (resultado == posicao) {
                return p.getValor();
            }
            p = p.getProximo();
            resultado++;
        }

        return null;
    }

    @Override
    public T buscarValor(K chave) {
        NoLista<K, T> p = this.primeiro;

        while (p != null) {
            if (p.getChave().equals(chave)) {
                return p.getValor();
            }
            p = p.getProximo();
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        NoLista<K, T> p = this.primeiro;

        while (p != null) {
            builder.append(p.toString()).append(", ");
            p = p.getProximo();
        }

        return builder.append("]").toString();
    }
}