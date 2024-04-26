package net.weg.topcar.model.exceptions;

public class FalhaNaVendaException extends Exception {
    public FalhaNaVendaException(String texto) {
        super("Falha na compra: " + texto);
    }
}
