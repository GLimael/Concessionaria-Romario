package net.weg.topcar.model.exceptions;

import net.weg.topcar.model.usuarios.Cliente;

import java.util.Locale;

public class TipoDeUsuarioInvalidoException extends Exception {

    public TipoDeUsuarioInvalidoException(Cliente cliente) {
        super("Tipo de usuário invalido!" +
                "O usuário de CPF " +
                cliente.getCpf() +
                " é um " +
                cliente.getClass().getSimpleName().toLowerCase(Locale.ROOT) +
                ".");
    }

}
