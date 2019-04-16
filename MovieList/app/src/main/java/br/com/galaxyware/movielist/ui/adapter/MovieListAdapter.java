package br.com.galaxyware.movielist.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import br.com.galaxyware.movielist.R;
import br.com.galaxyware.movielist.U;
import br.com.galaxyware.movielist.model.Movie;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private final List<Movie> mMoviesList;
    private final Context context;
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

    public void add(Movie aMovie){
        mMoviesList.add(aMovie);
        notifyDataSetChanged();
    }

    public void altera(int position, Movie movie) {
        mMoviesList.set(position, movie);
        notifyItemChanged(position);
    }

    public void remove(int position) {
        mMoviesList.remove(position);
        notifyItemRemoved(position);
    }

    public void troca(int startPosition, int endPosition) {
        Collections.swap(mMoviesList, startPosition,endPosition );
        notifyItemMoved(startPosition,endPosition);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        private final TextView titulo;
        private final ImageView image;
        private final TextView sinopse;
        private final RatingBar rating;
        private final ConstraintLayout cardView;
        private Movie movie;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            titulo = itemView.findViewById(R.id.card_tittle);
            image = itemView.findViewById(R.id.card_image);
            sinopse = itemView.findViewById(R.id.card_sinopse);
            rating = itemView.findViewById(R.id.card_rating);
            rating.setVisibility(View.GONE);
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
            sinopse.setText(aMovie.getSinopse());
            if(aMovie.getImage() != null){
                image.setImageDrawable(U.getFoto(aMovie.getImage(), context));
                image.setTag(aMovie.getImage());
            }
            if(aMovie.getNota() != 0){
                rating.setVisibility(View.VISIBLE);
                rating.isEnabled();
                rating.setRating(aMovie.getNota());
                changeColor();
            }
        }

        public void changeColor(){
            cardView.setBackground(U.getFoto("background_card_green", context));
        }
    }


}
