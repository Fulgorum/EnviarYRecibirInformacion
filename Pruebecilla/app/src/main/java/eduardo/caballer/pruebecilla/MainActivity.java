package eduardo.caballer.pruebecilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellidos;
    private EditText txtPassword;
    private Button btnPulsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();


        btnPulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    private void inicializarVariables() {
        txtNombre = findViewById(R.id.txtNombreMain);
        txtApellidos = findViewById(R.id.txtApellidosMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnPulsar = findViewById(R.id.btnPulsarMain);
    }
}