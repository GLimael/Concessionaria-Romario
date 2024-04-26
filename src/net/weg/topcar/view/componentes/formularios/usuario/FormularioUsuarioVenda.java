package net.weg.topcar.view.componentes.formularios.usuario;

import net.weg.topcar.controller.AutomovelController;
import net.weg.topcar.model.exceptions.FalhaNaVendaException;

public class FormularioUsuarioVenda extends FormularioUsuario {
    public void vender() {
        try {
            isVendedor();
            saida.escrevaL("Identifique o comprador.");
            Long cpf = entradaCPF();
            saida.escrevaL("Identifique o automóvel.");
            String codigo = entradaCodigo();
            usuarioController.vender(cpf, codigo);
        } catch (FalhaNaVendaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }
}
