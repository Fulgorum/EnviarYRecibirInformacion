package eduardo.caballer.enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import eduardo.caballer.enviaryrecibirinformacion.modelos.Direccion;
import eduardo.caballer.enviaryrecibirinformacion.modelos.Usuario;

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
                Intent intent = new Intent(CrearDireccionActivity.this, DesencriptarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", direccion);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void inicializarVista() {
        txtCalle = findViewById(R.id.txtCalleDireccion);
        txtNumero = findViewById(R.id.txtNumeroDireccion);
        txtCiudad = findViewById(R.id.txtCiudadDireccion);
        btnCrear = findViewById(R.id.btnCrearDireccion);

    }
}