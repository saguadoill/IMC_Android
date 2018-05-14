package cice.com.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import cice.com.imc.listeners.MostrarListaListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // un bundle es como un saquito con informacion previa
        super.onCreate(savedInstanceState);  // ejecuto el metodo del padre
        setContentView(R.layout.activity_main); // y hago algo mas. en este caso mostrar el layout activity_mani


        final EditText altura = findViewById(R.id.altura);  // creamos el objeto y le indicamos que objeto es. (lo de final indica que la instancia de objeto no varia, pero si el contenido.)
        final EditText peso = findViewById(R.id.peso);
        Button calcula = findViewById(R.id.calcula);
        Button mostrarLista = findViewById(R.id.mostrar_lista);
        final TextView resultado = findViewById(R.id.resultado);

        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alturaDada = altura.getText().toString();
                String pesoDado = peso.getText().toString();

                if (!alturaDada.isEmpty() && !pesoDado.isEmpty()){
                   try{
                       double alturaNum = Double.parseDouble(alturaDada);
                       double pesoNum = Double.parseDouble(pesoDado);

                       double resultadoIMC =pesoNum / (alturaNum * alturaNum);

                       resultado.setText(String.valueOf((int) resultadoIMC));  // redondeando de forma cutre?

                   }catch (Throwable e){  // en Android como tenemos acceso al sistema, en los codigos de error, normalmente se usa Throuwable
                       Toast.makeText(MainActivity.this, "No has introducido números", Toast.LENGTH_LONG).show();
                   }
                }else{
                    Toast.makeText(MainActivity.this, "No has introducido los dos campos", Toast.LENGTH_LONG).show();
                }
            }
        });

        MostrarListaListener mostrarListaListener = new MostrarListaListener(this); // le pasamos el Contexto, desde donde se va a lanzar el listener, en este caso desde aqui
        mostrarLista.setOnClickListener(mostrarListaListener); // al boton le pasamos el listener


    }
}
