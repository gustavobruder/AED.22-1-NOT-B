package prova2;

/*
 * @autores: Gustavo Baroni Bruder
 * */
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

    /* prova 2 */
    public String caminho(T procurado) {
        if (this.vazia()) {
            return null;
        }
        NoArvore<T> noProcurado = this.getRaiz().pertence(procurado);
        if (noProcurado == null) {
            return null;
        }

        // Incompleto
        return null;
    }

    /* prova 2 */
    public int getGrau() {
        if (this.vazia()) {
            return -1;
        }
        return this.getRaiz().getGrau();
    }
}