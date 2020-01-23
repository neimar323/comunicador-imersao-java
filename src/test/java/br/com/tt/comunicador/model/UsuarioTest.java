package br.com.tt.comunicador.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    public void deveriaRetornarAIdade(){
        Usuario user = new Usuario();
        LocalDate diaNascimento = LocalDate.of(1999,1,1);
        user.setNascimento(diaNascimento);
        int idade = user.idade();
        assertEquals((LocalDate.now().getYear()-diaNascimento.getYear()), idade);
    }

}