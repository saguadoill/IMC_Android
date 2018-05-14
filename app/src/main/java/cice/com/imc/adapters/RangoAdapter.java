package cice.com.imc.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import cice.com.imc.R;

public class RangoAdapter extends BaseAdapter {

    private Context context;
    private String[] rangos = {
      "IMC < 16", "IMC < 18.5",
      "IMC < 25", "IMC < 30",
      "IMC > 30"
    };
    private String[] definiciones = {
      "DESNUTRIDO", "BAJO PESO",
      "NORMAL", "SOBREPESO",
      "OBESO"
    };

    private int[] imagenesID = {R.mipmap.ic_imc_desnutrido,R.mipmap.ic_imc_bajopeso,
            R.mipmap.ic_imc_normal,R.mipmap.ic_imc_sobrepeso,R.mipmap.ic_imc_obeso
    };

    public RangoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {  // cantidad de elementos que tenemos que pintar/generar
        return definiciones.length;
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
    public View getView(int position, View convertView, ViewGroup parent) { // posicion, una lista reciclada, y un contenedor donde meterla. Lo que hay q devolver ees una vista con la informacion ya montada
        View view = null;

        // Inflate -> coger u fichero xml y lo convierto en una View
        // creamos el View de un xml, lo inflamos y le metemos la informacion y lo devolvemos

        if(convertView == null){ // si no esta ya inflada. La inflo
            Activity actividad = (Activity) context;   // transformamos el padre context a un hijo, porque context contenia un activity. downcast
            LayoutInflater layoutInflater = actividad.getLayoutInflater();  // recuperamso el inflater
            view = layoutInflater.inflate(R.layout.fila_completa, parent, false);

        }else{  // en caso contrario, le seteo la informacion
            view = convertView;
        }

        TextView texto1 = (TextView) view.findViewById(R.id.texto1);
        TextView texto2 = (TextView) view.findViewById(R.id.texto2);
        ImageView imagen = (ImageView) view.findViewById(R.id.imagen);

        texto1.setText(definiciones[position]);// la posicion se usa para esto
        texto2.setText(rangos[position]);
        imagen.setImageResource(imagenesID[position]);

        return view;
    }
}
