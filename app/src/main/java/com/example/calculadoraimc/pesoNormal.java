package com.example.calculadoraimc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pesoNormal extends AppCompatActivity {

    private Button btnvoltar;
    private TextView textoMotivacional;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal);

        textoMotivacional = findViewById(R.id.textView2);
        btnvoltar = findViewById(R.id.voltar);
        btnvoltar.setOnClickListener(view ->{
            Intent voltar = new Intent(this, MainActivity.class);
            startActivity(voltar);
        });
        Bundle bundle = getIntent().getExtras();
        Float result = bundle.getFloat("resultado");
        textoMotivacional.setText(result + "    Você encontrou um equilíbrio, e isso é incrível! Continue cultivando hábitos saudáveis, movimentando-se e nutrindo seu corpo e sua mente. Saúde não é um destino, mas uma jornada constante de bem-estar. Siga firme!    ");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}