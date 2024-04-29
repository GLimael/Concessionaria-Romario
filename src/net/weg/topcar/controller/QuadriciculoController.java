package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutomovelService;

public class QuadriciculoController extends AutomovelController{

    public QuadriciculoController(AutomovelService automovelService) {
        super(automovelService);
    }

    public void cadastroQuadriciculo(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                                     Double preco, String cor, Boolean novo, Double quilometragem, String placa)
            throws VeiculoExistenteException {

        isGerente();
        Quadriciclo novoQuadriciculo = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo);
        cadastroAutomovel(novoQuadriciculo);
    }

}
