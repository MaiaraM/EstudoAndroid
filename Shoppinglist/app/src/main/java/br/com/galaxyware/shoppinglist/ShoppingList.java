package br.com.galaxyware.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.shoppinglist.dao.MovieDAO;
import br.com.galaxyware.shoppinglist.model.Movie;
import br.com.galaxyware.shoppinglist.ui.adapter.ListPurchaseAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingList extends AppCompatActivity {

    @BindView(R.id.shopping_recycleview)
    RecyclerView listView;

    @BindView(R.id.lista_notas_insere_nota)
    TextView btnNew;

    private ListPurchaseAdapter adapter;
    private List<Movie> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);


        MovieDAO dao = getMovieDAO();
        todos = dao.todos();
        configRecyclerView();

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoppingList.this, FormActivity.class));
            }
        });

    }

    private void configRecyclerView() {
        adapter = new ListPurchaseAdapter(this, todos);
        listView.setAdapter(adapter);
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
        MovieDAO movieDAO = new MovieDAO();
        todos.clear();
        todos.addAll(movieDAO.todos());
        adapter.notifyDataSetChanged();
        super.onResume();
    }
}
