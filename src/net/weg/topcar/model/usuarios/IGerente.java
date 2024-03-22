package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.ArrayList;

public interface IGerente extends IVendedor {
    void registrarAutomovel(
            Automovel automovel, IBanco<Automovel, String> banco);
    void removerAutomovel(
            Automovel automovel, IBanco<Automovel, String> banco);
    void editarAutomovel(
            Automovel automovelAntigo, IBanco<Automovel, String> banco);
    void editarPreco(
            Automovel automovel,
            double preco, IBanco<Automovel, String> banco);
    void registrarUsuario(
            Cliente cliente);
    String removerUsuario(
            String cpf) throws ObjetoNaoEncontradoException;
    String editarUsuario(
            Long cpf,
            Cliente novoCliente, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;
    ArrayList<Vendedor> verVendedores();
    ArrayList<Cliente> verClientes();
    ArrayList<String> verPagamentoVendedores();
    String verPagamentoVendedor(
            Vendedor vendedor);
}
