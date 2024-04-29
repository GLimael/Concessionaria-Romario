package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutomovelService;

public class MotoController extends AutomovelController{

    public MotoController(AutomovelService automovelService) {
        super(automovelService);
    }

    public void cadastroMoto(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                             Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                             String partida, Long cilindrada)
            throws VeiculoExistenteException {

        isGerente();
        Moto novaMoto = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, partida, cilindrada);
        cadastroAutomovel(novaMoto);
    }

}
