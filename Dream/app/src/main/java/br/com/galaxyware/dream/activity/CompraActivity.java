package br.com.galaxyware.dream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    TextView txtLocal;
    @BindView(R.id.finish_date)
    TextView txtDate;
    @BindView(R.id.finish_price)
    TextView txtPrice;
    @BindView(R.id.finish_btn_voltar)
    Button btnVoltar;


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

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompraActivity.this
                        , PacotesActivity.class);
                startActivity(intent);
            }
        });
    }
}
