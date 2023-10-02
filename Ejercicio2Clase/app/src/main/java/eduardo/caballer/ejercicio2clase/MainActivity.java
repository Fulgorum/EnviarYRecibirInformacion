package eduardo.caballer.ejercicio2clase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

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
                launcherCoches.launch(new Intent(MainActivity.this, CochesActivity.class));
            }
        });

        launcherCoches = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null) {
                                    listaCoches.add(coche);
                                    txtCoches.setText("Coches: " + listaCoches.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY COCHE", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


        btnMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActividadCreacion(MotosActivity.class);
                launcherMotos.launch(new Intent(MainActivity.this, MotosActivity.class));
            }
        });
        launcherMotos = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null) {
                                    listaMotos.add(moto);
                                    txtMotos.setText("Motos: " + listaCoches.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY MOTO", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btnBicis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irActividadCreacion(BicisActivity.class);
                launcherBicis.launch(new Intent(MainActivity.this, BicisActivity.class));
            }
        });

        launcherBicis = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Bici bici = (Bici) result.getData().getExtras().getSerializable("BICI");
                                if (bici != null) {
                                    listaBicis.add(bici);
                                    txtBicis.setText("Bicis: " + listaBicis.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY MOTO", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
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