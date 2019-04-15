package br.com.galaxyware.shoppinglist.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.galaxyware.shoppinglist.model.Movie;

public class MovieDAO {

    private final static ArrayList<Movie> notas = new ArrayList<>();

    public List<Movie> todos() {
        return (List<Movie>) notas.clone();
    }

    public void insere(Movie aMovie) {
        MovieDAO.notas.addAll(Arrays.asList(aMovie));
    }

    public void altera(int posicao, Movie aMovie) {
        notas.set(posicao, aMovie);
    }

    public void remove(int posicao) {
        notas.remove(posicao);
    }

    public void troca(int posicaoInicio, int posicaoFim) {
        Collections.swap(notas, posicaoInicio, posicaoFim);
    }

    public void removeTodos() {
        notas.clear();
    }
}
