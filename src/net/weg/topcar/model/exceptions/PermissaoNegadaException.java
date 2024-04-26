package net.weg.topcar.model.exceptions;

public class PermissaoNegadaException extends RuntimeException {
    public PermissaoNegadaException(String mensagem) {
        super("Permissão negada: " + mensagem);
    }
}
