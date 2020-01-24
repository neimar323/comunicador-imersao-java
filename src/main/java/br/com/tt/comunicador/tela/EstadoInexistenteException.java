package br.com.tt.comunicador.tela;

public class EstadoInexistenteException extends Exception{
    public EstadoInexistenteException(String mensagem) {
        super(mensagem);
    }
}