package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.IGerente;

import java.util.Collections;
import java.util.List;

public class BancoUsuario implements
        IBanco<Cliente, Long> {
    private List<Cliente> listaClientes;

    public List<Cliente> buscarTodos() {
        return Collections.unmodifiableList(
                listaClientes);
    }

    @Override
    public Cliente buscarUm(Long cpf)
            throws ObjetoNaoEncontradoException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ObjetoNaoEncontradoException(cpf.toString());
    }

    @Override
    public void adicionar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void remover(Long cpf)
            throws ObjetoNaoEncontradoException, PermissaoNegadaException {
        Cliente cliente = buscarUm(cpf);
        if (!(cliente instanceof IGerente)) {
            listaClientes.remove(cliente);
        } else {
            throw new PermissaoNegadaException("O usuário é um gerente!");
        }
    }

    @Override
    public void alterar(Long cpf,
                        Cliente novoCliente)
            throws ObjetoNaoEncontradoException {
        Cliente cliente = buscarUm(cpf);
        listaClientes.set(
                listaClientes.indexOf(cliente),
                novoCliente);
    }

    @Override
    public Boolean existe(Long cpf) {
        try {
            buscarUm(cpf);
            return true;
        } catch (ObjetoNaoEncontradoException e) {
            return false;
        }
    }

}
