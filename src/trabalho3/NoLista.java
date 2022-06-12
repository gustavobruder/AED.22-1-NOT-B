package trabalho3;

public class NoLista<K, T> {
    private K chave;
    private T valor;
    private NoLista<K, T> proximo;

    public NoLista(K chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public T getValor() {
        return valor;
    }

    public NoLista<K, T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<K, T> proximo) {
        this.proximo = proximo;
    }
}