package br.com.galaxyware.movielist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.galaxyware.movielist.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FormActivity extends AppCompatActivity {

    @BindView(R.id.formulario_nota_titulo)
    EditText titulo;
    @BindView(R.id.formulario_nota_descricao)
    EditText descricao;


    private int positionReceived = U.INVALID_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);

        getEdited();

    }

    private void getEdited() {
        Intent dataReceive = getIntent();
        if (dataReceive.hasExtra(U.KEY_MOVIE)) {
            Movie movieReceive = (Movie) dataReceive.getSerializableExtra(U.KEY_MOVIE);
            positionReceived = dataReceive.getIntExtra(U.POSITION, U.INVALID_POSITION);
            titulo.setText(movieReceive.getTitulo());
            descricao.setText(movieReceive.getDescricao());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.form_salve) {
            Movie moviesList = new Movie(titulo.getText().toString(), descricao.getText().toString());
            Intent resultado = new Intent();
            resultado.putExtra(U.KEY_MOVIE, moviesList);
            resultado.putExtra(U.POSITION, positionReceived);
            setResult(Activity.RESULT_OK, resultado);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

