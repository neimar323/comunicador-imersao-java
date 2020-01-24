package br.com.tt.comunicador.model;

import br.com.tt.comunicador.common.Util;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class Usuario {
    private String username;
    private String nome;
    private LocalDate nascimento;
    private EstadoEnum estado;

    public Usuario(String nome, String userName, String dataNascimento, String estado) {
        this.setNome(nome);
        this.setUsername(userName);
        this.nascimento = LocalDate.parse(dataNascimento, Util.FORMATO);
        this.estado = EstadoEnum.valueOf(estado);;
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
                ", idade =" + this.idade() + '\'' +
                ", estado =" + this.getEstado().getDescricao() + '\'' +
                '}';
    }
    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstado() {
        return this.estado;
    }

}
