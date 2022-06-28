package prova3;

public class ObjetoMapa<K,T> {
    private K chave;
    private T valor;

    public ObjetoMapa() {
    }

    public ObjetoMapa(K chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}