package eduardo.caballer.ejercicio2clase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MotosActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCilindrada;

    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos);

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
                        || txtCilindrada.getText().toString().isEmpty()) {
                    Toast.makeText(MotosActivity.this,
                            "Tienes que rellenar los datos necesarios",
                            Toast.LENGTH_SHORT).show();
                }else {

                Toast.makeText(MotosActivity.this, "Moto creada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaMoto);
        txtModelo = findViewById(R.id.txtModeloMoto);
        txtCilindrada = findViewById(R.id.txtCilindradaMoto);

        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
    }
}