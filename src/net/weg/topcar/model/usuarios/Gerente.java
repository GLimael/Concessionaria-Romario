package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Vendedor implements IGerente {

    public Gerente(String nome, Long cpf, String senha, Long idade, Double salario) {
        super(nome, cpf, senha, idade, salario);
        setComissao(0.02);
    }

    public String menu() {
        return super.menu() + """
                7 - Registrar automóvel;
                8 - Remover automóvel;
                9 - Editar automóvel;
                10 - Editar preço;
                11 - Registrar usuário;
                12 - Remover usuário;
                13 - Editar usuário;
                14 - Ver vendedores;
                15 - Ver clientes;
                16 - Ver pagamentos dos vendedores;
                17 - Ver pagamento de um vendedor;
                 """;
    }

    @Override
    public String registrarAutomovel(Automovel automovel, IBanco<Automovel, String> banco) {
        banco.adicionar(automovel);
        return "Automóvel registrado!";
    }

    @Override
    public String removerAutomovel(String codigo, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException, PermissaoNegadaException {
        banco.remover(codigo);
        return "Automóvel removido!";
    }

    /**
     * Método responsável por iniciar a ação de edição de um automóvel em nível de repositório (DAO).
     * O parâmetro de automóvel recebe as informações editadas do automóvel, já o parametro de banco
     * recebe qual o repositório que manipula objetos do tipo Automovel.
     * O id do automóvel permanecerá o mesmo, por esse motivo é possível pegar o mesmo id presente no
     * objeto editado.
     * @param automovel
     * @param banco
     * @throws ObjetoNaoEncontradoException
     */
    @Override
    public String editarAutomovel(Automovel automovel, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        banco.alterar(automovel.getCODIGO(), automovel);
        return "Automóvel editado!";
    }

    @Override
    public String editarPreco(String codigo, double preco, IBanco<Automovel, String> banco) throws PrecoInvalidoException, ObjetoNaoEncontradoException {
        Automovel automovel = banco.buscarUm(codigo);
        automovel.setPreco(preco);
        banco.alterar(codigo, automovel);
        return "Preço do automóvel registrado!";
    }

    @Override
    public String registrarUsuario(Cliente cliente, IBanco<Cliente, Long> banco) throws AcessoNegadoException {
        if (!(cliente instanceof Gerente)) {
            banco.adicionar(cliente);
            return "Usuário registrado!";
        }
        throw new AcessoNegadoException();
    }

    @Override
    public String removerUsuario(Long cpf, IBanco<Cliente, Long> banco) throws UsuarioNaoEncontradoException, PermissaoNegadaException, ObjetoNaoEncontradoException {
        Cliente cliente = banco.buscarUm(cpf);
        if (!(cliente instanceof Gerente)) {
            banco.remover(cpf);
            return "Usuário removido";
        }
        throw new PermissaoNegadaException("");
    }

    @Override
    public String editarUsuario(Cliente clienteEditado, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
        banco.alterar(clienteEditado.getCpf(), clienteEditado);
        return "Usuário editado";
    }

    @Override
    public List<Vendedor> verVendedores(IBanco<Cliente, Long> banco) {
//        List<Cliente> listaVendedores = banco.buscarTodos();
//        listaVendedores.removeIf(cliente -> !(cliente instanceof Vendedor));

        List<Cliente> listaClientes = banco.buscarTodos();
        List<Vendedor> listaVendedores = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente instanceof Vendedor vendedor) {
                listaVendedores.add(vendedor);
            }
        }

        return listaVendedores;
    }

    @Override
    public List<Cliente> verClientes(IBanco<Cliente, Long> banco) {
        return banco.buscarTodos();
    }

    @Override
    public List<String> verPagamentoVendedores(List<Vendedor> listaVendedores) {
        List<String> listaPagamentos = new ArrayList<String>();
        for (Vendedor vendedor : listaVendedores) {
            listaPagamentos.add(vendedor.verPagamentoComNome());
        }

        return listaPagamentos;
    }

    @Override
    public String verPagamentoVendedor(Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
        Cliente cliente = banco.buscarUm(cpf);
        if (cliente instanceof Vendedor vendedor) {
            return vendedor.verPagamentoComNome();
        }
        throw new RuntimeException("O usuário informado não é um vendedor!");
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
