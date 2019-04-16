package br.com.galaxyware.movielist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.movielist.dao.MovieDAO;
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
    private int intExtra;

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
                startActivityForResult(new Intent(MoviesListActivity.this, FormActivity.class), 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == U.REQUEST_CODE_NEW_MOVIE && resultCode == U.RESULT_CODE_NEW_MOVIE && data.hasExtra(U.KEY_MOVIE)){
            Movie movieCreated = (Movie) data.getSerializableExtra(U.KEY_MOVIE);
            new MovieDAO().insere(movieCreated);
            adapter.add(movieCreated);
        }

        if(requestCode == U.REQUEST_CODE_EDIT_MOVIE
                && resultCode == U.RESULT_CODE_NEW_MOVIE
                && data.hasExtra(U.KEY_MOVIE)
                && data.hasExtra(U.POSITION)){
            Movie movieEdited = (Movie) data.getSerializableExtra(U.KEY_MOVIE);
            int positionReceived = data.getIntExtra(U.POSITION, -1);
            new MovieDAO().altera(positionReceived
                    ,movieEdited);
            adapter.altera(positionReceived, movieEdited);
        }
    }

    private void configRecyclerView() {
        adapter = new MovieListAdapter(this, todos);
        listView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Movie aMovie, int position) {
                Intent openEditForm = new Intent(MoviesListActivity.this, FormActivity.class);
                openEditForm.putExtra(U.KEY_MOVIE, aMovie);
                openEditForm.putExtra(U.POSITION, position);
                startActivityForResult(openEditForm, U.REQUEST_CODE_EDIT_MOVIE);
            }
        });
    }

    private MovieDAO getMovieDAO() {
        MovieDAO dao = new MovieDAO();
        dao.insere(new Movie("Nota ", "Descrição teste de varios texto e tudo mais e mimimi e talz"));
        for(int i = 1 ; i<10; i++){
            dao.insere(new Movie("Nota " + i, "Descrição " + i));
        }
        return dao;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
