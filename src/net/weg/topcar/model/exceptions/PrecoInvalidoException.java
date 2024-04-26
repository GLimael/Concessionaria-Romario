package net.weg.topcar.model.exceptions;

public class PrecoInvalidoException extends Exception {
    public PrecoInvalidoException () {
        super("Preço inválido para o automóvel.");
    }
}
