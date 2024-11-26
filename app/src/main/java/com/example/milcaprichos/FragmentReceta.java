package com.example.milcaprichos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class FragmentReceta extends Fragment {

    //Atributos
    private RecyclerView recyclerReceta;
    private PostreAdapter postreAdapter;
    private ArrayList<Postre> listapostres;
    private RequestQueue requestQueue;


    public FragmentReceta() {
    }



    //Metodo que se llama cuando se crea la vista
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receta, container, false);

        //Asociamos el atributo recyclerReceta de mi clase FragmentReceta con el fragment View de mi vista
        recyclerReceta = view.findViewById(R.id.recyclerReceta);
        listapostres = new ArrayList<>();
        postreAdapter = new PostreAdapter(listapostres, getActivity());
        recyclerReceta.setAdapter(postreAdapter);
        requestQueue = Volley.newRequestQueue(getActivity());
        recyclerReceta.setLayoutManager(new LinearLayoutManager(getActivity()));
        obtenerReceta();
        return view;
    }


    public void obtenerReceta() {


        String endpoint = getString(R.string.base_url) + "detalles_postres";

        //Creando objeto de petición
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, endpoint, null,
                response -> {
                    try {
                        JSONArray postreRequestsArray = response.getJSONArray("Postres");

                        //Limpiar la lista de nuestros postres
                        listapostres.clear();


                        for (int i = 0; i < postreRequestsArray.length(); i++) {
                            JSONObject postreObject = postreRequestsArray.getJSONObject(i);
                            int ID = postreObject.getInt("ID");
                            String NAME_DESSERT = postreObject.getString("NAME_DESSERT");
                            String NAME_CATEGORY = postreObject.getString("NAME_CATEGORY");
                            String IMAGE_URL = getString(R.string.url_images) + postreObject.getString("IMAGE_URL");
                            JSONArray INGREDIENTS = postreObject.getJSONArray("INGREDIENTS");
                            String DESCRIPTION = postreObject.getString("DESCRIPTION");
                            String DATE_ADDED = postreObject.getString("DATE_ADDED");
                            String NAME_PERSON = postreObject.getString("NAME_PERSON");


                            ArrayList<Ingrediente> ingredientes = new ArrayList<>();

                            //Arreglo de ingredientes
                            for (int a = 0; a < INGREDIENTS.length(); a++) {
                                JSONObject ingredienteObject = INGREDIENTS.getJSONObject(a);
                                String MEASURE = ingredienteObject.getString("MEASURE");
                                int QUANTITY = ingredienteObject.getInt("QUANTITY");
                                int ID_INGREDIENT = ingredienteObject.getInt("ID_INGREDIENT");
                                String NAME_INGREDIENT = ingredienteObject.getString("NAME_INGREDIENT");

                                Ingrediente ingrediente = new Ingrediente(ID_INGREDIENT,NAME_INGREDIENT,MEASURE,QUANTITY);
                                ingredientes.add(ingrediente);


                            }

                            Postre postre = new Postre(ID,NAME_DESSERT,NAME_CATEGORY,IMAGE_URL,DESCRIPTION,DATE_ADDED,NAME_PERSON,ingredientes);
                            listapostres.add(postre);

                        }
                        //Notificar al adaptador que los datos han cambiado
                        postreAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();


                    }
                },
                error -> {
                    String errorMessage = "error en la conexion: ";
                    if (error.networkResponse != null) {
                        // Agregar código de estado HTTP a la descripción del error
                        errorMessage += "Código HTTP " + error.networkResponse.statusCode + ". ";
                        // Obtener el cuerpo de la respuesta de error, si está disponible
                        if (error.networkResponse.data != null) {
                            try {
                                String responseBody = new String(error.networkResponse.data, "UTF-8");
                                errorMessage += "Respuesta del servidor: " + responseBody;
                            } catch (Exception e) {
                                errorMessage += "Error al leer el cuerpo de la respuesta.";
                            }
                        }
                    } else if (error.getCause() != null) {
                        // Imprimir la excepción subyacente
                        errorMessage += error.getCause().getMessage();
                    } else {
                        errorMessage += "Error desconocido.";
                    }
                    // Mostrar el mensaje de error detallado en un Toast
                    Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                });

        //Agregando la petición a la lista de peticiones
        requestQueue.add(request);


    }




}