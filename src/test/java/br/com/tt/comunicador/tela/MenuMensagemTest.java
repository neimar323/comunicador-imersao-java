package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Mensagem;
import br.com.tt.comunicador.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MenuMensagemTest {
    @Mock
    Util util;

    @Test
    void deveriaGerarnovaMensagem() {
        Usuario user1 = new Usuario("Neimar", "neimar", "18/01/1991", "SC");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Mensagem> mensagens = new ArrayList<>();

        usuarios.add(user1);

        MenuMensagem menuMensagem = new MenuMensagem(util,usuarios, mensagens);
        Mockito.when(util.entraComAInformacaoAewManolo()).thenReturn("0").thenReturn("Ola meu amigo");

        Mensagem novaMensagem = menuMensagem.novaMensagem();

        assertEquals("Ola meu amigo", novaMensagem.getTexto());
        assertEquals("Neimar" ,novaMensagem.getUsuario().getNome());
    }

    @Test
    void deveriaDarerroNaPrimeiraEntrada() {
        Usuario user1 = new Usuario("Neimar", "neimar", "18/01/1991", "RS");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Mensagem> mensagens = new ArrayList<>();

        usuarios.add(user1);

        MenuMensagem menuMensagem = new MenuMensagem(util,usuarios, mensagens);
        Mockito.when(util.entraComAInformacaoAewManolo()).thenReturn("0").thenReturn("").thenReturn("0").thenReturn("1234567");

        Mensagem novaMensagem = menuMensagem.novaMensagem();

        assertEquals("1234567", novaMensagem.getTexto());
        assertEquals("Neimar" ,novaMensagem.getUsuario().getNome());

    }



//    public void listarMensagens(){
//        String texto = "";
//        for(Mensagem msg : mensagens){
//            texto += msg.descricao();
//            texto += "\n";
//        }
//        util.printaAewPorGentileza(texto);
//    }

    @Test
    void listarMensagens() {
        ArrayList<Mensagem> mensagens = new ArrayList<>();
        Mensagem msg1 = new Mensagem();
        msg1.setTexto("opa e aew blz?");
        mensagens.add(msg1);

        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                String argsString = (String) args[0];
                assertTrue(argsString.contains("opa e aew blz?"));
                return null;
            }
        }).when(util).printaAewPorGentiliza(Mockito.anyString());

        MenuMensagem menuMensagem = new MenuMensagem(util, null, mensagens);
        menuMensagem.listarMensagens();

    }

    @Test
    void listaMalucos() {
    }
}