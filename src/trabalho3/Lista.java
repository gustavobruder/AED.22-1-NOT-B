package trabalho3;

/*
 * @autores: Gustavo Baroni Bruder, Felipe Melio Tomelin e Ana Carolina da Silva
 * */
public interface Lista<K, T> {
    int getTamanho();
    boolean estaVazia();
    int buscar(K chave);
    void inserir(K chave, T valor);
    void retirar(K chave);
    T pegar(int posicao);
    T buscarValor(K chave);
}