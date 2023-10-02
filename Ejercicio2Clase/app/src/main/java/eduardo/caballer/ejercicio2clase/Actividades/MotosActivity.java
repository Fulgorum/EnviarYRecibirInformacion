package eduardo.caballer.ejercicio2clase.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eduardo.caballer.ejercicio2clase.Modelos.Moto;
import eduardo.caballer.ejercicio2clase.R;

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
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()) {
                    Toast.makeText(MotosActivity.this,
                            "Tienes que rellenar los datos necesarios",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Moto moto = new Moto(marca, modelo, cilindrada);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);

                    setResult(RESULT_OK, intent);
                    Toast.makeText(MotosActivity.this, "Moto creada", Toast.LENGTH_SHORT).show();
                    finish();
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