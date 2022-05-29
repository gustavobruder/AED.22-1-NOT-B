package arvores;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria(T info) {
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        this.esq = esq;
        this.dir = dir;
    }

    public T getInfo() {
        return this.info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esq;
    }

    public void setEsq(NoArvoreBinaria<T> esq) {
        this.esq = esq;
    }

    public NoArvoreBinaria<T> getDir() {
        return dir;
    }

    public void setDir(NoArvoreBinaria<T> dir) {
        this.dir = dir;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvoreBinaria<T> no = null;

        if (this.esq != null) {
            no = this.esq.pertence(info);
        }
        if (no == null && this.dir != null) {
            no = this.dir.pertence(info);
        }

        return no;
    }

    public String imprimePre() {
        String retorno = "<" + this.info;

        if (this.esq == null) {
            retorno += "<>";
        } else {
            retorno += this.esq.imprimePre();
        }

        if (this.dir == null){
            retorno += "<>";
        } else {
            retorno += this.dir.imprimePre();
        }

        retorno += ">";
        return retorno;
    }
}