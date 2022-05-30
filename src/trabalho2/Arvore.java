package trabalho2;

/*
 * @autores: Gustavo Baroni Bruder e Felipe Melio Tomelin
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

    public int getAltura() {
        if (this.vazia()) {
            return -1;
        }
        return this.getRaiz().getAltura();
    }

    public int getNivel(T info) {
        if (this.vazia()) {
            return -1;
        }
        return this.getRaiz().getNivel(info, -1);
    }

    public boolean isBalanceada() {
        int alturaArvore = this.getAltura();

        if (alturaArvore <= 2) {
            return true;
        }
        return this.getRaiz().isBalanceada(0, alturaArvore);
    }
}