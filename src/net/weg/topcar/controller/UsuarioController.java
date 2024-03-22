package net.weg.topcar.controller;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.Gerente;
import net.weg.topcar.model.usuarios.Vendedor;
import net.weg.topcar.view.*;

public class UsuarioController {
    private static Cliente usuarioLogado;

    private IBanco<Cliente, Long> bancoUsuarios;
    private IBanco<Automovel, String> bancoAutomoveis;

    private final Entrada<Long> entradaLong = new EntradaLong();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();

    private final Saida saida = new Saida();

    public void cadastroUsuario() {
        String nome = entradaTexto.leiaComSaidaEValidacao("Informe o seu nome: ", saida);
        Long cpf = entradaLong.leiaComSaidaEValidacao("Informe seu cpf: ", saida);
        String senha = entradaTexto.leiaComSaidaEValidacao("Informe a sua senha: ", saida);
        String confSenha = entradaTexto.leiaComSaidaEValidacao("Confirme sua senha: ", saida);
        Long idade = entradaLong.leiaComSaidaEValidacao("Informe a sua idade: ", saida);
        if(!(usuarioLogado instanceof Gerente)) {
            Cliente cliente = new Cliente(nome, cpf, senha, idade);
        }else {
            Long escolha = entradaLong.leiaComSaidaEValidacao(
                    """
                            Qual o perfil de usuário que deseja cadastrar:
                            1- Vendedor
                            Outro - Cliente
                            """,
                    saida);
            if(escolha == 1) {
                Double salario = entradaDecimal.leiaComSaidaEValidacao(
                        "Salário: ", saida);
                Cliente vendedor = new Vendedor(nome, cpf, senha, idade, salario);
            }
        }
    }
}
