package lineares.filas;

import lineares.listas.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista;

    public FilaLista() {
        this.lista = new ListaEncadeada<T>();
    }

    @Override
    public void inserir(T valor) {
        this.lista.inserir(valor);
    }

    @Override
    public T retirar() {
        T valor = this.peek();
        this.lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new RuntimeException("Fila está vazia");
        }
        return this.lista.pegar(0);
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public void liberar() {
        this.lista = new ListaEncadeada<T>();
    }
}