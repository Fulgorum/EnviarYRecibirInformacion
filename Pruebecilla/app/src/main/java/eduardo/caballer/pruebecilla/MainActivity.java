package eduardo.caballer.pruebecilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }

    private void inicializarVariables() {
        txtNombre
    }
}