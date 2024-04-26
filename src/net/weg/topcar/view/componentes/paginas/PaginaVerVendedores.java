package net.weg.topcar.view.componentes.paginas;

import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.view.componentes.Componente;

public class PaginaVerVendedores extends Componente {
    public void verVendedores() {
        try {
            isGerente();
            saida.escreva(buscarVendedores().toString());
        } catch (PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
