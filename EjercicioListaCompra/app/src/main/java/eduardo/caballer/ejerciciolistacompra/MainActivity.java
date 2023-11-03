package eduardo.caballer.ejerciciolistacompra;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import eduardo.caballer.ejerciciolistacompra.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}