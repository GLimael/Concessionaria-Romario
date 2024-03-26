package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoUsuario;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.Gerente;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class AutomovelController {

    private static Cliente usuarioLogado;

    private final IBanco<Cliente, Long> bancoUsuarios = new BancoUsuario();
    private final IBanco<Automovel, String> bancoAutomoveis = new BancoAutomoveis();

    private final Entrada<Long> entradaLong = new EntradaLong();
    private final Entrada<String> entradaTexto = new EntradaTexto();
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Saida saida = new Saida();

    public void verAutomoveis() {
        List<Automovel> listaAutomovel = bancoAutomoveis.buscarTodos();
        List<Automovel> listaAutomoveisDisponiveis = filtrarAutomoveisDisponiveis(listaAutomovel);
        for (Automovel automovel : listaAutomoveisDisponiveis) {
            saida.escrevaL(automovel.toString());
        }
    }

    public void verAutomovel() {
        try {
            String codigo = entradaCodigo();
            Automovel automovel = bancoAutomoveis.buscarUm(codigo);
            saida.escrevaL(automovel.toString());
        } catch (ObjetoNaoEncontradoException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    public void removerAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            bancoAutomoveis.remover(codigo);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    public void alterarPreco() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Automovel automovel = bancoAutomoveis.buscarUm(codigo);
            Double preco = entradaPreco(automovel.getPreco());
            automovel.setPreco(preco);
            bancoAutomoveis.alterar(codigo, automovel);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException e) {
            saida.escrevaL(e.getMessage());
        }
    }

    public void cadastroAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            validaCodigo(codigo);
            String marca = entradaMarca();
            String modelo = entradaModelo();
            Long ano = entradaAno;
            String tipoCombustivel = entradaCombustivel();
            Double preco = entradaPreco();
            Double quilometragem = entradaQuilometragem();
            String placa = entradaPlaca();
            String cor = entradaCor();
            Boolean novo = entradaNovo();
        } catch (PermissaoNegadaException e) {

        }
    }

    private void validaCodigo(String codigo) {
        List<Automovel> listaAutomoveis = bancoAutomoveis.buscarTodos();
        for (Automovel automovel: listaAutomoveis) {
            if(!(codigo.equals(automovel.getCODIGO()))) {
                
            }
        }
    }

    private Double entradaPreco(Double precoAntigo) {
        Double novoPreco = entradaDecimal.leiaComSaida("Novo preço do automóvel: ", saida);
        if (novoPreco <= 0) {
            return precoAntigo;
        }
        return novoPreco;
    }

    private void isGerente() {
        if (usuarioLogado instanceof IGerente) {
            throw new PermissaoNegadaException("O usuário não é um gerente!");
        }
    }

    private String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Código do veículo: ", saida);
    }

    private List<Automovel> filtrarAutomoveisDisponiveis(List<Automovel> listaAutomoveis) {
        List<Automovel> listaAutomoveisDisponiveis = new ArrayList<>();
        for (Automovel automovel : listaAutomoveis) {
            if (!automovel.isComprado()) {
                listaAutomoveisDisponiveis.add(automovel);
            }
        }
        return listaAutomoveisDisponiveis;
    }

}
