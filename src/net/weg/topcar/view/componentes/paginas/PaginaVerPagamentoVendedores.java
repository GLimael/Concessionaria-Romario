package net.weg.topcar.view.componentes.paginas;

import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Vendedor;
import net.weg.topcar.view.componentes.Componente;

import java.util.List;

public class PaginaVerPagamentoVendedores extends Componente {
    public void verPagamentoVendedores() {
        try {
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();
            for (Vendedor vendedor : listaVendedores) {
                saida.escrevaL(vendedor.verPagamento());
            }
        } catch (PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
