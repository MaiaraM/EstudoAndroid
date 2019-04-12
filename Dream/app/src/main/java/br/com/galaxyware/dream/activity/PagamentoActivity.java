package br.com.galaxyware.dream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.model.Pacote;
import br.com.galaxyware.dream.util.U;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PagamentoActivity extends AppCompatActivity {
    @BindView(R.id.payment_price)
    TextView txtPrice;
    @BindView(R.id.payment_number_card)
    EditText editNumberCard;
    @BindView(R.id.payment_month_card)
    EditText editMonthCard;
    @BindView(R.id.payment_year_card)
    EditText editYearCard;
    @BindView(R.id.payment_cvc_card)
    TextView editCvvCard;
    @BindView(R.id.payment_name_card)
    TextView editNameCar;
    @BindView(R.id.payment_btn_pay)
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        ButterKnife.bind(this);

        setTitle("Pagamento");

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            txtPrice.setText(U.getPrice(pacote));

            btnPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this
                            , CompraActivity.class);
                    intent.putExtra("pacote",  pacote);
                    startActivity(intent);
                }
            });

        }
    }
}
