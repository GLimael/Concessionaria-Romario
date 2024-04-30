package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

public class MotoController extends AutomovelController {
    public MotoController(AutomovelService automovelService, AutenticacaoService autenticacaoService) {
        super(automovelService, autenticacaoService);
    }

    public void cadastroMoto(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                             Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                             String partida, Long cilindradas) throws VeiculoExistenteException {
        isGerente();
        Moto novaMoto = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, partida, cilindradas);
        cadastroAutomovel(novaMoto);
    }

    public void editarMoto(String codigo, String marca, String modelo, Long ano, String tipoCombustivel,
                             Double preco, String cor, Boolean novo, Double quilometragem, String placa,
                             String partida, Long cilindradas) throws ObjetoNaoEncontradoException {
        isGerente();
        buscarAutomovel(codigo);
        Moto novaMoto = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, partida, cilindradas);
        editarAutomovel(novaMoto);
    }
}
