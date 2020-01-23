package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.MensagemTamanhoException;
import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;

import java.util.ArrayList;

public class MenuMensagem {
    private final Util util;
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Mensagem> mensagens;

    public MenuMensagem(Util util, ArrayList<Usuario> usuarios, ArrayList<Mensagem> mensagens) {
        this.util = util;
        this.usuarios = usuarios;
        this.mensagens = mensagens;
    }

    public Mensagem novaMensagem(){
        util.printaAewPorGentiliza("Index da pessoa?");
        String quem = util.entraComAInformacaoAewManolo();
        util.printaAewPorGentiliza("Qq c qr falar?");
        String mensagem = util.entraComAInformacaoAewManolo();

        try {
            verificaTamanhoDaMensagem(mensagem);
        } catch (MensagemTamanhoException e) {
            util.printaAewPorGentiliza(e.getMessage());
            return this.novaMensagem();
        }

        Mensagem msg = new Mensagem();
        msg.setTexto(mensagem);
        msg.setUsuario(usuarios.get(Integer.parseInt(quem)));
        return msg;
    }

    private void verificaTamanhoDaMensagem(String msg) throws MensagemTamanhoException {
        if(msg.length() < util.TAMANHO_MENSAGEM_MINIMO){
            throw new MensagemTamanhoException();
        }
    }

    public void listarMensagens(){
        String texto = "";
        for(Mensagem msg : mensagens){
            texto += msg.descricao();
            texto += "\n";
        }
        util.printaAewPorGentiliza(texto);
    }

    public void listaMalucos(){
        String texto = "";
        for(Usuario umUser:usuarios){
            texto += umUser.descricao();
            texto += "\n";
        }
        util.printaAewPorGentiliza(texto);
    }

}
