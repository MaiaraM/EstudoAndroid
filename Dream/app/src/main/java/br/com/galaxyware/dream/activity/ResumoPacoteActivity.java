package br.com.galaxyware.dream.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.model.Pacote;
import br.com.galaxyware.dream.util.U;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ResumoPacoteActivity extends AppCompatActivity {
    @BindView(R.id.resumo_foto_local_pacote) ImageView fotoLocalPacote;
    @BindView(R.id.resumo_local_pacote)
    TextView localPacote;
    @BindView(R.id.resumo_dias_pacote) TextView diasPacote;
    @BindView(R.id.resumo_data_pacote) TextView dataPacote;
    @BindView(R.id.resumo_preco_pacote) TextView precoPacote;
    @BindView(R.id.resumo_btn_pagamento) Button btnPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        ButterKnife.bind(this);

        Pacote pacoteSP = new Pacote("São Paulo", "sp", 2, new BigDecimal("200.6"));

        localPacote.setText(pacoteSP.getLocal());
        diasPacote.setText(U.countDays(pacoteSP));
        dataPacote.setText(U.getDates(pacoteSP.getDias()));
        precoPacote.setText(U.getPrice(pacoteSP));
        fotoLocalPacote.setImageDrawable(U.getFoto(pacoteSP, this));

    }
}
