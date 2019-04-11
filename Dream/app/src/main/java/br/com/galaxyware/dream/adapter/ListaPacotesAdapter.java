package br.com.galaxyware.dream.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.galaxyware.dream.R;
import br.com.galaxyware.dream.model.Pacote;
import butterknife.BindView;

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



        TextView local = viewCriada.findViewById(R.id.local);
        local.setText(pacote.getLocal());

        setQuantDias(pacote, viewCriada);
        setPrecoPacote(pacote, viewCriada);
        setFoto(pacote, viewCriada);


        return viewCriada;
    }

    private void setFoto(Pacote pacote, View viewCriada) {
        ImageView foto = viewCriada.findViewById(R.id.foto);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable imagem = resources.getDrawable(idDrawable);
        foto.setImageDrawable(imagem);
    }

    private void setPrecoPacote(Pacote pacote, View viewCriada) {
        TextView valor = viewCriada.findViewById(R.id.valor);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String precoPacote = formatoBrasileiro.format(pacote.getPreco());
        System.out.println(precoPacote);
        valor.setText(precoPacote);
    }

    private void setQuantDias(Pacote pacote, View viewCriada) {
        TextView dias = viewCriada.findViewById(R.id.dias);
        int numeroDias = pacote.getDias();
        String textoDias = "";
        if(numeroDias >1){
            textoDias = numeroDias + " dias";
        }else{
            textoDias = numeroDias + " dia";
        }
        System.out.println(textoDias);
        dias.setText(textoDias);
    }
}
