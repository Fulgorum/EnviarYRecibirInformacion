package eduardo.caballer.ejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import eduardo.caballer.ejercicio4.Modelos.Inmueble;
import eduardo.caballer.ejercicio4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcherInmueble;
    private ActivityResultLauncher<Intent> editInmueblelauncher;
    private ArrayList<Inmueble> listaInmuebles;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        listaInmuebles = new ArrayList<>();

        inicializarLauncher();


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherInmueble.launch(new Intent(MainActivity.this, AddInmueblesActivity.class));
            }
        });
    }

    private void inicializarLauncher() {

        launcherInmueble = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Inmueble inmueble = (Inmueble) result.getData().getExtras().getSerializable("INMUEBLE");
                                listaInmuebles.add(inmueble);
                                mostrasInmuebles();
                            } else {
                                Toast.makeText(MainActivity.this, "No han llegado los datos...", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Acción Cancelada!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        editInmueblelauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Inmueble inmueble = (Inmueble) result.getData().getExtras().getSerializable("INMUEBLE");
                                listaInmuebles.set(posicion, inmueble);
                                mostrasInmuebles();
                            } else {
                                Toast.makeText(MainActivity.this, "ACCIÓN CANCELADA", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
    }

    private void mostrasInmuebles() {

        binding.contentMain.contenedorMain.removeAllViews();

        for (Inmueble inmueble : listaInmuebles) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);

            View inmuebleView = layoutInflater.inflate(R.layout.inmueble_fila_view, null);
            TextView txtDireccion = inmuebleView.findViewById(R.id.lbDireccionInmubleView);
            TextView txtNumero = inmuebleView.findViewById(R.id.lbNumeroInmubleView);
            TextView txtCiudad = inmuebleView.findViewById(R.id.lbCiudadInmubleView);
            RatingBar txtValoracion = inmuebleView.findViewById(R.id.lbValoracionInmubleView);

            txtDireccion.setText(inmueble.getDireccion());
            txtNumero.setText(String.valueOf(inmueble.getNumero()));
            txtCiudad.setText(inmueble.getCiudad());
            txtValoracion.setRating(inmueble.getValoracion());

            binding.contentMain.contenedorMain.addView(inmuebleView);
        }

    }


}