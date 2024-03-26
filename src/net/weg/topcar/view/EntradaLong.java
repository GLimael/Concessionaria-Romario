package net.weg.topcar.view;

public class EntradaLong extends Entrada<Long>{

    @Override
    public Long leia() {
        return sc.nextLong();
    }

    @Override
    protected boolean validaEntrada(Long valor) {
        return valor > 0;
    }

}
