package eduardo.caballer.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import eduardo.caballer.ejercicio4.Modelos.Inmueble;
import eduardo.caballer.ejercicio4.databinding.ActivityAddInmueblesBinding;

public class AddInmueblesActivity extends AppCompatActivity {


    private ActivityAddInmueblesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddInmueblesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAddCancelarInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        binding.btnAddCrearInmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Inmueble inmueble = crearInmueble();
                if (inmueble == null) {
                    Toast.makeText(AddInmueblesActivity.this, "Faltan datos...", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("INMUEBLE", inmueble);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });
    }

    private Inmueble crearInmueble() {
        if (binding.txtAddDireccionInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtAddNumeroInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtAddCiudadInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtAddProvinciaInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtAddCPInmueble.getText().toString().isEmpty()) {
            return null;
        }
        if (binding.txtAddValoracionInmueble.getRating() == 0) {
            return null;
        }
        Inmueble inmueble = new Inmueble(
                binding.txtAddDireccionInmueble.getText().toString(),
                Integer.parseInt(binding.txtAddNumeroInmueble.getText().toString()),
                binding.txtAddCiudadInmueble.getText().toString(),
                binding.txtAddProvinciaInmueble.getText().toString(),
                binding.txtAddCPInmueble.getText().toString(),
                binding.txtAddValoracionInmueble.getRating());

        return inmueble;
    }
}