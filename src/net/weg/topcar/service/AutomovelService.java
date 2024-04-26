package net.weg.topcar.service;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;

import java.util.ArrayList;
import java.util.List;

public class AutomovelService {
    private IBanco<Automovel, String> automovelBanco;

    public List<Automovel> buscarAutomoveisDisponiveis() {
        List<Automovel> automoveis = automovelBanco.buscarTodos();
        return filtrarAutomoveisDisponiveis(automoveis);

    }

    public Automovel buscarUm(String codigo) throws ObjetoNaoEncontradoException {
        return automovelBanco.buscarUm(codigo);
    }

    public void remover(String codigo) throws ObjetoNaoEncontradoException  {
        automovelBanco.remover(codigo);
    }

    public void alterarPreco(String codigo, Double preco) throws ObjetoNaoEncontradoException {
        Automovel automovel = automovelBanco.buscarUm(codigo);
        automovel.setPreco(preco);
        automovelBanco.alterar(codigo, automovel);
    }

    public void adicionar(Automovel novoAutomovel) throws VeiculoExistenteException {
        validaCodigo(novoAutomovel.getCODIGO());
        automovelBanco.adicionar(novoAutomovel);
    }

    public void alterar(String codigo, Automovel automovelEditado) throws ObjetoNaoEncontradoException {
        automovelBanco.alterar(codigo, automovelEditado);
    }

    private void validaCodigo(String codigo) throws VeiculoExistenteException {
        if (automovelBanco.existe(codigo)) {
            throw new VeiculoExistenteException(codigo);
        }
    }

    private List<Automovel> filtrarAutomoveisDisponiveis(List<Automovel> listaAutomoveis) {
        List<Automovel> listaAutomoveisDisponiveis = new ArrayList<>();
        for (Automovel automovel : listaAutomoveis) {
            if (!automovel.isComprado()) {
                listaAutomoveisDisponiveis.add(automovel);
            }
        }

        return listaAutomoveisDisponiveis;
    }
}
