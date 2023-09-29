package eduardo.caballer.ejercicio2clase.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtMarca.getText().toString().isEmpty() || txtModelo.getText().toString().isEmpty()
                        || txtColor.getText().toString().isEmpty()) {
                    Toast.makeText(CochesActivity.this,
                            "Tienes que rellenar los datos necesarios",
                            Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(CochesActivity.this, "Creado", Toast.LENGTH_SHORT).show();
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