package net.weg.topcar.view.componentes.paginas;

import net.weg.topcar.controller.UsuarioController;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Vendedor;
import net.weg.topcar.view.UsuarioAutenticadoFront;
import net.weg.topcar.view.componentes.Componente;

public class PaginaVerMeuPagamento extends Componente {
    private UsuarioController usuarioController;
    public void verPagamento() {
        try {
            Vendedor vendedor = (Vendedor) usuarioController.buscarUsuario(UsuarioAutenticadoFront.getUsuario().getCpf());
            saida.escrevaL(vendedor.verPagamento());
        } catch (ObjetoNaoEncontradoException exception) {
            saida.escrevaL(exception.getMessage());
        } catch (ClassCastException exception) {
            saida.escrevaL("Permissão negada!\nVocê não é um vendedor");
        } catch (NullPointerException exception) {
            saida.escrevaL("Você deve logar no sistema com um usuário vendedor para exectura esta ação.");
        }
    }
}
