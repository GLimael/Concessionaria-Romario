package net.weg.topcar.view.componentes.formularios.usuario;

import net.weg.topcar.controller.UsuarioController;
import net.weg.topcar.view.componentes.formularios.Formulario;
import net.weg.topcar.view.entrada_saida.*;

public class FormularioUsuario extends Formulario {
    protected final Entrada<Long> entradaInteiro = new EntradaInteiro();
    protected final Entrada<Double> entradaDecimal = new EntradaDecimal();
    protected final Entrada<String> entradaTexto = new EntradaTexto();
    protected final Saida saida = new Saida();
    protected UsuarioController usuarioController;

    protected String entradaNome(String nome) {
        String novoNome = entradaTexto.leiaComSaida("Nome: ", saida);
        if (novoNome.isEmpty()) {
            return nome;
        }

        return novoNome;
    }

    protected Long entradaIdade(Long idade) {
        Long novaIdade = entradaInteiro.leiaComSaida("Idade: ", saida);
        if (novaIdade <= 0) {
            return idade;
        }

        return novaIdade;
    }

    protected Double entradaSalario(Double salario) {
        Double novoSalario = entradaDecimal.leiaComSaida("Salário: ", saida);
        if (novoSalario <= 0.0) {
            return salario;
        }

        return novoSalario;
    }

    protected String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
    }

    protected Long entradaCPF() {
        return entradaInteiro.leiaComSaidaEValidacao("CPF: ", saida);
    }

    protected String entradaNome() {
        return entradaTexto.leiaComSaidaEValidacao("Nome: ", saida);
    }

    protected String entradaSenha() {
        String senha, confirmarSenha;
        do {
            senha = entradaTexto.leiaComSaidaEValidacao("Senha: ", saida);
            confirmarSenha = entradaTexto.leiaComSaidaEValidacao("Confirma a senha: ", saida);
        } while (!senha.equals(confirmarSenha));
        return senha;
    }

    protected Long entradaIdade() {
        return entradaInteiro.leiaComSaidaEValidacao("Idade: ", saida);
    }

    protected Double entradaSalario() {
        return entradaDecimal.leiaComSaidaEValidacao("Salário: ", saida);
    }

    protected Long selecionaTipoDeUsuario() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                    Qual o perfil de usuário que você deseja cadastrar?
                    1 - Vendedor;
                    2 - Cliente.
                    """, saida);
        } while (entrada > 2);
        return entrada;
    }
}
