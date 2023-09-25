package eduardo.caballer.enviaryrecibirinformacion;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import eduardo.caballer.enviaryrecibirinformacion.modelos.Direccion;
import eduardo.caballer.enviaryrecibirinformacion.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtPassword;
    private Button btnDesencriptar;
    private EditText txtEmail;
    private Button crearDireccion;

    private final int DIRECCIONES = 123;
    private ActivityResultLauncher<Intent> launcherDirecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();
        inicializarLauncher();

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = txtPassword.getText().toString();
                String email = txtEmail.getText().toString();
                Usuario usuario = new Usuario(email, password);

                Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                //ENVIAR INFORMACIÓN A LA SIGUIENTE ACTIVIDAD
                Bundle bundle = new Bundle();
                //bundle.putString("PASS", password);
                bundle.putSerializable("USER", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        crearDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearDireccionActivity.class);
                // startActivity(intent);
                // startActivityForResult(intent, DIRECCIONES);
                launcherDirecciones.launch(intent);
            }
        });
    }

    private void inicializarLauncher() {
        //Registrar una actividad de retorno con dos partes
        //1 - Como lanzo la actividad hija (equivalente al (startActivityForResult).
        //2 - Que hago cuando la hija termina (equivalente al onActivityResult).
        launcherDirecciones = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null) {
                                Bundle bundle = result.getData().getExtras();
                                Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                                Toast.makeText(MainActivity.this, direccion.toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    // requestCode -> identificador de la ventana o actividad que se ha cerrado.
    // resultCode -> el modo en que se ha cerrado.
    // data -> Datos retornados (intent con el bundle dentro,
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Averiguar que actividad se cerró.
        if (requestCode == DIRECCIONES) {
            //Averiguar si se cerró con éxito.
            if (resultCode == RESULT_OK) {
                //Averiguar si vuelve con datos.
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                    Toast.makeText(this, direccion.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "CANCELADA", Toast.LENGTH_SHORT).show();
            }
        }
    }
    */


    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        crearDireccion = findViewById(R.id.btnCrearDireccionMain);
    }
}