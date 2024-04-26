package net.weg.topcar.model.exceptions;

public class ObjetoNaoEncontradoException extends Exception {

    public ObjetoNaoEncontradoException () {
        super("Busca do item não encontrado!");
    }
}
