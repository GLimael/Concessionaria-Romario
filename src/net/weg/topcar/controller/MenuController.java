package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomovel;
import net.weg.topcar.dao.BancoUsuario;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.exceptions.SenhaIncorretaException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.view.entrada_saida.Entrada;
import net.weg.topcar.view.entrada_saida.EntradaInteiro;
import net.weg.topcar.view.entrada_saida.EntradaTexto;
import net.weg.topcar.view.entrada_saida.Saida;

public class MenuController {
    private static Cliente usuarioLogado;
    private BancoUsuario bancoUsuario = new BancoUsuario();
    private BancoAutomovel bancoAutomovel = new BancoAutomovel();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    //    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Saida saida = new Saida();
    private final UsuarioController usuarioController = new UsuarioController(bancoUsuario, bancoAutomovel);
    private final AutomovelController automovelController = new AutomovelController(bancoAutomovel);

    public void menuInicial() {
        do {

            Long escolha;
            saida.escrevaL("""
                    Bem-vindo ao sistema!
                        
                    1 - Cadastrar-se;
                    2 - Logar;
                    3 - Ver automóveis;
                    4 - Ver automóvel específico;
                    0 - Sair.
                    """);
            do {
                escolha = entradaInteiro.leia();
                achaoMenuInicial(Integer.parseInt(escolha.toString()));
            } while (escolha < 0 || escolha > 4);
        } while (true);
    }

    private void achaoMenuInicial(Integer escolha) {
        switch (escolha) {
            case 0 -> {
                saida.escrevaL("Obrigado por usar o nosso sistema!");
                System.exit(0);
            }
            case 1 -> usuarioController.cadastroUsuario();
            case 2 -> login();
            case 3 -> automovelController.verAutomoveis();
            case 4 -> automovelController.verAutomovel();
            default -> saida.escreva("Opção inválida!\nDigite novamente:");
        }
    }

    private void login() {
        try {
            usuarioLogado = usuarioController.login();
            menuDoUsuario();
        } catch (ObjetoNaoEncontradoException | SenhaIncorretaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }

    private void menuDoUsuario() {
        do {
            saida.escrevaL(usuarioLogado.menu());
            saida.escrevaL("0 - Deslogar.");
            Long escolhaLong = entradaInteiro.leia();
            int escolha = Integer.parseInt(escolhaLong.toString());
            try {
                switch (escolha) {
                    case 0 -> usuarioLogado = null;
                    case 1 -> automovelController.verAutomoveis();
                    case 2 -> automovelController.verAutomovel();
                    case 3 -> usuarioController.verMeusAutomoveis();
                    case 4 -> usuarioController.vender();
                    case 5 -> usuarioController.verUsuario();
                    case 6 -> usuarioController.verPagamento();
                    case 7 -> automovelController.cadastroAutomovel();
                    case 8 -> automovelController.removerAutomovel();
                    case 9 -> automovelController.editarAutomovel();
                    case 10 -> automovelController.alterarPreco();
                    case 11 -> usuarioController.cadastroUsuario();
                    case 12 -> usuarioController.removerUsuario();
                    case 13 -> usuarioController.editarUsuario();
                    case 14 -> usuarioController.verVendedores();
                    case 15 -> usuarioController.verClientes();
                    case 16 -> usuarioController.verPagamentoVendedores();
                    case 17 -> usuarioController.verPagamentoVendedor();
                }
            } catch (PermissaoNegadaException ignore) {
                saida.escrevaL("Opção inválida!");
            }
        } while (usuarioLogado != null);
    }

}