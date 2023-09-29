package eduardo.caballer.ejercicio2clase;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import eduardo.caballer.ejercicio2clase.Actividades.BicisActivity;
import eduardo.caballer.ejercicio2clase.Actividades.CochesActivity;
import eduardo.caballer.ejercicio2clase.Actividades.MotosActivity;
import eduardo.caballer.ejercicio2clase.Modelos.Bici;
import eduardo.caballer.ejercicio2clase.Modelos.Coche;
import eduardo.caballer.ejercicio2clase.Modelos.Moto;

public class MainActivity extends AppCompatActivity {
    private Button btnCoches;
    private Button btnMotos;
    private Button btnBicis;
    private TextView txtCoches;
    private TextView txtMotos;
    private TextView txtBicis;

    //Atributos de los launchers.
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    //Atributos para la lógica

    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;

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

        //inicializar lógica

        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();
    }
}