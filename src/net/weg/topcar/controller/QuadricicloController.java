package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

public class QuadricicloController extends AutomovelController {

    public QuadricicloController(AutomovelService automovelService, AutenticacaoService autenticacaoService) {
        super(automovelService, autenticacaoService);
    }

    public void cadastroQuadriciclo(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, Boolean novo, Double quilometragem, String placa) throws VeiculoExistenteException {
        isGerente();
        Quadriciclo novoQuadriciclo = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
        cadastroAutomovel(novoQuadriciclo);
    }

    public void editarQuadriciclo(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, Boolean novo, Double quilometragem, String placa) throws ObjetoNaoEncontradoException {
        isGerente();
        buscarAutomovel(codigo);
        Quadriciclo novoQuadriciclo = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
        editarAutomovel(novoQuadriciclo);
    }



}