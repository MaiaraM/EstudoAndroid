package br.com.galaxyware.dream.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pacote {

    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String local, String imagem, int dias, BigDecimal preco) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumoData(){
        Calendar dataIda = Calendar.getInstance();

        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);

        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM");

        return formataData.format(dataIda.getTime())
                + " - "
                + formataData.format(dataVolta.getTime())
                + " de "
                + dataVolta.get(Calendar.YEAR);
    }
}
