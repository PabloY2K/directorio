package cl.ucn.disc.dsm.directorio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final RecyclerView recyclerView = findViewById<>(R.id.am_rv_funcionarios);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        this.funcionarioAdapter = new FuncionarioAdapter();
        recyclerView.setAdapter(this.funcionarioAdapter);

    FuncionarioViewModel funcionarioViewModelo = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(this.getApplication())
            .create(FuncionarioViewModel.class);

        funcionarioViewModel.getFuncionarios().observe(this, funcionarios -> {
        funcionarioAdapter.setFuncionarios(funcionarios);
        funcionarioAdapter.notifyDataSetChanged();

    });



}