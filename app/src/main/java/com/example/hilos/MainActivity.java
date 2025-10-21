package com.example.hilos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //elementos de la UI
        TextView resultado_1 = findViewById(R.id.resultado_1) ;
        Button boton_1 = findViewById(R.id.boton_1);

        ImageView imagen_2 = findViewById(R.id.imagen_2);
        Button boton_2 = findViewById(R.id.boton_2);

        TextView resultado_3 = findViewById(R.id.resultado_3);
        Button boton_3 = findViewById(R.id.boton_3);

        //Primer ejemplo

        boton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Crear primer Hilo
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                //Codigo que se ejecutara dentro de nuestro hilo
                                //1.- escribir texto de espera
                                resultado_1.setText("Iniciando Hilo...");
                                //2 hacer esperar 5 segundos
                                try {
                                    //3 dormir hilo
                                    Thread.sleep(5*1000);
                                    //4 al finalizar actualizar texto
                                    resultado_1.setText("Hilo Finalizado");
                                }
                                catch (Exception ex){

                                }

                            }
                        }
                );
            }
        });
    }
}