package br.com.galaxyware.dream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.math.BigDecimal;

import br.com.galaxyware.dream.model.Pacote;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ResumoPacoteActivity extends AppCompatActivity {
    @BindView(R.id.resumo_foto_local_pacote) ImageView fotoLocalPacote;
    @BindView(R.id.resumo_local_pacote) ImageView localPacote;
    @BindView(R.id.resumo_dias_pacote) ImageView diasPacote;
    @BindView(R.id.resumo_data_pacote) ImageView dataPacote;
    @BindView(R.id.resumo_preco_pacote) ImageView precoPacote;
    @BindView(R.id.resumo_btn_pagamento) Button btnPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        ButterKnife.bind(this);

        Pacote pacoteSP = new Pacote("São Paulo", "sp", 2, new BigDecimal("200.6"));

    }
}
