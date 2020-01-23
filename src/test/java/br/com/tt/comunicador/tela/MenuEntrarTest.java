package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.common.Util;
import br.com.tt.comunicador.model.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.security.auth.login.LoginException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MenuEntrarTest {

    @Mock
    Util util;

    @Test
    void deveriaEntrar(){
        //given
        Mockito.when(util.entraComAInformacaoAewManolo())
                .thenReturn("new")
                .thenReturn("neimar")
                .thenReturn("neimarUser")
                .thenReturn("18/01/1991");


        ArrayList<Usuario> usuarios = new ArrayList<>();
        MenuEntrar m = new MenuEntrar(util, usuarios);

        //when
        Usuario usuarioTest = m.entrar();
        //then
        assertEquals("neimar", usuarioTest.getNome());
        assertEquals("neimarUser", usuarioTest.getUsername());
        assertEquals(LocalDate.of(1991, 1, 18), usuarioTest.getNascimento());

        Mockito.verify(util, Mockito.times(4)).entraComAInformacaoAewManolo();

    }

    @Test
    void deveriaDarErroNaData(){
        //given
        Mockito.when(util.entraComAInformacaoAewManolo())
                .thenReturn("new")
                .thenReturn("usuarioNaoExiste")
                .thenReturn("usuarioNaoExisteUser")
                .thenReturn("18/01/1990000000");


        ArrayList<Usuario> usuarios = new ArrayList<>();
        MenuEntrar m = new MenuEntrar(util, usuarios);

        //when
        Exception exception = assertThrows(
                DateTimeParseException.class,
                () -> m.entrar());

        //then


    }

}