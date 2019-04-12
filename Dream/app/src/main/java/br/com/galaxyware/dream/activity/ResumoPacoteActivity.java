package br.com.galaxyware.dream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
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

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            localPacote.setText(pacote.getLocal());
            diasPacote.setText(U.countDays(pacote));
            dataPacote.setText(U.getDates(pacote.getDias()));
            precoPacote.setText(U.getPrice(pacote));
            fotoLocalPacote.setImageDrawable(U.getFoto(pacote, this));

            btnPagamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResumoPacoteActivity.this
                            , PagamentoActivity.class);
                    intent.putExtra("pacote",  pacote);
                    startActivity(intent);
                }
            });
        }




    }
}
