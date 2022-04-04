package trabalho1;

import lineares.pilhas.Pilha;

/*
 * @autores: Gustavo Baroni Bruder e Felipe Melio Tomelin
 * */
public class Calculadora {
    private Pilha<Double> pilha;

    public Calculadora(Pilha<Double> pilha) {
        this.setPilha(pilha);
    }

    public void setPilha(Pilha<Double> pilha) {
        if (pilha == null) {
            throw new IllegalArgumentException("Pilha inválida!");
        }
        this.pilha = pilha;
    }

    public double calcular(String expressao) throws ExpressaoInvalidaException {
        String expressaoNormalizada = this.validarExpressao(expressao);
        String[] elementos = expressaoNormalizada.split(" ");

        for (String elemento : elementos) {
            if (this.ehNumero(elemento)) {
                this.pilha.push(Double.parseDouble(elemento));
            } else if (this.ehOperador(elemento)) {
                double ultimo, penultimo;

                try {
                    ultimo = this.pilha.pop();
                    penultimo = this.pilha.pop();
                } catch (RuntimeException ex) {
                    throw new ExpressaoInvalidaException("Não há operandos suficientes para realizar a operação!");
                }

                double resultado = this.realizarOperacao(penultimo, ultimo, elemento);
                this.pilha.push(resultado);
            } else {
                throw new ExpressaoInvalidaException(
                        "Apenas números (0-9) e operadores (+, -, *, /) são aceitos!\n" +
                        "Para números decimais use o ponto (.)"
                );
            }
        }

        Double resultadoFinal = this.pilha.pop();

        if (!this.pilha.estaVazia()) {
            throw new ExpressaoInvalidaException("Faltou algum operador para usar todos os elementos da expressão!");
        }

        return resultadoFinal;
    }

    private String validarExpressao(String expressao) throws ExpressaoInvalidaException {
        if (expressao == null || expressao.isEmpty() || expressao.isBlank()) {
            throw new ExpressaoInvalidaException("Valor nulo, vazio ou em branco");
        }

        return expressao.trim().replaceAll("\\s+"," ");
    }

    private double realizarOperacao(double x, double y, String operacao) {
        OperacaoMatematica operacaoMatematica;

        switch (operacao) {
            case Adicao.OPERADOR:
                operacaoMatematica = new Adicao();
                break;
            case Subtracao.OPERADOR:
                operacaoMatematica = new Subtracao();
                break;
            case Multiplicacao.OPERADOR:
                operacaoMatematica = new Multiplicacao();
                break;
            case Divisao.OPERADOR:
                operacaoMatematica = new Divisao();
                break;
            default:
                return 0.0;
        }

        return operacaoMatematica.calcular(x, y);
    }

    private boolean ehNumero(String elemento) {
        return elemento.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean ehOperador(String caractere) {
        return caractere.equals(Adicao.OPERADOR) ||
                caractere.equals(Subtracao.OPERADOR) ||
                caractere.equals(Multiplicacao.OPERADOR) ||
                caractere.equals(Divisao.OPERADOR);
    }
}