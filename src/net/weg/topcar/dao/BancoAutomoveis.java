package net.weg.topcar.dao;

import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.Collections;
import java.util.List;

public class BancoAutomoveis
    implements IBanco<Automovel, String> {
    private List<Automovel> listaAutomoveis;

    @Override
    public List<Automovel> buscarTodos() {
        return Collections.unmodifiableList(
                listaAutomoveis);
    }

    @Override
    public Automovel buscarUm(String codigo)
            throws ObjetoNaoEncontradoException {
        for (Automovel automovel : listaAutomoveis) {
            if (automovel.getCODIGO().equals(codigo)) {
                return automovel;
            }
        }
        throw new ObjetoNaoEncontradoException(codigo);
    }

    @Override
    public void adicionar(Automovel automovel) {
        listaAutomoveis.add(automovel);
    }

    @Override
    public void remover(String codigo)
            throws ObjetoNaoEncontradoException {
        Automovel automovel = buscarUm(codigo);
        listaAutomoveis.remove(automovel);
    }

    @Override
    public void alterar(String cpf,
                        Automovel novoAutomovel)
            throws ObjetoNaoEncontradoException {
        Automovel automovel = buscarUm(cpf);
        listaAutomoveis.set(
                listaAutomoveis.indexOf(automovel),
                novoAutomovel);
    }

    @Override
    public Boolean existe(String codigo) {
        try {
            buscarUm(codigo);
            return true;
        } catch (ObjetoNaoEncontradoException e) {
            return false;
        }
    }

}
