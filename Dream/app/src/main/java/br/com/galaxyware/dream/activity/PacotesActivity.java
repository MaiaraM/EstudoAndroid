package br.com.galaxyware.dream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.adapter.ListaPacotesAdapter;
import br.com.galaxyware.dream.dao.PacoteDAO;
import br.com.galaxyware.dream.model.Pacote;
import br.com.galaxyware.dream.util.U;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PacotesActivity extends AppCompatActivity {

    @BindView(R.id.lista_pacotes)
    ListView listaDePacotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacotes);
        ButterKnife.bind(this);

        configListPacote();
    }

    private void configListPacote() {
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClick = pacotes.get(position);
                showResumo(pacoteClick);
            }
        });
    }

    private void showResumo(Pacote pacoteClick) {
        Intent intent = new Intent(PacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(U.PACOTE_INTENT,  pacoteClick);
        startActivity(intent);
    }
}
