package br.com.galaxyware.movielist.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import br.com.galaxyware.movielist.dao.MovieDAO;
import br.com.galaxyware.movielist.ui.adapter.MovieListAdapter;

public class MovieItemHelperCallBack extends ItemTouchHelper.Callback {

    private final MovieListAdapter adapter;


    public MovieItemHelperCallBack(MovieListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int markSwiped = ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT;
        int markMove = ItemTouchHelper.DOWN |ItemTouchHelper.UP | ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT;
        return makeMovementFlags(markMove,markSwiped );
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        new MovieDAO().troca(viewHolder.getAdapterPosition(),target.getAdapterPosition() );
        adapter.troca(viewHolder.getAdapterPosition(),target.getAdapterPosition() );
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        new MovieDAO().remove(viewHolder.getAdapterPosition());
        adapter.remove(viewHolder.getAdapterPosition());
    }
}
