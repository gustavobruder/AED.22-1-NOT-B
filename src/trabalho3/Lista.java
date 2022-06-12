package trabalho3;

public interface Lista<K, T> {
    int getTamanho();
    boolean estaVazia();
    int buscar(K chave);
    void inserir(K chave, T valor);
    void retirar(K chave);
    T pegar(int posicao);
}