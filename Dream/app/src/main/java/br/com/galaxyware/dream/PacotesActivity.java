package br.com.galaxyware.dream;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.galaxyware.dream.DAO.PacoteDAO;
import br.com.galaxyware.dream.adapter.ListaPacotesAdapter;
import br.com.galaxyware.dream.model.Pacote;
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

        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));


    }
}
