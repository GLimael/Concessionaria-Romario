package net.weg.topcar.model.exceptions;

public class VeiculoExistenteException extends Exception {
    public VeiculoExistenteException(String codigo) {
        super("Já existe um automóvel com o código " + codigo + "!");
    }
}
