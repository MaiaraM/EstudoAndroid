package br.com.galaxyware.movielist.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Movie  implements Serializable {

    private final String titulo;
    private final String descricao;

    public Movie(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

//    private Movie(Parcel p){
//        titulo = p.readString();
//        descricao = p.readString();
//    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(titulo);
//        dest.writeString(descricao);
//    }
//
//    public static final Parcelable.Creator<Movie>
//            CREATOR = new Parcelable.Creator<Movie>() {
//
//        public Movie createFromParcel(Parcel in) {
//            return new Movie(in);
//        }
//
//        public Movie[] newArray(int size) {
//            return new Movie[size];
//        }
//    };
}