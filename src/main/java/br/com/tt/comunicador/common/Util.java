package br.com.tt.comunicador.common;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
    final static public DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final static public int TAMANHO_MENSAGEM_MINIMO = 5;

    public Util(){
        //nada nao maluco
    }

    public void printaAewPorGentiliza(Object qualquerCoisa){
        JOptionPane.showMessageDialog(null,qualquerCoisa.toString());
        System.out.println(qualquerCoisa);
    }

    public String entraComAInformacaoAewManolo() {
//        Scanner sc = new Scanner(System.in);
//        return sc.next();
        String ret = JOptionPane.showInputDialog("");
        if(ret == null){
            ret = "";
        }
        return ret;

    }
}
