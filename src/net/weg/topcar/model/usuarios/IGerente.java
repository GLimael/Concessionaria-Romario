package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface IGerente extends IVendedor {
    String registrarAutomovel(
            Automovel automovel, IBanco<Automovel, String> banco);

    String removerAutomovel(
            String id, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String editarAutomovel(
            Automovel automovel, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String editarPreco(
            String codigo,
            double preco, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String registrarUsuario(
            Cliente cliente, IBanco<Cliente, Long> banco);

    String removerUsuario(
            Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;

    String editarUsuario(
            Cliente novoCliente, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;

    List<Vendedor> verVendedores(IBanco<Cliente, Long> banco);

    List<Cliente> verClientes(IBanco<Cliente, Long> banco);

    ArrayList<String> verPagamentoVendedores(IBanco<Cliente, Long> banco);

    String verPagamentoVendedor(
            Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;
}
