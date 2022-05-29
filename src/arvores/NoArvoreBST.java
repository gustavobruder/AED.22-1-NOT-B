package arvores;

public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public NoArvoreBST<T> buscar(T valor) {
        if (this.getInfo().equals(valor)) {
            return this;
        } else {
            if (valor.compareTo(this.getInfo()) < 0) {
                if (this.getEsq() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getEsq()).buscar(valor);
                }
            } else {
                if (this.getDir() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getDir()).buscar(valor);
                }
            }
        }
    }

    public void inserir(T info) {
        if (info.compareTo(this.getInfo()) < 0) {
            if (this.getEsq() == null) {
                this.setEsq(new NoArvoreBST<>(info));
            } else {
                ((NoArvoreBST<T>) this.getEsq()).inserir(info);
            }
        } else {
            if (this.getDir() == null) {
                this.setDir(new NoArvoreBST<>(info));
            } else {
                ((NoArvoreBST<T>) this.getDir()).inserir(info);
            }
        }
    }

    public NoArvoreBST<T> buscarPai(T valor, NoArvoreBST<T> pai) {
        if (this.getInfo().equals(valor)) {
            return pai;
        } else {
            if (valor.compareTo(this.getInfo()) < 0) {
                if (this.getEsq() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getEsq()).buscarPai(valor, this);
                }
            } else {
                if (this.getDir() == null) {
                    return null;
                } else {
                    return ((NoArvoreBST<T>) this.getDir()).buscarPai(valor, this);
                }
            }
        }
    }

    public boolean ehFolha() {
        return this.getEsq() == null && this.getDir() == null;
    }

    public boolean temUmFilho() {
        boolean temApenasEsq = this.getEsq() != null && this.getDir() == null;
        boolean temApenasDir = this.getEsq() == null && this.getDir() != null;
        return temApenasEsq || temApenasDir;
        //return Boolean.logicalXor(this.getEsq() == null, this.getDir() == null);
    }

    public String imprimeEmOrdem() {
        String retorno = "";

        if (this.getEsq() != null) {
            retorno += ((NoArvoreBST<T>)this.getEsq()).imprimeEmOrdem();
        }

        retorno += this.getInfo() + ", ";

        if (this.getDir() != null) {
            retorno += ((NoArvoreBST<T>)this.getDir()).imprimeEmOrdem();
        }

        return retorno;
    }
}