package arvores;

public class ArvoreBinaria<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
    }

    public void setRaiz(NoArvoreBinaria<T> no) {
        this.raiz = no;
    }

    public boolean vazia() {
        return this.raiz == null;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        }
        return this.raiz.pertence(info);
    }

    @Override
    public String toString() {
        if (this.vazia()) {
            return "<>";
        }
        return this.raiz.imprimePre();
    }
}