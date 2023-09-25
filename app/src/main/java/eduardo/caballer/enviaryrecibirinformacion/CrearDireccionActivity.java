package eduardo.caballer.enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eduardo.caballer.enviaryrecibirinformacion.modelos.Direccion;

public class CrearDireccionActivity extends AppCompatActivity {

    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtCiudad;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);

        inicializarVista();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calle = txtCalle.getText().toString();
                int numero = Integer.parseInt(txtNumero.getText().toString());
                String ciudad = txtCiudad.getText().toString();

                Direccion direccion = new Direccion(calle, numero, ciudad);

                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", direccion);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                //Ha funcionado bien
                setResult(RESULT_OK, intent);
                //Terminar actividad
                finish();
            }
        });
    }

    private void inicializarVista() {
        txtCalle = findViewById(R.id.txtCalleCrear);
        txtNumero = findViewById(R.id.txtNumeroCrear);
        txtCiudad = findViewById(R.id.txtCiudadCrear);
        btnCrear = findViewById(R.id.btnCrearDireccionCrear);

    }
}