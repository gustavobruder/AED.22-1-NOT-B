package trabalho1;

import lineares.pilhas.Pilha;
import lineares.pilhas.PilhaLista;
import lineares.pilhas.PilhaVetor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTests {

    @Test
    public void deveCalcularExpressaoComPilhaLista() throws ExpressaoInvalidaException {
        Pilha<Double> pilha = new PilhaLista<>();
        Calculadora calc = new Calculadora(pilha);

        double resultado1 = calc.calcular("1 2 - 4 5 + *");
        assertEquals(resultado1, -9);

        double resultado2 = calc.calcular("23 12 + 7 / 3 12 - 5 + *");
        assertEquals(resultado2, -20);
    }

    @Test
    public void deveCalcularExpressaoComPilhaVetor() throws ExpressaoInvalidaException {
        Pilha<Double> pilha = new PilhaVetor<>(10);
        Calculadora calc = new Calculadora(pilha);

        double resultado1 = calc.calcular("1 2 - 4 5 + *");
        assertEquals(resultado1, -9);

        double resultado2 = calc.calcular("23 12 + 7 / 3 12 - 5 + *");
        assertEquals(resultado2, -20);
    }

    @Test
    public void deveRemoverEspacosAoCalcularExpressao() throws ExpressaoInvalidaException {
        Pilha<Double> pilha = new PilhaVetor<>(10);
        Calculadora calc = new Calculadora(pilha);

        double resultado1 = calc.calcular("  1   2  - 4  5 +  *  ");
        assertEquals(resultado1, -9);

        double resultado2 = calc.calcular("  23  12 + 7  /  3 12  -  5 + * ");
        assertEquals(resultado2, -20);
    }

    @Test
    public void deveAceitarNumerosDecimaisAoCalcularExpressao() throws ExpressaoInvalidaException {
        Pilha<Double> pilha = new PilhaVetor<>(10);
        Calculadora calc = new Calculadora(pilha);

        double resultado1 = calc.calcular("1.0 2 - 4.0 5 + *");
        assertEquals(resultado1, -9);

        double resultado2 = calc.calcular("23.0 12.0 + 7 / 3.0 12 - 5 + *");
        assertEquals(resultado2, -20);
    }

    @Test
    public void deveOcorrerExceptionCasoExpressaoNulaVaziaOuEmBranco() {
        Pilha<Double> pilha = new PilhaLista<>();
        Calculadora calc = new Calculadora(pilha);

        Executable execCalc1 = () -> calc.calcular(null);
        Exception exception1 = assertThrows(ExpressaoInvalidaException.class, execCalc1);
        assertEquals(exception1.getMessage(), "Expressão inválida: Valor nulo, vazio ou em branco");

        Executable execCalc2 = () -> calc.calcular("");
        Exception exception2 = assertThrows(ExpressaoInvalidaException.class, execCalc2);
        assertEquals(exception2.getMessage(), "Expressão inválida: Valor nulo, vazio ou em branco");

        Executable execCalc3 = () -> calc.calcular(" ");
        Exception exception3 = assertThrows(ExpressaoInvalidaException.class, execCalc3);
        assertEquals(exception3.getMessage(), "Expressão inválida: Valor nulo, vazio ou em branco");
    }

    @Test
    public void deveOcorrerExceptionCasoExpressaoNaoApresentarOperadoresSuficientes() {
        Pilha<Double> pilha = new PilhaLista<>();
        Calculadora calc = new Calculadora(pilha);

        Executable execCalc = () -> calc.calcular("1 2 - 4 5 +");
        Exception exception = assertThrows(ExpressaoInvalidaException.class, execCalc);

        assertEquals(exception.getMessage(), "Expressão inválida: Faltou algum operador para usar todos os elementos da expressão!");
    }

    @Test
    public void deveOcorrerExceptionCasoExpressaoNaoApresentarOperandosSuficientes() {
        Pilha<Double> pilha = new PilhaLista<>();
        Calculadora calc = new Calculadora(pilha);

        Executable execCalc1 = () -> calc.calcular("1 - 4 5 + *");
        Exception exception1 = assertThrows(ExpressaoInvalidaException.class, execCalc1);
        assertEquals(exception1.getMessage(), "Expressão inválida: Não há operandos suficientes para realizar a operação!");

        Executable execCalc2 = () -> calc.calcular("- 4 5 + *");
        Exception exception2 = assertThrows(ExpressaoInvalidaException.class, execCalc2);
        assertEquals(exception2.getMessage(), "Expressão inválida: Não há operandos suficientes para realizar a operação!");
    }

    @Test
    public void deveOcorrerExceptionCasoExpressaoNaoApresenteApenasNumerosEOperadores() {
        Pilha<Double> pilha = new PilhaLista<>();
        Calculadora calc = new Calculadora(pilha);

        Executable execCalc = () -> calc.calcular("1 A - 4 5 + *");
        Exception exception = assertThrows(ExpressaoInvalidaException.class, execCalc);

        assertEquals(exception.getMessage(), "Expressão inválida: Apenas números (0-9) e operadores (+, -, *, /) são aceitos!");
    }
}