package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.ComunicadorException;
import br.com.tt.comunicador.common.MensagemTamanhoException;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

class Main extends Object {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Mensagem> mensagens = new ArrayList<>();
    public static Usuario usuarioLogado;

    static public void main(String[] args) throws Exception {
        inicializarDados();

        if(!entrar()){
            throw new ComunicadorException("erro ao logar");
        }
        listaMalucos();
        novaMensagem();
        listarMensagens();

    }

    public static void listaMalucos(){
        Integer i = 0;
        String texto = "";
        for(Usuario umUser:usuarios){
            texto += umUser.descricao();
            texto += "\n";
            i++;
        }
        Util.printaAewPorGentiliza(texto);

    }

    public static boolean entrar(){
        Util.printaAewPorGentiliza("Informe seu username (new) para novo usuario");
        String usernameDigitado = Util.entraComAInformacaoAewManolo();

        if(usernameDigitado.equals("new")){
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

        try {
            verificaTamanhoDaMensagem(mensagem);
        } catch (MensagemTamanhoException e) {
            Util.printaAewPorGentiliza(e.getMessage());
            novaMensagem();
            return;
        }

        Mensagem msg = new Mensagem();
        msg.setTexto(mensagem);
        msg.setUsuario(usuarios.get(Integer.parseInt(quem)));
        mensagens.add(msg);
    }

    private static void verificaTamanhoDaMensagem(String mensagem) throws MensagemTamanhoException {
        if(mensagem.length() < Util.TAMANHO_MENSAGEM_MINIMO){
            throw new MensagemTamanhoException();
        }
    }

    public static void listarMensagens(){
        String texto = "";
        for(Mensagem msg : mensagens){
            texto += msg.descricao();
            texto += "\n";
        }
        Util.printaAewPorGentiliza(texto);

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