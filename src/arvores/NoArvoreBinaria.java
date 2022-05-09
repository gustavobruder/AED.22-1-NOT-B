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

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvoreBinaria<T> infoPertence = null;
        if (this.dir != null) {
            infoPertence = this.dir.pertence(info);
        }
        if (infoPertence == null && this.esq != null) {
            infoPertence = this.esq.pertence(info);
        }
        return infoPertence;
    }

    public String imprimePre() {
        StringBuilder builder = new StringBuilder()
                .append("<")
                .append(this.info.toString());

        if (this.esq != null) {
            builder.append(this.esq.imprimePre());
        } else {
            builder.append("<>");
        }

        if (this.dir != null) {
            builder.append(this.dir.imprimePre());
        } else {
            builder.append("<>");
        }

        return builder.append(">").toString();
    }
}