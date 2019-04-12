package br.com.galaxyware.dream.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.galaxyware.dream.model.Pacote;

public class U {

    public static final String PACOTE_INTENT = "pacote";

    //Retorna string com dia ou dias
    public static String countDays(Pacote aPacote) {
        int numeroDias = aPacote.getDias();
        String textoDias = "";
        if (numeroDias > 1) {
            textoDias = numeroDias + " dias";
        } else {
            textoDias = numeroDias + " dia";
        }
        return textoDias;
    }

    //Formata Bigdeciaml para o preço e formato R$
    public static String getPrice(Pacote aPacote) {
        NumberFormat formatBrazilian = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String pacotePrice = formatBrazilian.format(aPacote.getPreco());
        return pacotePrice;
    }

    //Retorna o Drawable pelo nome da imagem
    public static Drawable getFoto(Pacote aPacote, Context context) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(aPacote.getImagem(), "drawable", context.getPackageName());
        Drawable imagem = resources.getDrawable(idDrawable);
        return imagem ;
    }

    //Calcular a cada de inicio e final
    public static String getDates(Integer aDias){
        Calendar dataIda = Calendar.getInstance();

        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, aDias);

        return getDateString(dataIda, dataVolta);
    }

    // Restorna uma string formatada com a duas datas
    @NonNull
    private static String getDateString(Calendar dataIda, Calendar dataVolta) {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM");
        return formataData.format(dataIda.getTime())
                + " - "
                + formataData.format(dataVolta.getTime())
                + " de "
                + dataVolta.get(Calendar.YEAR);
    }
}
