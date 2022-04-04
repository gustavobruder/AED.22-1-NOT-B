package lineares.pilhas;

public class PilhaLista<T> implements Pilha<T> {
    private NoLista<T> topo;
    private int tamanho;

    public PilhaLista() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        NoLista<T> novoTopo = new NoLista<T>();
        novoTopo.setInfo(info);
        novoTopo.setProximo(this.topo);
        this.topo = novoTopo;
        this.tamanho++;
    }

    @Override
    public T pop() {
        T info = this.peek();
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return info;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return this.topo.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return this.topo == null;
    }

    @Override
    public void liberar() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String msg = "topo [";
        NoLista<T> no = this.topo;
        while (no != null) {
            msg += no.getInfo() + ", ";
            no = no.getProximo();
        }
        return msg + "] base";
    }
}