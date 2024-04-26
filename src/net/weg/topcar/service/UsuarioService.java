package net.weg.topcar.service;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.UsuarioAutenticadoBack;
import net.weg.topcar.model.usuarios.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private IBanco<Cliente, Long> usuarioBanco;
    public Cliente adicionar(Cliente cliente) {
        return usuarioBanco.adicionar(cliente);
    }

    public boolean existe(Long cpf) {
        return usuarioBanco.existe(cpf);
    }

    public void alterar(Cliente clienteEditado) throws ObjetoNaoEncontradoException {
        usuarioBanco.alterar(clienteEditado.getCpf(), clienteEditado);
    }

    public Cliente buscarUm(Long cpf) throws ObjetoNaoEncontradoException {
        return usuarioBanco.buscarUm(cpf);
    }

    public List<Automovel> meusAutomoveis() {
        return UsuarioAutenticadoBack.getUsuario().verMeusAutomoveis();
    }

    private void atualizarEnvolvidosNaVenda(Cliente cliente, Vendedor vendedor, Automovel automovel) throws ObjetoNaoEncontradoException {
        bancoUsuarios.alterar(cliente.getCpf(), cliente);
        bancoUsuarios.alterar(vendedor.getCpf(), vendedor);
        bancoAutomoveis.alterar(automovel.getCODIGO(), automovel);
    }

    private Automovel buscarAutomovel() throws ObjetoNaoEncontradoException {
        String codigo = entradaCodigo();
        return bancoAutomoveis.buscarUm(codigo);
    }

    private List<Vendedor> filtrarVendedores(List<Cliente> listaClientes) {
        List<Vendedor> listaVendedores = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente instanceof Vendedor vendedor) {
                listaVendedores.add(vendedor);
            }
        }

        return listaVendedores;
    }

    private void cadastroVendedor(String nome, Long cpf, String senha, Long idade, Double salario) {
        bancoUsuarios.adicionar(new Vendedor(nome, cpf, senha, idade, salario));
    }

    private void cadastroCliente(String nome, Long cpf, String senha, Long idade) {
        bancoUsuarios.adicionar(new Cliente(nome, cpf, senha, idade));
    }

    private List<Vendedor> buscarVendedores() {
        List<Cliente> listaClientes = bancoUsuarios.buscarTodos();
        return filtrarVendedores(listaClientes);
    }
}
