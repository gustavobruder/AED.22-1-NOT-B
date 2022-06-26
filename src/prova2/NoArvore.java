package prova2;

/*
 * @autores: Gustavo Baroni Bruder
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

    /* prova 2 */
    public int getGrau() {
        int grau = this.obterGrauNoAtual();

        NoArvore<T> no = this.getFilho();

        while (no != null) {
            grau = Math.max(grau, no.obterGrauNoAtual());
            no = no.getIrmao();
        }

        return grau;
    }

    /* prova 2 */
    private int obterGrauNoAtual() {
        int grau = 0;
        NoArvore<T> no = this.getFilho();

        while(no != null) {
            no = no.getIrmao();
            grau++;
        }

        return grau;
    }
}