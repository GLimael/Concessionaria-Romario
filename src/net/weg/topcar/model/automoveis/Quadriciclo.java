package net.weg.topcar.model.automoveis;

public class Quadriciclo extends Automovel {
    public Quadriciclo(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, Double preco, Double quilometragem, String placa, String cor, Boolean novo) {
        super(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
