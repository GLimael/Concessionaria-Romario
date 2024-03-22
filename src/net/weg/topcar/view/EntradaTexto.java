package net.weg.topcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaTexto extends Entrada<String>{

    public String leia() throws InputMismatchException {
        return sc.next();
    }
}
