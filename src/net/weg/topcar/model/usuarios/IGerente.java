package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.*;

import java.util.List;

public interface IGerente extends IVendedor {
    String registrarAutomovel(Automovel automovel, IBanco<Automovel, String> banco);

    String removerAutomovel(String codigo, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException, PermissaoNegadaException;

    String editarAutomovel(Automovel automovel, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException;

    String editarPreco(String codigo, double preco, IBanco<Automovel, String> banco) throws PrecoInvalidoException, ObjetoNaoEncontradoException;

    String registrarUsuario(Cliente cliente, IBanco<Cliente, Long> banco) throws AcessoNegadoException;

    String removerUsuario(Long cpf, IBanco<Cliente, Long> banco) throws UsuarioNaoEncontradoException, PermissaoNegadaException, ObjetoNaoEncontradoException;

    String editarUsuario(Cliente usuarioNovo, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;

    List<Vendedor> verVendedores(IBanco<Cliente, Long> banco);

    List<Cliente> verClientes(IBanco<Cliente, Long> banco);

    List<String> verPagamentoVendedores(List<Vendedor> listaVendedores);

    String verPagamentoVendedor(Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;
}
