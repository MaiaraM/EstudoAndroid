package br.com.galaxyware.movielist.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.galaxyware.movielist.model.Movie;


public class MovieDAO {

    private final static ArrayList<Movie> movies = new ArrayList<>();

    static {
        Movie starWars = new Movie("Star Wars: Os Últimos Jedi",  (float) 0, "A tranquila e solitária vida de Luke Skywalker sofre uma reviravolta quando ele conhece Rey, " +
                "uma jovem que mostra fortes sinais da Força. ");
        starWars.setImage("star_wars");

        Movie jumanji = new Movie("Jumanji: Bem-vindo à Selva",  (float) 0, "Quatro adolescentes encontram um videogame cuja ação se passa em uma floresta tropical.  ");
        jumanji.setImage("jumanji");

        Movie interstelar = new Movie("Interestelar",  (float) 0, "As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando continuação da espécie. Cooper é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos.  ");
        interstelar.setImage("interestelar");

        Movie dragao = new Movie("Como Treinar o Seu Dragão",  (float) 0, "Soluço é um adolescente viking da ilha de Berk, onde lutar contra dragões é um meio de vida. Suas opiniões avançadas e um senso de humor estranho o tornam um desajustado, apesar de seu pai ser o chefe do clã. Jogado em uma escola de combate a dragões, ele quer provar que é um verdadeiro viking, mas ao fazer amizade com um dragão machucado, ele tem a chance de mudar o futuro de seu povo.");
        dragao.setImage("dragao");

        movies.add(jumanji);
        movies.add(starWars);
        movies.add(interstelar);
        movies.add(dragao);
    }

    public List<Movie> todos() {
        return (List<Movie>) movies.clone();
    }

    public void insere(Movie aMovie) {
        MovieDAO.movies.addAll(Arrays.asList(aMovie));
    }

    public void altera(int posicao, Movie aMovie) {
        movies.set(posicao, aMovie);
    }

    public void remove(int posicao) {
        movies.remove(posicao);
    }

    public void troca(int posicaoInicio, int posicaoFim) {
        Collections.swap(movies, posicaoInicio, posicaoFim);
    }

    public void removeTodos() {
        movies.clear();
    }
}
