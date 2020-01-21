package br.com.tt.comunicador.common;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
    final static public DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Util(){
        //nada nao maluco
    }

    public static void printaAewPorGentiliza(Object qualquerCoisa){
        JOptionPane.showMessageDialog(null,qualquerCoisa.toString());
        System.out.println(qualquerCoisa);
    }

    public static String entraComAInformacaoAewManolo() {
//        Scanner sc = new Scanner(System.in);
//        return sc.next();
        return JOptionPane.showInputDialog("");

    }
}
