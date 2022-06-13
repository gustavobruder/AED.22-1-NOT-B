package trabalho3;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
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

    @Override
    public String toString() {
        return new StringBuilder("(")
            .append("Chave: ")
            .append(this.getChave())
            .append(", ")
            .append("Valor: ")
            .append(this.getValor())
            .append(")")
            .toString();
    }
}