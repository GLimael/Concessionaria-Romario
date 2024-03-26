package net.weg.topcar.view;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    public Double leia() {
        return sc.nextDouble();
    }

    @Override
    protected boolean validaEntrada(Double valor) {
        return valor > 0.0;
    }
}
