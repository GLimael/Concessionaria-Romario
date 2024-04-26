package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.service.AutomovelService;
import net.weg.topcar.view.*;

import java.util.List;

public class AutomovelController {
    private static Cliente usuarioLogado;
    private final AutomovelService automovelService;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    public void verAutomoveis() {
        List<Automovel> listaAutomoveisDisponiveis = automovelService.buscarAutomoveisDisponiveis();
        for (Automovel automovel : listaAutomoveisDisponiveis) {
            saida.escrevaL(automovel.toString());
        }
    }

    public void verAutomovel() {
        try {
            String codigo = entradaCodigo();
            Automovel automovel = automovelService.buscarUm(codigo);
            saida.escrevaL(automovel.toString());
        } catch (ObjetoNaoEncontradoException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }

    public void editarAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Automovel automovel = automovelService.buscarUm(codigo);
            String marca = entradaMarca(automovel.getMarca());
            String modelo = entradaModelo(automovel.getModelo());
            Long ano = entradaAno(automovel.getAno());
            String tipoCombustivel = entradaCombustivel(automovel.getTipoCombustivel());
            Double preco = entradaPreco(automovel.getPreco());
            String cor = entradaCor(automovel.getCor());
            Boolean novo = entradaNovo();
            Double quilometragem = 0.0;
            String placa = "";
            if (!novo) {
                quilometragem = entradaQuilometragem();
                placa = entradaPlaca();
            }
            Automovel automovelEditado;
            if (automovel instanceof Carro carro) {
                String carroceria = entradaCarroceria(carro.getTipoCarroceria());
                String marcha = entradaMarcha(carro.getMarcha());
                automovelEditado =  new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo, marcha, carroceria);
            } else if (automovel instanceof Moto moto) {
                Long cilindradas = entradaCilindradas(moto.getCilindradas());
                String partida = entradaPartida(moto.getPartida());
                automovelEditado = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo, partida, cilindradas);
            } else {
                automovelEditado = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo);
            }
            automovelService.alterar(codigo, automovelEditado);
        } catch (PermissaoNegadaException | ObjetoNaoEncontradoException exception) {
            saida.escrevaL(exception.getMessage());
        }

    }

    public void cadastroAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            String marca = entradaMarca();
            String modelo = entradaModelo();
            Long ano = entradaAno();
            String tipoCombustivel = entradaCombustivel();
            Double preco = entradaPreco();
            String cor = entradaCor();
            Boolean novo = entradaNovo();
            Double quilometragem = 0.0;
            String placa = "";
            if (!novo) {
                quilometragem = entradaQuilometragem();
                placa = entradaPlaca();
            }
            Long tipo = selecionaTipoDeAutomovel();
            Automovel novoAutomovel;
            if (tipo == 1) {
                String carroceria = entradaCarroceria();
                String marcha = entradaMarcha();
                novoAutomovel = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo, marcha, carroceria);
            } else if (tipo == 2) {
                Long cilindradas = entradaCilindradas();
                String partida = entradaPartida();
                novoAutomovel = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo, partida, cilindradas);
            } else {
                novoAutomovel = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel,
                        preco, quilometragem, placa, cor, novo);
            }
            automovelService.adicionar(novoAutomovel);
        } catch (PermissaoNegadaException | VeiculoExistenteException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }

    public void removerAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            automovelService.remover(codigo);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }

    public void alterarPreco() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Double preco = entradaPreco();
            automovelService.alterarPreco(codigo, preco);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadaException exception) {
            saida.escrevaL(exception.getMessage());
        }
    }

    private void isGerente() throws PermissaoNegadaException {
        if (!(usuarioLogado instanceof IGerente)) {
            throw new PermissaoNegadaException("o usuário não é um gerente");
        }
    }


    public Automovel buscarAutomovel(String codigo) throws ObjetoNaoEncontradoException {
    }
}
