package trabalho3;

import java.util.Objects;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class MapaDispersao<K, T> {
    private Lista<K, T>[] tabela;

    public MapaDispersao(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Tamanho do mapa deve ser maior ou igual a 0");
        }
        this.setTabela(quantidade);
    }

    private void setTabela(int quantidade) {
        this.tabela = new Lista[quantidade];

        for (int i = 0; i < quantidade; i++) {
            this.tabela[i] = new ListaEncadeada<K, T>();
        }
    }

    private int calcularHash(K chave) {
        int chaveHash = Objects.hashCode(chave);
        int chaveHashHexa = chaveHash & 0x7fffffff;
        int tamanhoTabela = this.tabela.length;

        if (tamanhoTabela <= 0) {
            throw new RuntimeException("Falha ao realizar operação, capacidade do mapa inválida.");
        }

        return chaveHashHexa % tamanhoTabela;
    }

    public boolean inserir(K chave, T dado) {
        int hash = this.calcularHash(chave);
        Lista<K, T> lista = this.tabela[hash];

        int index = lista.buscar(chave);
        if (index == -1) {
            lista.inserir(chave, dado);
            return true;
        }

        return false;
    }

    public T remover(K chave) {
        int hash = this.calcularHash(chave);
        Lista<K, T> lista = this.tabela[hash];
        T dado = lista.buscarValor(chave);

        if (dado != null) {
            lista.retirar(chave);
        }

        return dado;
    }

    public T buscar(K chave) {
        int hash = this.calcularHash(chave);
        Lista<K, T> lista = this.tabela[hash];
        return lista.buscarValor(chave);
    }

    public int quantosElementos() {
        int tamanho = 0;

        for (Lista<K, T> lista : this.tabela) {
            tamanho += lista.getTamanho();
        }

        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.tabela.length; i++) {
            Lista<K, T> lista = this.tabela[i];

            builder
                .append("[")
                .append(i)
                .append("]")
                .append(" = ")
                .append(lista.toString())
                .append("\n");
        }

        return builder.toString();
    }
}