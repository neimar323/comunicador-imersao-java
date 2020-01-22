package br.com.tt.comunicador.model;

import br.com.tt.comunicador.common.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class Usuario {
    private String username;
    private String nome;
    private LocalDate nascimento;

    public Usuario(String nome, String userName, String dataNascimento) {
        this.setNome(nome);
        this.setUsername(userName);
        this.nascimento = LocalDate.parse(dataNascimento, Util.FORMATO);
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento + '\'' +
                ", idade =" + this.idade() +
                '}';
    }

    public int idade(){
        long anos = YEARS.between(this.nascimento, LocalDate.now());
        return (int) anos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }


    public String descricao() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento + '\'' +
                ", idade =" + this.idade() +
                '}';
    }
}
