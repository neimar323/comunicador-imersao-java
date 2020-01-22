package br.com.tt.comunicador.model;

import java.time.LocalDateTime;

public class Mensagem {
    private String texto;
    private LocalDateTime dataHora = LocalDateTime.now();
    private Usuario usuario;

    public void criarMensagem(String texto, Usuario usuario){
        this.texto = texto;
        this.usuario = usuario;
        this.dataHora = LocalDateTime.now();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                ", dataHora=" + dataHora +
                ", usuario=" + usuario +
                '}';
    }

    public String descricao() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                ", dataHora=" + dataHora +
                ", usuario=" + usuario +
                '}';
    }
}
