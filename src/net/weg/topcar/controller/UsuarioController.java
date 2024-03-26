package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoUsuario;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.*;
import net.weg.topcar.model.usuarios.*;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static Cliente usuarioLogado;

    private final IBanco<Cliente, Long> bancoUsuarios = new BancoUsuario();
    private final IBanco<Automovel, String> bancoAutomoveis = new BancoAutomoveis();

    private final Entrada<Long> entradaLong = new EntradaLong();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Saida saida = new Saida();

    //Cliente
    public void verMeusAutomoveis() {
        List<Automovel> meusAutomoveis = usuarioLogado.verMeusAutomoveis();
        for (Automovel automovel: meusAutomoveis) {
            saida.escrevaL(automovel.toString());
        }
    }

    //Cliente
    public void cadastroUsuario() {
        try {
            Long cpf = entradaCpf();
            validaCPF(cpf);
            String nome = entradaNome();
            Long idade = entradaIdade();
            String senha = entradaSenha();

            if (usuarioLogado instanceof IGerente) {
                Long escolha = selecionaTipoDeUsuario();
                if (escolha == 1) {
                    Double salario = entradaSalario();
                    cadastroVendedor(nome, cpf, senha, idade, salario);
                    return;
                }
            }
            cadastroCliente(nome, cpf, senha, idade);
        } catch (UsuarioExistenteException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Vendedor
    public void verPagamento() {
        try {
            IVendedor vendedor = isVendedor();
            saida.escrevaL(vendedor.verPagamento());
        } catch (PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Vendedor
    public void vender() {
        try {
            Vendedor vendedor = isVendedor();
            saida.escrevaL("Identifique o comprador: ");
            Cliente cliente = buscarUsuario();
            saida.escreva("Identifique o automóvel: ");
            String codigo = entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
            Automovel automovel = bancoAutomoveis.buscarUm(codigo);
            vendedor.vender(automovel, cliente);
            atualizarEnvolvidosNaVenda(cliente, vendedor, automovel);
        } catch (ObjetoNaoEncontradoException | FalhaNaCompraException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Vendedor
    public void verUsuario() {
        try {
            isVendedor();
            Cliente cliente = buscarUsuario();
            saida.escreva(cliente.toString());
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException e) {
            saida.escreva(e.getMessage());
        }
    }

    //Gerente
    public void verClientes() {
        try {
            isGerente();
            List<Cliente> clientes = bancoUsuarios.buscarTodos();
            saida.escreva(clientes.toString());
        } catch (PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Gerente
    public void verPagamentoVendedor() {
        try {
            isGerente();
            Cliente cliente = buscarUsuario();
            if (cliente instanceof IVendedor vendedor) {
                saida.escrevaL(vendedor.verPagamento());
            } else {
                throw new TipoDeUsuarioInvalidoException(cliente);
            }
        } catch (ObjetoNaoEncontradoException | TipoDeUsuarioInvalidoException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Gerente
    public void verPagamentoVendedores() {
        try {
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();
            for (Vendedor vendedor : listaVendedores) {
                saida.escrevaL(vendedor.verPagamento());
            }
        }catch (PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Gerente
    public void verVendedores() {
        try {
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();
            saida.escreva(listaVendedores.toString());
        } catch (PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Gerente
    public void editarUsuario() {
        try {
            Cliente cliente = buscarUsuario();
            isGerente();
            String nome = entradaNome(cliente.getNome());
            Long idade = entradaIdade(cliente.getIdade());
            if (cliente instanceof Vendedor vendedor) {
                Double salario = entradaSalario(vendedor.getSalario());
                bancoUsuarios.alterar(cliente.getCpf(), new Vendedor(nome, vendedor.getCpf(), vendedor.getSenha(), idade, salario));
            } else {
                bancoUsuarios.alterar(cliente.getCpf(), new Cliente(nome, cliente.getCpf(), cliente.getSenha(), idade));
            }
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    //Gerente
    public void removerUsuario() throws ObjetoNaoEncontradoException {
        try {
            isGerente();
            Long cpf = entradaCpf();
            bancoUsuarios.remover(cpf);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    private Vendedor isVendedor() {
        if (usuarioLogado instanceof Vendedor vendedor) {
            return vendedor;
        } else {
            throw new PermissaoNegadaException("O usuário não é um vendedor!");
        }
    }

    private void isGerente() {
        if (usuarioLogado instanceof IGerente) {
            throw new PermissaoNegadaException("O usuário não é um gerente!");
        }
    }

    private Double entradaSalario(Double salario) {
        Double novoSalario = entradaDecimal.leiaComSaida("Salário: ", saida);
        if (novoSalario <= 1500) {
            return salario;
        }
        return novoSalario;
    }

    private Long entradaIdade(Long idade) {
        Long novaIdade = entradaLong.leiaComSaida("Idade: ", saida);
        if (novaIdade <= 0) {
            return idade;
        }
        return novaIdade;
    }

    private String entradaNome(String nome) {
        String novoNome = entradaTexto.leiaComSaida("Nome: ", saida);
        if (novoNome.isEmpty()) {
            return nome;
        }
        return novoNome;
    }

    private void atualizarEnvolvidosNaVenda(Cliente cliente, Vendedor vendedor, Automovel automovel) throws ObjetoNaoEncontradoException {
        bancoUsuarios.alterar(cliente.getCpf(), cliente);
        bancoUsuarios.alterar(vendedor.getCpf(), vendedor);
        bancoAutomoveis.alterar(automovel.getCODIGO(), automovel);
    }

    private Cliente buscarUsuario() throws ObjetoNaoEncontradoException {
        Long cpf = entradaCpf();
        return bancoUsuarios.buscarUm(cpf);
    }

    private String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
    }

    private Automovel buscarAutomovel() throws ObjetoNaoEncontradoException {
        String codigo = entradaCodigo();
        return bancoAutomoveis.buscarUm(codigo);
    }

    private List<Vendedor> buscarVendedores() {
        List<Cliente> listaClientes = bancoUsuarios.buscarTodos();
        return filtrarVendedores(listaClientes);
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

    private void validaCPF(Long cpf) throws UsuarioExistenteException {
        try {
            bancoUsuarios.buscarUm(cpf);
            if (bancoUsuarios.existe(cpf)) {
                throw new UsuarioExistenteException(cpf);
            }
        } catch (ObjetoNaoEncontradoException ignored) {
            //vazio, pois caso chegue aqui somente precisa continuar o código, sem necessitar algum tratamento
        }
    }

    private Long entradaCpf() {
        return entradaLong.leiaComSaidaEValidacao("Informe seu cpf: ", saida);
    }

    private String entradaNome() {
        return entradaTexto.leiaComSaidaEValidacao("Informe o seu nome: ", saida);
    }

    private Long entradaIdade() {
        return entradaLong.leiaComSaidaEValidacao("Informe a sua idade: ", saida);
    }

    private String entradaSenha() {
        String senha;
        String confSenha;

        do {
            senha = entradaTexto.leiaComSaidaEValidacao("Informe a sua senha: ", saida);
            confSenha = entradaTexto.leiaComSaidaEValidacao("Confirme sua senha: ", saida);
        } while (!senha.equals(confSenha));
        return senha;
    }

    private Long selecionaTipoDeUsuario() {
        return entradaLong.leiaComSaidaEValidacao("""
                        Qual o perfil do Usuário?
                        1- Vendedor
                        Outro- Cliente
                        """,
                saida);
    }

    private Double entradaSalario() {
        return entradaDecimal.leiaComSaidaEValidacao("""
                        Salário: 
                        """,
                saida);
    }

    private void cadastroCliente(String nome, Long cpf, String senha, Long idade) {
        bancoUsuarios.adicionar(new Cliente(nome, cpf, senha, idade));
    }

    private void cadastroVendedor(String nome, Long cpf, String senha, Long idade, Double salario) {
        bancoUsuarios.adicionar(new Vendedor(nome, cpf, senha, idade, salario));
    }
}
