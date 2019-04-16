package br.com.galaxyware.movielist.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.movielist.R;
import br.com.galaxyware.movielist.model.Movie;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private final List<Movie> mMoviesList;
    private  final Context context;
    private OnItemClickListener onItemClickListener;

    public MovieListAdapter(Context context, List<Movie> aMovie) {
        this.context =context;
        this.mMoviesList = aMovie;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewCreated = LayoutInflater.from(context).inflate(R.layout.activity_card_item, viewGroup, false);

        return new MovieViewHolder(viewCreated);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder aViewHolder, int i) {
        Movie movie = mMoviesList.get(i);
        aViewHolder.vincula(movie);
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public void altera(int position, Movie movie) {
        mMoviesList.set(position, movie);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        private final TextView titulo;
        private final TextView descricao;
        private Movie movie;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.card_tittle);
            descricao = itemView.findViewById(R.id.card_sinopse);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(movie, getAdapterPosition());
                }
            });
        }

        public void vincula(Movie aMovie){
            this.movie = aMovie;
            titulo.setText(aMovie.getTitulo());
            descricao.setText(aMovie.getDescricao());
        }
    }

    public void add(Movie aMovie){
        mMoviesList.add(aMovie);
        notifyDataSetChanged();
    }
}
