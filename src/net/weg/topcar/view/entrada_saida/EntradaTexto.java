package net.weg.topcar.view.entrada_saida;

public class EntradaTexto extends Entrada<String> {

    @Override
    protected boolean validaEntrada(String valor) {
        return !valor.isEmpty();
    }

    @Override
    public String leia() {
        return sc.next();
    }
}
