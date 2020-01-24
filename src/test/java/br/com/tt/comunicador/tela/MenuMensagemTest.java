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

import java.awt.*;
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


    String textListaMalucos = "";
    @Test
    void listaMalucos() {
        Usuario user1 = new Usuario("Neimar", "neimar", "18/01/1991", "RS");
        Usuario user2 = new Usuario("asd", "asd", "18/01/1991", "SC");
        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios.add(user1);
        usuarios.add(user2);

        MenuMensagem menuMensagem = new MenuMensagem(util, usuarios, null);

        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {

                Object[] args = invocation.getArguments();
                for(int i = 0; i < args.length; i++){
                    String argsString = (String) args[0];
                    textListaMalucos+= argsString;
                }
                return null;
            }
        }).when(util).printaAewPorGentiliza(Mockito.anyString());

        menuMensagem.listaMalucos();

        String msgEsperada = "Usuario{username='neimar', nome='Neimar', nascimento=1991-01-18', idade =29', estado =Rio Grande do Sul'}"
            +"\nUsuario{username='asd', nome='asd', nascimento=1991-01-18', idade =29', estado =Santa Catarina'}\n";
        assertEquals(msgEsperada, textListaMalucos);

    }
}