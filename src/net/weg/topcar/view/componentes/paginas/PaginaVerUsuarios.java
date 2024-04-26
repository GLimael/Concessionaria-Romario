package net.weg.topcar.view.componentes.paginas;

import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.view.componentes.Componente;

import java.util.List;

public class PaginaVerUsuarios extends Componente {
    public void verClientes() {
        try {
            isGerente();
            List<Cliente> clientes = bancoUsuarios.buscarTodos();
            saida.escreva(clientes.toString());
        } catch (PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
