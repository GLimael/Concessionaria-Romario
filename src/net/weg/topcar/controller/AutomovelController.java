package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.model.usuarios.UsuarioAutenticadoBack;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

import java.util.List;

public class AutomovelController {
    private final AutomovelService automovelService;
    private final AutenticacaoService autenticacaoService;

    public AutomovelController(AutomovelService automovelService, AutenticacaoService autenticacaoService) {
        this.automovelService = automovelService;
        this.autenticacaoService = autenticacaoService;
    }

    public List<Automovel> buscarAutomoveisDisponiveis() {
        return automovelService.buscarAutomoveisDisponiveis();
    }

    public Automovel buscarAutomovel(String codigo) throws ObjetoNaoEncontradoException {
        return automovelService.buscarUm(codigo);
    }

    protected void cadastroAutomovel(Automovel automovel) throws VeiculoExistenteException {
        automovelService.adicionar(automovel);
    }

    public void editarAutomovel(Automovel automovel) throws ObjetoNaoEncontradoException {
        automovelService.alterar(automovel.getCODIGO(), automovel);
    }

    public void removerAutomovel(String codigo) throws PermissaoNegadaException, ObjetoNaoEncontradoException {
        isGerente();
        automovelService.remover(codigo);
    }

    public void alterarPreco(String codigo, Double preco) throws PermissaoNegadaException, ObjetoNaoEncontradoException {
        isGerente();
        automovelService.alterarPreco(codigo, preco);
    }

    protected void isGerente() throws PermissaoNegadaException {
        if (!(UsuarioAutenticadoBack.getUsuario() instanceof IGerente)) {
            throw new PermissaoNegadaException("o usuário não é um gerente");
        }
    }
}
