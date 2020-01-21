package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

class Main extends Object {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Mensagem> mensagens = new ArrayList<>();
    public static Usuario usuarioLogado;

    static public void main(String[] args) {
        inicializarDados();

        entrar();
        listaMalucos();
        novaMensagem();
        listarMensagens();

    }

    public static void listaMalucos(){
        Integer i = 0;
        for(Usuario umUser:usuarios){
            Util.printaAewPorGentiliza(i);
            Util.printaAewPorGentiliza(umUser.getUsername());
            i++;
        }

    }

    public static boolean entrar(){
        Util.printaAewPorGentiliza("Informe seu username");
        String usernameDigitado = Util.entraComAInformacaoAewManolo();

        if(usernameDigitado.equals("n")){
            Util.printaAewPorGentiliza("What's ur name?");
            String nome = Util.entraComAInformacaoAewManolo();
            Util.printaAewPorGentiliza("What's ur USERname?");
            String userName = Util.entraComAInformacaoAewManolo();
            Util.printaAewPorGentiliza("When u was born? (dd/mm/yyyy)");
            String dataNascimento = Util.entraComAInformacaoAewManolo();

            Usuario novoUsuario = new Usuario(nome, userName, dataNascimento);
            usuarios.add(novoUsuario);
            usuarioLogado = novoUsuario;
            return true;
        }

        for(Usuario umUser : usuarios){
            if(umUser.getUsername().equals(usernameDigitado)){
                Util.printaAewPorGentiliza("LOGADO!");
                usuarioLogado = umUser;
                return true;
            }
        }
        Util.printaAewPorGentiliza("ERROUUU!!!!");
        return false;
    }

    public static void novaMensagem(){
        Util.printaAewPorGentiliza("Index da pessoa?");
        String quem = Util.entraComAInformacaoAewManolo();
        Util.printaAewPorGentiliza("Qq c qr falar?");
        String mensagem = Util.entraComAInformacaoAewManolo();
        Mensagem msg = new Mensagem();
        msg.setTexto(mensagem);
        msg.setUsuario(usuarios.get(Integer.parseInt(quem)));
        mensagens.add(msg);
    }
    public static void listarMensagens(){
        for(Mensagem msg : mensagens){
            Util.printaAewPorGentiliza(msg.getDataHora());
            Util.printaAewPorGentiliza(msg.getTexto());
        }

    }

    public static void inicializarDados(){
        Usuario user1 = new Usuario();
        user1.setNome("20matar");
        user1.setUsername("20matar");
        user1.setNascimento(LocalDate.of(2000,1,1));
        usuarios.add(user1);

        Usuario user2 = new Usuario();
        user2.setNome("70correr");
        user2.setUsername("70correr");
        user2.setNascimento(LocalDate.of(2000,3,5));
        usuarios.add(user2);

    }

}