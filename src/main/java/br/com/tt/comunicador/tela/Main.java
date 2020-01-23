package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.ComunicadorException;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;

import java.util.ArrayList;

public class Main extends Object {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<Mensagem> mensagens = new ArrayList<>();
    public static Usuario usuarioLogado;
    private static Util util = new Util();

    private static MenuEntrar menuEntrar = new MenuEntrar(util, usuarios);
    private static MenuMensagem menuMensagem = new MenuMensagem(util, usuarios, mensagens);

    static public void main(String[] args) throws Exception {
        DadosIniciais.criaCargaInicial(usuarios);
        usuarioLogado = menuEntrar.entrar();
        if(null == usuarioLogado){
            throw new ComunicadorException("erro ao logar");
        }
        menuMain();
    }

    private static void menuMain() {
        boolean sair = false;
        while(!sair){
            util.printaAewPorGentiliza("1- Nova Mensagem | 2- Listar pessoas | 3-Listar Mensagens | 4-Sair");
            String opcao = util.entraComAInformacaoAewManolo();
            switch (opcao) {
                case "1":
                    mensagens.add(menuMensagem.novaMensagem());
                    break;
                case "2":
                    menuMensagem.listaMalucos();
                    break;
                case "3":
                    menuMensagem.listarMensagens();
                    break;
                case "4":
                    sair = true;
                    break;
            }
        }
    }
}