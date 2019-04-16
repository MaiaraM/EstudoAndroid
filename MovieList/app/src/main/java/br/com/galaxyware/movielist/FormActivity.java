package br.com.galaxyware.movielist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.galaxyware.movielist.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FormActivity extends AppCompatActivity {

    @BindView(R.id.form_titulo)
    EditText titulo;
    @BindView(R.id.form_image)
    ImageView image;
    @BindView(R.id.form_ratingBar)
    RatingBar nota;
    @BindView(R.id.form_sinopse)
    TextView sinopse;


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
            image.setImageDrawable(U.getFoto(movieReceive.getImage() , FormActivity.this));
            image.setTag(movieReceive.getImage());
            nota.setRating(movieReceive.getNota());
            sinopse.setText(movieReceive.getSinopse());
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
            Movie moviesList = new Movie(titulo.getText().toString(),nota.getRating() ,sinopse.getText().toString());

            moviesList.setImage(image.getTag().toString());
            Intent resultado = new Intent();
            resultado.putExtra(U.KEY_MOVIE, moviesList);
            resultado.putExtra(U.POSITION, positionReceived);
            setResult(Activity.RESULT_OK, resultado);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

