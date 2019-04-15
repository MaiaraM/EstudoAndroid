package br.com.galaxyware.shoppinglist.model;

public class Movie {

    private final String titulo;
    private final String descricao;

    public Movie(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}