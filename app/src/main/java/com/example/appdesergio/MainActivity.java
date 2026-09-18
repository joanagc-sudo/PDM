package com.example.appdesergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicativo.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Integer[] imagens = new Integer[]{
                R.drawable.cachorro,
                R.drawable.gardem,
                R.drawable.happy,
                R.drawable.patinho,
                R.drawable.porquinho
        };

        Button botaoVoltar, botaoAvancar;
        botaoVoltar = findViewById(R.id.btnAnterior);
        botaoAvancar =  findViewById(R.id.btnProximo);

        botaoAvancar.setOnClickListener(View v ->{
            imageView.setImageResource(imagens[posicao]);
        });
    }
}