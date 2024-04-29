package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutomovelService;

public class CarroController extends AutomovelController {

    public CarroController(AutomovelService automovelService) {
        super(automovelService);
    }

    public void cadastroCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                              Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                              String carroceria, String marcha)
            throws VeiculoExistenteException {

        isGerente();
        Carro novoCarro = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);
        cadastroAutomovel(novoCarro);
    }

    public void editarCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                              Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                              String carroceria, String marcha)
            throws VeiculoExistenteException {

        isGerente();
        Automovel antigoCarro = buscarAutomovel(codigo);
        Carro novoCarro = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);
        cadastroAutomovel(novoCarro);
    }

}
