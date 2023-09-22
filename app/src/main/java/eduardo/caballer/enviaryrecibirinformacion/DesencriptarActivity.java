package eduardo.caballer.enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import eduardo.caballer.enviaryrecibirinformacion.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        //SACAR LA INFORMACIÓN QUE LLEGA
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            //String password = bundle.getString("PASS");
            Usuario usuario = (Usuario) bundle.getSerializable("USER");
            Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}