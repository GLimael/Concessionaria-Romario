package net.weg.topcar.controller;

import net.weg.topcar.view.*;

public class UsuarioController {
    private final Entrada<Long> entradaLong = new EntradaLong();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();

    private final Saida saida = new Saida();

    public void cadastroUsuario() {
        String nome = entradaTexto.leia("Informe o seu nome: ", saida);
        Long cpf = entradaLong.leia("Informe seu cpf: ", saida);
        String senha = entradaTexto.leia("Informe a sua senha: ", saida);
        String confSenha = entradaTexto.leia("Confirme sua senha: ", saida);
        Long idade = entradaLong.leia("Informe a sua idade: ", saida);

    }
}
