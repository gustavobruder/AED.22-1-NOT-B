package prova3;

import trabalho3.Lista;

import java.math.BigInteger;

/*
 * Esta implementacao de MapaDispersao nao realiza o tratamento de colisao.
 * @author Marcel Hugo
 *
 * Alteracao feita por:
 * Gustavo Baroni Bruder
 */
public class MapaDispersao<K, T> {

    private ObjetoMapa<K, T>[] tabela;

    public MapaDispersao(int quantidade) {
        BigInteger bi = BigInteger.valueOf(quantidade * 2);
        this.tabela = new ObjetoMapa[bi.nextProbablePrime().intValue()];
    }

    private int calcularHash(K chave) {
        // calcula indice do vetor
        return (chave.hashCode() & 0x7fffffff) % tabela.length;
        // & 0x7fffffff : esta operacao binaria garante que o valor sera positivo
    }

    public boolean inserir(K chave, T valor) {
        int index = calcularHash(chave);

        if (tabela[index] == null) { // se posicao estiver vazia, guarda o par<chave,valor>
            this.inserirObj(chave, valor, index);
            return true;
        } else { // ja possui um objeto na posicao (colisao)
            for (int indexLinear = index; indexLinear < tabela.length; indexLinear++) {
                if (tabela[indexLinear] == null) {
                    this.inserirObj(chave, valor, indexLinear);
                    return true;
                } else if (tabela[indexLinear].getChave().equals(chave)) {
                    return false;
                }
            }

            return false;
        }
    }

    private void inserirObj(K chave, T valor, int index) {
        ObjetoMapa<K, T> obj = new ObjetoMapa<K, T>();
        obj.setChave(chave);
        obj.setValor(valor);
        this.tabela[index] = obj;
    }

    public T buscar(K chave) {
        int index = calcularHash(chave);
        if (tabela[index] == null) {
            return null;
        }

        for (int indexLinear = index; indexLinear < tabela.length; indexLinear++) {
            if (tabela[indexLinear] == null) {
                return null;
            } else if (tabela[indexLinear].getChave().equals(chave)) {
                return tabela[indexLinear].getValor();
            }
        }

        return null;
    }

    public T remover(K chave) {
        int index = calcularHash(chave);
        if (tabela[index] == null) {
            return null;
        }
        T temp = tabela[index].getValor();
        tabela[index] = null;
        return temp;
    }
}