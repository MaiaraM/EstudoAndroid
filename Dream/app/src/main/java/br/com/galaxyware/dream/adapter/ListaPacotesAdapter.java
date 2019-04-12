package br.com.galaxyware.dream.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.model.Pacote;
import br.com.galaxyware.dream.util.U;

public class ListaPacotesAdapter extends BaseAdapter {
    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(position);

        TextView txtLocal = viewCriada.findViewById(R.id.local);
        TextView txtDays = viewCriada.findViewById(R.id.dias);
        TextView txtPrice = viewCriada.findViewById(R.id.valor);
        ImageView imageFoto = viewCriada.findViewById(R.id.foto);

        txtLocal.setText(pacote.getLocal());
        txtDays.setText(U.countDays(pacote));
        txtPrice.setText(U.getPrice(pacote));
        imageFoto.setImageDrawable(U.getFoto(pacote, context));


        return viewCriada;
    }



}
