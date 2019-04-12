package br.com.galaxyware.dream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import java.math.BigDecimal;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.model.Pacote;
import br.com.galaxyware.dream.util.U;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CompraActivity extends AppCompatActivity {
    @BindView(R.id.finish_foto)
    ImageView imageFoto;
    @BindView(R.id.finish_local)
    EditText txtLocal;
    @BindView(R.id.finish_date)
    EditText txtDate;
    @BindView(R.id.finish_price)
    EditText txtPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        ButterKnife.bind(this);
        setTitle("Compra Finalizada");


        Intent intent = getIntent();
        if (intent.hasExtra(U.PACOTE_INTENT)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(U.PACOTE_INTENT);
            txtLocal.setText(pacote.getLocal());
            txtDate.setText(U.getDates(pacote.getDias()));
            txtPrice.setText(U.getPrice(pacote));
            imageFoto.setImageDrawable(U.getFoto(pacote, this));
        }
    }
}
