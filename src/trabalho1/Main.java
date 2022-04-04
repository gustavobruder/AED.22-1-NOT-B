package trabalho1;

import lineares.pilhas.Pilha;
import lineares.pilhas.PilhaLista;
import lineares.pilhas.PilhaVetor;

import java.util.Scanner;

/*
 * @autores: Gustavo Baroni Bruder e Felipe Melio Tomelin
 * */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("Calculadora de Expressão Aritmética");
        System.out.println("===================================");

        String tipoPilha = "";
        while (!tipoPilha.equals("1") && !tipoPilha.equals("2")) {
            System.out.println("-> Escolha o tipo de pilha");
            System.out.println("1 - Vetor");
            System.out.println("2 - Lista");
            System.out.print("Tipo: ");
            tipoPilha = scanner.nextLine();
        }

        System.out.print("-> Informe a expressão: ");
        String expressao = scanner.nextLine();

        Pilha<Double> pilha;

        if (tipoPilha.equals("1")) {
            pilha = new PilhaVetor<>(100);
        } else {
            pilha = new PilhaLista<>();
        }

        Calculadora calc = new Calculadora(pilha);
        try {
            double resultado = calc.calcular(expressao);
            System.out.println("-> Resultado: " + resultado);
        } catch (ExpressaoInvalidaException e) {
            System.out.println("-> [Erro] " + e.getMessage());
        }
    }
} 