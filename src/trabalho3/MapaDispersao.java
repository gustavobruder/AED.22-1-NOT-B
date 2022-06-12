package trabalho3;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public class MapaDispersao<K, T> {
    private Lista<K, T>[] tabela;

    public MapaDispersao(int quantidade) {
        this.setTabela(quantidade);
    }

    public void setTabela(int quantidade) {
        this.tabela = new Lista[quantidade];
    }

    private int calcularHash(K chave) {
        int chaveHash = chave.hashCode();
        int tamanhoTabela = this.tabela.length;
        int hash = chaveHash % tamanhoTabela;
        return hash;
    }

    public boolean inserir(K chave, T dado) {
        int hash = this.calcularHash(chave);
        Lista<K, T> lista = this.tabela[hash];

        if (lista == null) {
            lista = new ListaEncadeada<K, T>();
            this.tabela[hash] = lista;
        }

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

        if (lista == null) {
            lista = new ListaEncadeada<K, T>();
            this.tabela[hash] = lista;
        }

        int index = lista.buscar(chave);
        if (index == -1) {
            return null;
        }

        T dado = lista.pegar(index);
        lista.retirar(chave);
        return dado;
    }

    public T buscar(K chave) {
        int hash = this.calcularHash(chave);
        Lista<K, T> lista = this.tabela[hash];

        if (lista == null) {
            lista = new ListaEncadeada<K, T>();
            this.tabela[hash] = lista;
        }

        int index = lista.buscar(chave);
        if (index == -1) {
            return null;
        }

        return lista.pegar(index);
    }

    public int quantosElementos() {
        int tamanho = 0;

        for (int i = 0; i < this.tabela.length; i++) {
            Lista<K, T> lista = this.tabela[i];
            if (lista != null) {
                tamanho += lista.getTamanho();
            }
        }

        return tamanho;
    }
}