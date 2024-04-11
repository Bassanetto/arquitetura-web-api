package arquitetura.web.demo.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {

    public AlunoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AlunoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}