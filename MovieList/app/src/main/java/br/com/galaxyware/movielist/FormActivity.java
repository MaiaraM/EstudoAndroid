package br.com.galaxyware.movielist;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.File;

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
    EditText sinopse;
//    @BindView(R.id.form_btn_image)
//    Button btnImage;


    private int positionReceived = U.INVALID_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);

        image.setVisibility(View.GONE);
        getEdited();
//        btnImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getImage();
//            }
//        });
    }

//    private void getImage() {
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//        intent.setType("image/*");
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            if (resultCode == RESULT_OK) {
//                if (requestCode == 1) {
//                    Uri selectedImageUri = data.getData();
//                    // Get the path from the Uri
//                    final String path = getPathFromURI(selectedImageUri);
//                    if (path != null) {
//                        File f = new File(path);
//                        selectedImageUri = Uri.fromFile(f);
//                    }
//                    // Set the image in ImageView
//                    image.setImageURI(selectedImageUri);
//                    image.setTag(selectedImageUri);
//                    System.out.println("teste " + selectedImageUri);
//                }
//            }
//        } catch (Exception e) {
//            Log.e("FileSelectorActivity", "File select error", e);
//        }
//    }
//    public String getPathFromURI(Uri contentUri) {
//        String res = null;
//        String[] proj = {MediaStore.Images.Media.DATA};
//        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
//        if (cursor.moveToFirst()) {
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            res = cursor.getString(column_index);
//        }
//        cursor.close();
//        return res;
//    }


    private void getEdited() {
        Intent dataReceive = getIntent();
        if (dataReceive.hasExtra(U.KEY_MOVIE)) {
            image.setVisibility(View.VISIBLE);
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
            if(image.getTag() != null){
                moviesList.setImage(image.getTag().toString());
            }else {
                moviesList.setImage(null);
            }
            Intent resultado = new Intent();
            resultado.putExtra(U.KEY_MOVIE, moviesList);
            resultado.putExtra(U.POSITION, positionReceived);
            setResult(Activity.RESULT_OK, resultado);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

