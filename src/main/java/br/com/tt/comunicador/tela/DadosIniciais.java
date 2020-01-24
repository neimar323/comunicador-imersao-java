package br.com.tt.comunicador.tela;

import br.com.tt.comunicador.model.EstadoEnum;
import br.com.tt.comunicador.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class DadosIniciais {

    public static void criaCargaInicial(ArrayList<Usuario> usuarios) {
        Usuario user1 = new Usuario();
        user1.setNome("1");
        user1.setUsername("1");
        user1.setNascimento(LocalDate.of(2000,1,1));
        user1.setEstado(EstadoEnum.SC);
        usuarios.add(user1);

        Usuario user2 = new Usuario();
        user2.setNome("2");
        user2.setUsername("2");
        user2.setNascimento(LocalDate.of(2000,3,5));
        user2.setEstado(EstadoEnum.SC);
        usuarios.add(user2);

    }

}
