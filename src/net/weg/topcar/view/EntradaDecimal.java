package net.weg.topcar.view;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    protected boolean validaEntrada(Double leia) {
        return false;
    }

    @Override
    public Double leia() {
        return sc.nextDouble();
    }
}
