package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Vendedor implements IGerente {

    public Gerente(String nome, Long cpf, String senha, Long idade, Double salario) {
        super(nome, cpf, senha, idade, salario);
    }

    public String menu() {
        return super.menu() +
                """
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
    public String editarUsuario(Cliente clienteEditado, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
        banco.alterar(clienteEditado.getCpf(), clienteEditado);
        return "Usuário editado!";
    }

    @Override
    public String registrarAutomovel(Automovel automovel, IBanco<Automovel, String> banco) {
        banco.adicionar(automovel);
        return "Automóvel registrado!";
    }

    @Override
    public String removerAutomovel(String codigo, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        banco.remover(codigo);
        return "Automóvel removido!";
    }


    /***
     * Método responsável por iniciar a ação de edição de um automóvel em nível de repositório (DAO)
     * O parâmetro de automóvel recebe as informações editadas do automóvel, já o parâmetro de banco
     * recebe qual o repositório manipula objetos do tipo Automóvel.
     * O id do automóvel permanecerá o mesmo, por esse motivo é possível pegar o memsmo id presento no
     * objeto editado.
     * @param automovel
     * @param banco
     * @throws ObjetoNaoEncontradoException
     */

    @Override
    public String editarAutomovel(Automovel automovel,
                                IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        banco.alterar(automovel.getCODIGO(), automovel);
        return "Veiculo editado!";
    }

    @Override
    public String editarPreco(String codigo, Double preco, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        Automovel automovel = banco.buscarUm(codigo);
        automovel.setPreco(preco);
        banco.alterar(codigo, automovel);
        return "Preço do veículo editado!";
    }

    @Override
    public String registrarUsuario(Cliente cliente, IBanco<Cliente, Long> banco) {
        if (!(cliente instanceof Gerente)) {
            banco.adicionar(cliente);
            return "Usuário registrado!";
        }
        throw new RuntimeException("Ação não autorizada"); //Usar a classe de excessão que tinha que ser criada
    }

    @Override
    public String removerUsuario(Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
        Cliente cliente = banco.buscarUm(cpf);
        if (!(cliente instanceof Gerente)) {
            banco.remover(cpf);
            return "Usuário removido";
        }
        throw new RuntimeException("Ação não autorizada!");
    }

//    public void editarUsuario(Cliente usuarioAntigo, Cliente usuarioNovo) {
//        usuarioAntigo.editarUsuario(usuarioNovo);
//    }

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
    public ArrayList<String> verPagamentoVendedores(IBanco<Cliente, Long> banco) {
        ArrayList<String> listaPagamentos = new ArrayList<String>();

        for (Vendedor vendedor : verVendedores(banco)) {
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

    //Não precisaria, já que ele puxa somente o método da superclasse, deixando de ser necessário a escrira delee
    @Override
    public String toString() {
        return super.toString();
    }
}
