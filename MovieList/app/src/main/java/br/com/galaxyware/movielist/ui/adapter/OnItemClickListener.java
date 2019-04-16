package br.com.galaxyware.movielist.ui.adapter;

import br.com.galaxyware.movielist.model.Movie;

//Listener do Recycler view
public interface OnItemClickListener {

    void onItemClick(Movie aMovie, int position);
}
