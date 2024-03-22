package net.weg.topcar.view;

public class EntradaLong extends Entrada<Long>{

    @Override
    protected boolean validaEntrada(Long leia) {
        return false;
    }

    @Override
    public Long leia() {
        return sc.nextLong();
    }

}
