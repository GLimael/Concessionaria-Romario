package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

public class CarroController extends AutomovelController {

    public CarroController(AutomovelService automovelService, AutenticacaoService autenticacaoService) {
        super(automovelService, autenticacaoService);
    }

    public void cadastroCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                              Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                              String marcha, String carroceria) throws VeiculoExistenteException {
        isGerente();
        Carro novoCarro = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);
        cadastroAutomovel(novoCarro);
    }

    public void editarCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                              Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                              String marcha, String carroceria) throws ObjetoNaoEncontradoException {
        isGerente();
        buscarAutomovel(codigo);
        Carro novoCarro = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);
        editarAutomovel(novoCarro);
    }
}
