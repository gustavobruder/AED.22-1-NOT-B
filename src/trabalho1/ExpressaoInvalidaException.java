package trabalho1;

public class ExpressaoInvalidaException extends Exception {
    public ExpressaoInvalidaException(String mensagem) {
        super("Expressão inválida: " + mensagem);
    }
}