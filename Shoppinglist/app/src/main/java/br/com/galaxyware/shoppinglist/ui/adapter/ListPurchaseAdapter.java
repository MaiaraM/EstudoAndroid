package br.com.galaxyware.shoppinglist.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.shoppinglist.R;
import br.com.galaxyware.shoppinglist.model.Movie;

public class ListPurchaseAdapter extends RecyclerView.Adapter<ListPurchaseAdapter.PurchaseViewHolder> {

    private final List<Movie> mMovies;
    private  final Context context;

    public ListPurchaseAdapter(Context context,List<Movie> aMovie) {
        this.context =context;
        this.mMovies = aMovie;
    }

    @NonNull
    @Override
    public PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewCreated = LayoutInflater.from(context).inflate(R.layout.item_purchase, viewGroup, false);

        return new PurchaseViewHolder(viewCreated);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseViewHolder aViewHolder, int i) {
        Movie movie = mMovies.get(i);
        aViewHolder.vincula(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class PurchaseViewHolder extends RecyclerView.ViewHolder{
        private final TextView titulo;
        private final TextView descricao;


        public PurchaseViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);
        }

        public void vincula(Movie aMovie){
            titulo.setText(aMovie.getTitulo());
            descricao.setText(aMovie.getDescricao());
        }
    }
}
