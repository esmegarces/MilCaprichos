package com.example.milcaprichos;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.squareup.picasso.Picasso;


public class FragmentVerReceta extends Fragment {
    private Postre postre;
    private TextView NAME_DESSERT;
    private TextView DESCRIPTION;
    private TextView DATE_ADDED;
    private ImageView IMAGE_DESSERT;
    private ChipGroup chipGroup;




    public FragmentVerReceta(Postre postre) {
        this.postre = postre;


    }


        @SuppressLint("MissingInflatedId")
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){


            // Inflate the layout for this fragment
           View view =  inflater.inflate(R.layout.fragment_ver_receta, container, false);
            NAME_DESSERT = view.findViewById(R.id.NAME_DESSERT);
            DESCRIPTION = view.findViewById(R.id.DESCRIPTION);
            DATE_ADDED = view.findViewById(R.id.DATE_ADDED);
            IMAGE_DESSERT = view.findViewById(R.id.IMAGE_DESSERT);
            chipGroup = view.findViewById(R.id.chipGroup);

            NAME_DESSERT.setText(postre.getNAME_DESSERT());
            DESCRIPTION.setText(postre.getDESCRIPTION());
            DATE_ADDED.setText(postre.getDATE_ADDED());
            Picasso.get().load(postre.getIMAGE_URL()).into(IMAGE_DESSERT);
            chipGroup.removeAllViews();


            for (int i = 0; i < postre.getIngredientes().size(); i++) {
                Ingrediente ingredient = postre.getIngredientes().get(i);
                Chip chip = new Chip(getContext());
                chip.setText(ingredient.getNAME_INGREDIENT() + " " + ingredient.getQUANTITY()+ " " + ingredient.getMEASURE());
                chip.setCheckable(false);
                chip.setClickable(false);
                chipGroup.addView(chip);
            }
           return view;

        }
    }