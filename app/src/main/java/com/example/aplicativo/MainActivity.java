package com.example.aplicativo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edNome;
    Button btnInserir;
    ArrayList <String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnInserir = findViewById(R.id.btnInserir);
        edNome = findViewById(R.id.edNome);
        nomes = new ArrayList<>();
        ListView lv = findViewById(R.id.listView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayAdapter <String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.item_lista, R.id.textView, nomes);
        lv.setAdapter(adapter);

        btnInserir.setOnClickListener( v -> {

            String nome = edNome.getText().toString();
            nomes.add(nome);
            adapter.notifyDataSetChanged();

            lv.setOnItemClickListener((parent, view, position, id) -> {
                    Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show();
                });
            });

        }
    }
