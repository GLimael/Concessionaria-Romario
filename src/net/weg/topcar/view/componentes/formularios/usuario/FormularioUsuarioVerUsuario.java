package net.weg.topcar.view.componentes.formularios.usuario;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Cliente;

public class FormularioUsuarioVerUsuario extends FormularioUsuario {
    public void verUsuario() {
        try {
            isVendedor();
            Cliente cliente = buscarUsuario();
            saida.escrevaL(cliente.toString());
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
