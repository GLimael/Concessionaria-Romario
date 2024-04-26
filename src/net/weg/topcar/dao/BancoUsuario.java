package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BancoUsuario implements IBanco<Cliente, Long> {
    private List<Cliente> listaUsuarios;

    public BancoUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }
    @Override
    public  List<Cliente> buscarTodos() {
        return Collections.unmodifiableList(listaUsuarios);
    }

    @Override
    public Cliente adicionar(Cliente cliente) {
        listaUsuarios.add(cliente);
        return cliente;
    }

    @Override
    public void remover(Long cpf) throws ObjetoNaoEncontradoException {
        Cliente cliente = buscarUm(cpf);
        if (!(cliente instanceof IGerente)) {
            listaUsuarios.remove(cliente);
        } else {
            throw new PermissaoNegadaException("Usuário gerente");
        }
    }

    @Override
    public void alterar(Long cpf, Cliente novoUsuario) throws ObjetoNaoEncontradoException{
        Cliente usuario = buscarUm(cpf);
        listaUsuarios.set(listaUsuarios.indexOf(usuario), novoUsuario);
    }

    @Override
    public Cliente buscarUm(Long cpf) throws ObjetoNaoEncontradoException {
        for (Cliente usuario : listaUsuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        throw new ObjetoNaoEncontradoException();
    }

    @Override
    public Boolean existe(Long cpf) {
        try {
            buscarUm(cpf);
            return true;
        } catch (ObjetoNaoEncontradoException exception) {
            return false;
        }
    }
}
