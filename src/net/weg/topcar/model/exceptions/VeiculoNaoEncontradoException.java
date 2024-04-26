package net.weg.topcar.model.exceptions;

public class VeiculoNaoEncontradoException extends Exception {
    public VeiculoNaoEncontradoException () {
        super("Automóvel não encontrado!");
    }
}
