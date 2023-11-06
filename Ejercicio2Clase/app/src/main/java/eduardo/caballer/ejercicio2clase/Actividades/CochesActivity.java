package eduardo.caballer.ejercicio2clase.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eduardo.caballer.ejercicio2clase.Modelos.Coche;
import eduardo.caballer.ejercicio2clase.R;

public class CochesActivity extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;

    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coches);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()) {
                    Toast.makeText(CochesActivity.this,
                            "Tienes que rellenar los datos necesarios",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Coche coche = new Coche(marca, modelo, color);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);

                    setResult(RESULT_OK, intent);
                    Toast.makeText(CochesActivity.this, coche.toString(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}