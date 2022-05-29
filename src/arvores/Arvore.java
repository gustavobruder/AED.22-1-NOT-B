package arvores;

public class Arvore<T> {
    private NoArvore<T> raiz;

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        }
        return this.getRaiz().pertence(info);
    }

    public boolean vazia() {
        return this.raiz == null;
    }

    public String toString() {
        if (this.vazia()) {
            return "<>";
        } else {
            return this.getRaiz().imprimePre();
        }
    }
}