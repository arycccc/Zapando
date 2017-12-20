package ar.edu.proyectosort.zapando;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter{
    private Context context;
    private ArrayList<Entidad> listItens;

    public Adaptador(Context context, ArrayList<Entidad> listItens){
        this.context = context;
        this.listItens = listItens;
    }

    @Override
    public int getCount() {
        return listItens.size();
    }

    @Override
    public Object getItem(int position) {
        return listItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Entidad Item = (Entidad) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.activity_match,null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFoto);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
        TextView tvcontenido = (TextView) convertView.findViewById(R.id.tvContenido);

        imgFoto.setImageResource(Item.getImgFoto());
        tvTitulo.setText(Item.getTitulo());
        tvcontenido.setText(Item.getContenido());

        return convertView;
    }
}
