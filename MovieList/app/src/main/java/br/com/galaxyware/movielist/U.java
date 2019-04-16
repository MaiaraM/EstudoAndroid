package br.com.galaxyware.movielist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import br.com.galaxyware.movielist.model.Movie;

public class U {
    public static final String KEY_MOVIE = "movie";
    public static final int REQUEST_CODE_NEW_MOVIE = 1;
    public static final int REQUEST_CODE_EDIT_MOVIE = 2;

    public static final String POSITION = "position" ;
    public static final int INVALID_POSITION = -1;

    //Retorna o Drawable pelo nome da imagem
    public static Drawable getFoto(String imageWay, Context context) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(imageWay, "drawable", context.getPackageName());
        Drawable imagem = resources.getDrawable(idDrawable);
        return imagem ;
    }

    public static String getNameFoto(ImageView aMovie, Context context) {
        Resources resources = context.getResources();
        return resources.getResourceEntryName(aMovie.getId());
    }
}
