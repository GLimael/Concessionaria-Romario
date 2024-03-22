package net.weg.topcar.view;

import java.util.Scanner;

public class EntradaLong extends Entrada<Long>{

    @Override
    public Long leia() {
        return sc.nextLong();
    }

}
