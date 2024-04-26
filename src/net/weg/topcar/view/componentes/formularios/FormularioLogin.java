package net.weg.topcar.view.componentes.formularios;

import net.weg.topcar.controller.AutenticacaoController;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.SenhaIncorretaException;
import net.weg.topcar.view.componentes.formularios.usuario.FormularioUsuario;

public class FormularioLogin extends FormularioUsuario {
    protected AutenticacaoController autenticacaoController;

    public void login() throws ObjetoNaoEncontradoException, SenhaIncorretaException {
        try {
            Long cpf = entradaCPF();
            String senha = entradaSenha();
            usuarioAutenticado.setUsuario(autenticacaoController.login(cpf, senha));
        } catch (ObjetoNaoEncontradoException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
