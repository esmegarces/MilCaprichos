package com.example.milcaprichos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostreAdapter extends RecyclerView.Adapter<PostreAdapter.ViewHolder> {

    ArrayList<Postre> listapostres;
    FragmentActivity activity;

    public PostreAdapter(ArrayList<Postre> listapostres, Activity activity) {
        this.listapostres = listapostres;
        this.activity = (FragmentActivity) activity;
    }

    //Metodo que se llama cuando se crea el ViewHolder
    @NonNull
    @Override
    public PostreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflar el item para generar la vista de cada postre
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list_postre, parent, false);
        //Crea un objeto ViewHolder y le pasa la vista
        return new ViewHolder(view);
    }
    //Metodo que se llama para mostrar los datos en la vista
    @Override
    public void onBindViewHolder(@NonNull PostreAdapter.ViewHolder holder, int position) {
//        //Obtener el postre en la posición actual
        Postre postre = listapostres.get(position);
        //Asignar los datos del postre a la vista
        holder.NAME_DESSERT.setText(postre.getNAME_DESSERT());
        holder.NAME_CATEGORY.setText(postre.getNAME_CATEGORY());
        holder.DESCRIPTION.setText(postre.getDESCRIPTION());
        holder.DATE_ADDED.setText(postre.getDATE_ADDED());
        holder.NAME_PERSON.setText(postre.getNAME_PERSON());
        Picasso.get().load(postre.getIMAGE_URL()).into(holder.IMAGE_URL);


        //Listener para la persona que añadió el postre
        holder.NAME_PERSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Persona " + postre.getNAME_PERSON(), Toast.LENGTH_SHORT).show();
            }
        });

        //Listener para el botón ver
        holder.btn_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el fragmento ver receta
                FragmentVerReceta fragmentVerReceta = new FragmentVerReceta(postre);

                // Reemplazar el fragmento actual por el fragmento ver receta
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragmentVerReceta).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listapostres.size();
    }
    //Clase que representa la vista de cada postre
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Atributos
        private TextView NAME_DESSERT;
        private TextView NAME_CATEGORY;
        private ImageView IMAGE_URL;
        private TextView DESCRIPTION;
        private TextView DATE_ADDED;
        private TextView NAME_PERSON;
        private Button btn_ver;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asignar los atributos a los elementos de la vista
            IMAGE_URL = itemView.findViewById(R.id.IMAGE_URL);
            NAME_DESSERT = itemView.findViewById(R.id.NAME_DESSERT);
            NAME_CATEGORY = itemView.findViewById(R.id.NAME_CATEGORY);
            DESCRIPTION = itemView.findViewById(R.id.DESCRIPTION);
            DATE_ADDED = itemView.findViewById(R.id.DATE_ADDED);
            NAME_PERSON = itemView.findViewById(R.id.NAME_PERSON);
            btn_ver = itemView.findViewById(R.id.btn_ver);

        }
    }
}
