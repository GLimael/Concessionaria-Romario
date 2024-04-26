package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;

import java.util.List;

public interface IBanco<T, ID> {
    List<T> buscarTodos();

    T adicionar(T usuario);

     void remover(ID id) throws ObjetoNaoEncontradoException, PermissaoNegadaException;

     void alterar(ID id, T novoUsuario) throws ObjetoNaoEncontradoException;

     T buscarUm(ID id) throws ObjetoNaoEncontradoException;

     Boolean existe(ID id);
}
