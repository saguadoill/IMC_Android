package cice.com.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import cice.com.imc.adapters.RangoAdapter;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListAdapter listAdapter = new ArrayAdapter<String>(this,R.layout.fila, generarLista()); // contexto(desde donde se va a lanzar), recurso(el id item para meterle los datos y elegir como sale en pantalla), y los datos que le pasamos(el array)
        ListView lv = findViewById(R.id.lista_ramgos);  // capturamos la vista de la lista
//        lv.setAdapter(listAdapter); // le pasamos el adaptador

        RangoAdapter rangoAdapter = new RangoAdapter(this);
        lv.setAdapter(rangoAdapter);

    }

    private String[] generarLista(){
        String[] array = new String[20];

        for (int i = 0; i < array.length ; i++) {
            array[i] = "elemento" + i;
        }

        return array;
    }

}
