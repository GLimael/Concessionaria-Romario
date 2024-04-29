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
    private final AutomovelService automovelService;

    protected void cadastroAutomovel(Automovel automovel) throws VeiculoExistenteException {
        automovelService.adicionar(automovel);
    }

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    public List<Automovel> buscarAutomoveis() {
        return automovelService.buscarAutomoveisDisponiveis();
    }

    public Automovel buscarAutomovel(String codigo) throws ObjetoNaoEncontradoException {
        return automovelService.buscarUm(codigo);
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



    public void removerAutomovel(String codigo) throws ObjetoNaoEncontradoException, PermissaoNegadaException {
        isGerente();
        automovelService.remover(codigo);
    }

    public void alterarPreco(String codigo, Double preco) throws PermissaoNegadaException, ObjetoNaoEncontradoException {
        isGerente();
        automovelService.alterarPreco(codigo, preco);
    }

    protected void isGerente() throws PermissaoNegadaException {
        if (!(usuarioLogado instanceof IGerente)) {
            throw new PermissaoNegadaException("o usuário não é um gerente");
        }
    }
}
