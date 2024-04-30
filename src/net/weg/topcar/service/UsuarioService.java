package net.weg.topcar.service;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.FalhaNaVendaException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.Gerente;
import net.weg.topcar.model.usuarios.UsuarioAutenticadoBack;
import net.weg.topcar.model.usuarios.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private IBanco<Cliente, Long> usuarioBanco;
    public Cliente adicionar(Cliente cliente) {
        return usuarioBanco.adicionar(cliente);
    }
    private AutomovelService automovelService;

    public UsuarioService(IBanco<Cliente, Long> usuarioBanco, AutomovelService automovelService) {
        this.usuarioBanco = usuarioBanco;
        this.automovelService = automovelService;
    }

    public boolean existe(Long cpf) {
        return usuarioBanco.existe(cpf);
    }

    public void alterar(Long cpf, Cliente clienteEditado) throws ObjetoNaoEncontradoException {
        usuarioBanco.alterar(cpf, clienteEditado);
    }

    public Cliente buscarUm(Long cpf) throws ObjetoNaoEncontradoException {
        return usuarioBanco.buscarUm(cpf);
    }

    public List<Automovel> meusAutomoveis() {
        return UsuarioAutenticadoBack.getUsuario().verMeusAutomoveis();
    }

    public void vender(Long cpfCliente, String codigo) throws ObjetoNaoEncontradoException, FalhaNaVendaException {
        Vendedor vendedor = (Vendedor) UsuarioAutenticadoBack.getUsuario();
        Cliente cliente = buscarUm(cpfCliente);
        Automovel automovel = automovelService.buscarUm(codigo);
        vendedor.vender(automovel, cliente);
        usuarioBanco.alterar(cliente.getCpf(), cliente);
        usuarioBanco.alterar(vendedor.getCpf(), vendedor);
        automovelService.alterar(automovel.getCODIGO(), automovel);
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

    public List<Vendedor> buscarVendedores() {
        List<Cliente> listaClientes = usuarioBanco.buscarTodos();
        return filtrarVendedores(listaClientes);
    }

    public void remover(Long cpf) throws ObjetoNaoEncontradoException {
        usuarioBanco.remover(cpf);
    }

    public String buscarPagamento(Long cpf) throws ObjetoNaoEncontradoException {
        Vendedor vendedor = (Vendedor) buscarUm(cpf);
        return vendedor.verPagamento();
    }

    public List<Cliente> buscarUsuarios() {
        return usuarioBanco.buscarTodos();
    }

    public List<String> buscarPagamentoVendedores() {
        List<Vendedor> listaVendedores = buscarVendedores();
        Gerente gerente = (Gerente) UsuarioAutenticadoBack.getUsuario();
        return gerente.verPagamentoVendedores(listaVendedores);
    }
}
