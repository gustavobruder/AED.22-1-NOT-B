package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public NoArvoreBST<T> buscar(T valor) {
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscar(valor);
    }

    public void inserir(T info) {
        if (this.vazia()) {
            this.setRaiz(new NoArvoreBST<>(info));
        } else {
            ((NoArvoreBST<T>) this.getRaiz()).inserir(info);
        }
    }

    public void retirar(T valor) {
        NoArvoreBST<T> noARetirar = this.buscar(valor);
        if (noARetirar != null) {
            this.retirar(noARetirar);
        }
    }

    private void retirar(NoArvoreBST<T> noARetirar) {
        NoArvoreBST<T> pai = this.descobrirPai(noARetirar);

        if (noARetirar.ehFolha()) { // caso 1 (é folha)
            if (pai == null) { // nó a retirar é raiz
                this.setRaiz(null);
            } else {
                if (pai.getEsq() == noARetirar) {
                    pai.setEsq(null);
                } else {
                    pai.setDir(null);
                }
            }
        } else {
            if (noARetirar.temUmFilho()) { // caso 2 (tem apenas 1 filho)
                NoArvoreBinaria<T> filho = (noARetirar.getEsq() != null ? noARetirar.getEsq() : noARetirar.getDir());

                if (pai == null) { // nó a retirar é raiz
                    this.setRaiz(filho);
                } else {

                    if (pai.getEsq() == noARetirar) {
                        pai.setEsq(filho);
                    } else {
                        pai.setDir(filho);
                    }
                }
            } else { // caso 3 (tem dois filhos)
                NoArvoreBST<T> sucessor = this.pegarNoSucessor(noARetirar);
                T info = sucessor.getInfo();
                this.retirar(sucessor);
                noARetirar.setInfo(info);
            }
        }
    }

    private NoArvoreBST<T> pegarNoSucessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> sucessor = null;
        // se possui subárvore à direita, procura na subárvore
        if (no.getDir() != null) {
            sucessor = (NoArvoreBST<T>) no.getDir();
            while (sucessor.getEsq() != null) {
                sucessor = (NoArvoreBST<T>) sucessor.getEsq();
            }
        } else { // senão possui, então sucessor está acima
            sucessor = descobrirPai(no);
            while (sucessor.getEsq() != no) {
                no = sucessor;
                sucessor = descobrirPai(no);
            }
        }
        return sucessor;
    }

    private NoArvoreBST<T> pegarNoAntecessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> antecessor = null;
        // se possui subárvore à esquerda, procura na subárvore
        if (no.getEsq() != null) {
            antecessor = (NoArvoreBST<T>) no.getEsq();
            while (antecessor.getDir() != null) {
                antecessor = (NoArvoreBST<T>) antecessor.getDir();
            }
        } else { // senão possui, então antecessor está acima
            antecessor = descobrirPai(no);
            while (antecessor.getDir() != no) {
                no = antecessor;
                antecessor = descobrirPai(no);
            }
        }
        return antecessor;
    }

    public T antecessor(T info) {
        if (this.vazia() || menorElemento().equals(info)) {
            return null;
        }

        NoArvoreBST<T> no = this.buscar(info);
        if (no == null) {
            return null;
        }
        return this.pegarNoAntecessor(no).getInfo();
    }

    public T sucessor(T info) {
        if (this.vazia() || maiorElemento().equals(info)) {
            return null;
        }

        NoArvoreBST<T> no = this.buscar(info);
        if (no == null) {
            return null;
        }
        return this.pegarNoSucessor(no).getInfo();
    }

    private NoArvoreBST<T> descobrirPai(NoArvoreBST<T> noARetirar) {
        if (noARetirar == this.getRaiz()) {
            return null;
        }
        NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();

        while (noPai.getDir() != noARetirar && noPai.getEsq() != noARetirar) {
            if (noARetirar.getInfo().compareTo(noPai.getInfo()) < 0) {
                noPai = (NoArvoreBST<T>) noPai.getEsq();
            } else {
                noPai = (NoArvoreBST<T>) noPai.getDir();
            }
        }

        return noPai;
    }

    public NoArvoreBST<T> buscarPai(T valor) { // uma alternativa recursiva ao descobrirPai
        if (this.vazia()) {
            return null;
        }
        return ((NoArvoreBST<T>) this.getRaiz()).buscarPai(valor, null);
    }

    public T menorElemento() {
        if (this.vazia()) {
            return null;
        } else {
            NoArvoreBinaria<T> menor = getRaiz();
            while (menor.getEsq() != null) {
                menor = menor.getEsq();
            }
            return menor.getInfo();
        }
    }

    public T maiorElemento() {
        if (this.vazia()) {
            return null;
        } else {
            NoArvoreBinaria<T> maior = getRaiz();
            while (maior.getDir() != null) {
                maior = maior.getDir();
            }
            return maior.getInfo();
        }
    }

    public String toStringOrdered() {
        if (this.vazia()) {
            return "<>";
        } else {
            return ((NoArvoreBST<T>)this.getRaiz()).imprimeEmOrdem();
        }
    }
}