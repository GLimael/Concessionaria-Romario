package net.weg.topcar.view;

public class EntradaDecimal extends Entrada<Double>{

    @Override
    public Double leia() {
        return sc.nextDouble();
    }
}
