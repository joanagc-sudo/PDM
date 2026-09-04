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

        Button b=findViewById(R.id.Button);
        TextView tv=findViewById(R.id.TextView);
        EditText edMin= findViewById(R.id.edmin);
        EditText edMax= findViewById(R.id.edmax);

        b.setOnClickListener(view -> {
            //contador = (int)(Math.random() *100);
            String maxStr =edMax.getText().toString();
            String minStr =edMin.getText().toString();

            if(minStr.isEmpty()){
                edMin.setError("Informe o valor mínimo");
                return;
            }
            if(maxStr.isEmpty()){
                edMax.setError("Informe o valor máximo");
                return;
            }

            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            Random random= new Random();
            int r = (random.nextInt(max-min)) + min;

            tv.setText(Integer.toString(r));
            b.setText("Plin");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("valor", r);
            startActivity(intent);
        });




    }
}