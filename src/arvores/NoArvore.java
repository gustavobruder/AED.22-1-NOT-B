package arvores;

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
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getFilho() {
        return filho;
    }

    public void setFilho(NoArvore<T> filho) {
        this.filho = filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public void setIrmao(NoArvore<T> irmao) {
        this.irmao = irmao;
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
}