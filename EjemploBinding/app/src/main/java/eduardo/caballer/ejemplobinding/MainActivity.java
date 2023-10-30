package eduardo.caballer.ejemplobinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import eduardo.caballer.ejemplobinding.databinding.ActivityMainBinding;
import eduardo.caballer.ejemplobinding.modelos.Alumno;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcherAlumno;
    private ActivityResultLauncher<Intent> editAlumnoLauncher;
    private ArrayList<Alumno> listaAlumnos;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        listaAlumnos = new ArrayList<>();

        inicializarLauncher();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lanzar la actividad AddAlumno.
                launcherAlumno.launch(new Intent(MainActivity.this, AddAlumnoActivity.class));

            }
        });
    }

    private void inicializarLauncher() {
        launcherAlumno = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Alumno alumno = (Alumno) result.getData().getExtras().getSerializable("ALUMNO");
                                listaAlumnos.add(alumno);
                                mostrarAlumnos();
                            } else {
                                Toast.makeText(MainActivity.this, "No llegaron los datos...", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACCIÓN CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        editAlumnoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Que ocurrira cuando vuelva de la actividad EDIT.
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                //Pulsaron editar
                                Alumno alumno = (Alumno) result.getData().getExtras().getSerializable("ALUMNO");
                                listaAlumnos.set(posicion, alumno);
                                mostrarAlumnos();
                            } else {
                                // pulsaron Borrar
                                listaAlumnos.remove(posicion);
                                mostrarAlumnos();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACCIÓN CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void mostrarAlumnos() {
        //eliminar lo que haya en el linear Layout
        binding.contentMain.contnedorMain.removeAllViews();

        for (Alumno alumno : listaAlumnos) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);

            View alumnoView = layoutInflater.inflate(R.layout.alumno_fila_view, null);
            TextView txtNombre = alumnoView.findViewById(R.id.lbNombreAlumnoView);
            TextView txtApellidos = alumnoView.findViewById(R.id.lbApellidosAlumnoView);
            TextView txtCiclo = alumnoView.findViewById(R.id.lbCicloAlumnoView);
            TextView txtGrupo = alumnoView.findViewById(R.id.lbGrupoAlumnoView);

            txtNombre.setText(alumno.getNombre());
            txtApellidos.setText(alumno.getApellidos());
            txtCiclo.setText(alumno.getCiclo());
            txtGrupo.setText(String.valueOf(alumno.getGrupo()));

            alumnoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Enviar el alumno.
                    Intent intent = new Intent(MainActivity.this, EditAlumnoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ALUMNO", alumno);
                    intent.putExtras(bundle);

                    posicion = listaAlumnos.indexOf(alumno);
                    // Recibir el alumno modificado o la orden de eliminar.
                    editAlumnoLauncher.launch(intent);

                }
            });

            binding.contentMain.contnedorMain.addView(alumnoView);

        }
    }
}

