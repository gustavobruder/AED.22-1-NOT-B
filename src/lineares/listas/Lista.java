package lineares.listas;

public interface Lista<T> {
    void inserir(T valor);
    String exibir();
    int buscar(T valor);
    void retirar(T valor);
    boolean estaVazia();
    Lista<T> copiar();
    void concatenar(Lista<T> outra);
    int getTamanho();
    Lista<T> dividir();
    T pegar(int posicao);
}
