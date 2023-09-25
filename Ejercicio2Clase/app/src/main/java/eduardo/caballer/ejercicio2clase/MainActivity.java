package eduardo.caballer.ejercicio2clase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnCoches;
    private Button btnMotos;
    private Button btnBicis;
    private TextView txtCoches;
    private TextView txtMotos;
    private TextView txtBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();
        btnCoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActividadCreacion(CochesActivity.class);
            }
        });

        btnMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActividadCreacion(MotosActivity.class);
            }
        });

        btnBicis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActividadCreacion(BicisActivity.class);
            }
        });
    }

    private void irActividadCreacion(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }

    private void inicializarVista() {

        btnCoches = findViewById(R.id.btnCocheMain);
        btnMotos = findViewById(R.id.btnMotoMain);
        btnBicis = findViewById(R.id.btnBiciMain);

        txtCoches = findViewById(R.id.txtCochesMain);
        txtMotos = findViewById(R.id.txtMotosMain);
        txtBicis = findViewById(R.id.txtBicisMain);
    }
}