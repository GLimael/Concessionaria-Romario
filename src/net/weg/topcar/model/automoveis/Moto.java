package net.weg.topcar.model.automoveis;

import net.weg.topcar.model.Automovel;

public class Moto extends Automovel {
    private String partida;
    private int cilindradas;

    public Moto(String CODIGO, String modelo, int ano, String marca, String tipoCombustivel, double preco, int quilometragem, String placa, String cor, String estado, String partida, int cilindradas) {
        super(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);
        this.partida = partida;
        this.cilindradas = cilindradas;
    }

    public String getPartida() {
        return partida;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    @Override
    public String toString() {
        return "Moto: \n" + super.toString() +
                "\nPartida: " + this.partida +
                "\nTipo da carroceria: " + cilindradas + " }\n";
    }
}
