package br.com.tt.comunicador.model;

public enum EstadoEnum {
    RS("Rio Grande do Sul"), SC("Santa Catarina"), PR("Parana"), SP("Sao Paulo");

    private String descricao;

    EstadoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}

