package br.com.tt.comunicador.common;

public class MensagemTamanhoException extends Exception {
    public MensagemTamanhoException()
    {
        // Call constructor of parent Exception
        super("Mensagem de valor menor que "+Util.TAMANHO_MENSAGEM_MINIMO);
    }


}
