package trabalho2;

/*
 * @autores: Gustavo Baroni Bruder e Felipe Melio Tomelin
 * */
public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        this.info = info;
        this.filho = null;
        this.irmao = null;
    }

    public T getInfo() {
        return this.info;
    }

    public NoArvore<T> getFilho() {
        return this.filho;
    }

    public NoArvore<T> getIrmao() {
        return this.irmao;
    }

    public String imprimePre() {
        String retorno = "<" + this.getInfo();

        if (this.getFilho() != null){
            retorno += this.getFilho().imprimePre();
        }

        retorno += ">";

        if (this.getIrmao() != null){
            retorno += this.getIrmao().imprimePre();
        }

        return retorno;
    }

    public void inserirFilho(NoArvore<T> sa) {
        sa.irmao = this.filho;
        this.filho = sa;
    }

    public NoArvore<T> pertence(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        } else {
            NoArvore<T> no = null;
            if (this.getFilho() != null) {
                no = this.getFilho().pertence(info);
            }
            if (no != null) {
                return no;
            }
            if (this.getIrmao() != null) {
                no = this.getIrmao().pertence(info);
            }
            return no;
        }
    }

    public int getAltura() {
        int altura = -1;
        NoArvore<T> no = this.getFilho();

        while (no != null) {
            altura = Math.max(altura, no.getAltura());
            no = no.getIrmao();
        }

        return ++altura;
    }

    public int getNivel(T info, int nivel) {
        if (this.getInfo().equals(info)) {
            return nivel + 1;
        }

        int nivelNo = -1;

        if (this.getFilho() != null) {
            nivelNo = this.getFilho().getNivel(info, nivel + 1);
        }
        if ((this.getIrmao() != null) && (nivelNo == -1)) {
            nivelNo = this.getIrmao().getNivel(info, nivel);
        }

        return nivelNo;
    }

    public boolean isBalanceada(int alturaNo, int alturaArvore) {
        if (this.getFilho() != null) {
            if (!this.getFilho().isBalanceada(alturaNo + 1, alturaArvore)) {
                return false;
            }
        }
        if (this.getIrmao() != null) {
            if (!this.getIrmao().isBalanceada(alturaNo, alturaArvore)) {
                return false;
            }
        }

        if (this.isFolha()) {
            int diferencaEntreAlturas = alturaArvore - alturaNo;
            return Math.abs(diferencaEntreAlturas) <= 1;
        }

        return true;
    }

    private boolean isFolha() {
        return this.getFilho() == null;
    }
}