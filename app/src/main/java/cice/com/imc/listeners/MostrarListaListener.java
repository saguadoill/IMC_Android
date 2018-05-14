package cice.com.imc.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import cice.com.imc.ListaActivity;
import cice.com.imc.MainActivity;

public class MostrarListaListener implements View.OnClickListener {

    Context context;

    public MostrarListaListener(Context context) {   // polimorfismo, Context es padre de Activity
        this.context = context;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(context, ListaActivity.class);  // un intento de mostrar/lanzar algo, , para lanzar otra ventana. En este caso, hay q pasarle el Contexto(desde que actividad estamos llamando a esto)
                                                                    // segundo parametro la actividad nueva que queremos lanzar. Desde donde....y que mostramos
        context.startActivity(intent);  // al contexto, le pasamos el intent


    }
}
