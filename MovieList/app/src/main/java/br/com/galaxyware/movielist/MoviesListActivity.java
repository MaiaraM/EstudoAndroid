package br.com.galaxyware.movielist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.movielist.dao.MovieDAO;
import br.com.galaxyware.movielist.helper.MovieItemHelperCallBack;
import br.com.galaxyware.movielist.model.Movie;
import br.com.galaxyware.movielist.ui.adapter.MovieListAdapter;
import br.com.galaxyware.movielist.ui.adapter.OnItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListActivity extends AppCompatActivity {

    @BindView(R.id.shopping_recycleview)
    RecyclerView listView;

    @BindView(R.id.lista_notas_insere_nota)
    TextView btnNew;

    private MovieListAdapter adapter;
    private List<Movie> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list_activity);
        ButterKnife.bind(this);


        MovieDAO dao = getMovieDAO();
        todos = dao.todos();
        configRecyclerView();

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MoviesListActivity.this, FormActivity.class), U.REQUEST_CODE_NEW_MOVIE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_CANCELED) {
            if (isCreatedMovie(requestCode, data)) {
                if (isResultOk(resultCode)) {
                    Movie movieCreated = getSerializableMovie(data);
                    new MovieDAO().insere(movieCreated);
                    adapter.add(movieCreated);
                }
            }

            if (isEditedMovie(requestCode, data)) {
                if (isResultOk(resultCode)) {
                    Movie movieEdited = getSerializableMovie(data);
                    int positionReceived = data.getIntExtra(U.POSITION, U.INVALID_POSITION);
                    if (positionReceived > U.INVALID_POSITION) {
                        new MovieDAO().altera(positionReceived
                                , movieEdited);
                        adapter.altera(positionReceived, movieEdited);

                    }
                }
            }
        }
    }

    private Movie getSerializableMovie(@Nullable Intent data) {
        return (Movie) data.getSerializableExtra(U.KEY_MOVIE);
    }

    private boolean isCreatedMovie(int requestCode, @Nullable Intent data) {
        return requestCode == U.REQUEST_CODE_NEW_MOVIE
                && data.hasExtra(U.KEY_MOVIE);
    }

    private boolean isEditedMovie(int requestCode, Intent data) {
        return requestCode == U.REQUEST_CODE_EDIT_MOVIE
                && data.hasExtra(U.KEY_MOVIE)
                && data.hasExtra(U.POSITION);
    }

    private boolean isResultOk(int resultCode) {
        return resultCode == Activity.RESULT_OK;
    }

    private void configRecyclerView() {
        adapter = new MovieListAdapter(MoviesListActivity.this, todos);
        listView.setAdapter(adapter);
        adapterListener();
        (new ItemTouchHelper(new MovieItemHelperCallBack(adapter))).attachToRecyclerView(listView);

    }

    private void adapterListener() {
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Movie aMovie, int position) {
                goFormEdit(aMovie, position);
            }
        });
    }

    private void goFormEdit(Movie aMovie, int position) {
        Intent openEditForm = new Intent(MoviesListActivity.this, FormActivity.class);
        openEditForm.putExtra(U.KEY_MOVIE, aMovie);
        openEditForm.putExtra(U.POSITION, position);
        startActivityForResult(openEditForm, U.REQUEST_CODE_EDIT_MOVIE);
    }

    private MovieDAO getMovieDAO() {
        MovieDAO dao = new MovieDAO();
        return dao;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
