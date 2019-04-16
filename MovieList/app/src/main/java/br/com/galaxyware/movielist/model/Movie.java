package br.com.galaxyware.movielist.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Movie  implements Serializable {

    private final String titulo;
    private String image;
    private final Float nota;
    private final String sinopse;

    public Movie(String titulo, Float nota, String sinopse) {
        this.titulo = titulo;
        this.nota = nota;
        this.sinopse = sinopse;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getImage() {
        return image;
    }

    public Float getNota() {
        return nota;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setImage(String image) {
        this.image = image;
    }
}