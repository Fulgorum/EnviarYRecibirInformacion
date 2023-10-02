package eduardo.caballer.ejercicio2clase.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eduardo.caballer.ejercicio2clase.Modelos.Bici;
import eduardo.caballer.ejercicio2clase.R;

public class BicisActivity extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicis);

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
                String pulgadas = txtPulgadas.getText().toString();

                if (marca.isEmpty() || pulgadas.isEmpty()) {
                    Toast.makeText(BicisActivity.this,
                            "Tienes que rellenar los datos necesarios",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Bici bici = new Bici(marca, pulgadas);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);

                    setResult(RESULT_OK, intent);
                    Toast.makeText(BicisActivity.this, "Bici creada", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void inicializarVista() {

        txtMarca = findViewById(R.id.txtMarcaBici);
        txtPulgadas = findViewById(R.id.txtPulgadaBici);

        btnCancelar = findViewById(R.id.btnCancelarBici);
        btnCrear = findViewById(R.id.btnCrearBici);
    }
}