package eduardo.caballer.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import eduardo.caballer.ejercicio4.Modelos.Inmueble;
import eduardo.caballer.ejercicio4.databinding.ActivityEditInmubleBinding;

public class EditInmubleActivity extends AppCompatActivity {

    private ActivityEditInmubleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditInmubleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Inmueble inmueble = (Inmueble) bundle.getSerializable("INMUEBLE");

        rellenarInfo(inmueble);


        binding.btnEditCrearInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Inmueble inmu = crearInmueble();

                if (inmu != null) {
                    Intent intentVolver = new Intent();
                    Bundle bundleVolver = new Bundle();
                    bundleVolver.putSerializable("INMUEBLE", inmu);
                    intentVolver.putExtras(bundleVolver);
                    setResult(RESULT_OK, intentVolver);
                    finish();
                } else {
                    Toast.makeText(EditInmubleActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.btnEditEliminarInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    private Inmueble crearInmueble() {
        if (binding.txtEditDireccionInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtEditNumeroInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtEditCiudadInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtEditProvinciaInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtEditCPInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtEditValoracionInmueble.getRating() == 0) {
            return null;
        }

        return new Inmueble(
                binding.txtEditDireccionInmueble.getText().toString(),
                Integer.parseInt(binding.txtEditNumeroInmueble.getText().toString()),
                binding.txtEditCiudadInmueble.getText().toString(),
                binding.txtEditProvinciaInmueble.getText().toString(),
                binding.txtEditCPInmueble.getText().toString(),
                binding.txtEditValoracionInmueble.getRating());
    }

    private void rellenarInfo(Inmueble inmueble) {
        binding.txtEditDireccionInmueble.setText(inmueble.getDireccion());
        binding.txtEditNumeroInmueble.setText(String.valueOf(inmueble.getNumero()));
        binding.txtEditCiudadInmueble.setText(inmueble.getCiudad());
        binding.txtEditProvinciaInmueble.setText(inmueble.getProvincia());
        binding.txtEditCPInmueble.setText(inmueble.getCp());
        binding.txtEditValoracionInmueble.setRating(inmueble.getValoracion());

    }
}